package com.github.alpac044.forwarder.discord;

import com.github.alpac044.forwarder.AbstractSession;
import com.github.alpac044.forwarder.discord.utils.Messages;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class ChannelSession extends AbstractSession {
    private TextChannel channel;
    private List<String> prevMessages;
    private Message lastMsg;
    public ChannelSession(long id, DiscordBot bot, long channelId) {
        super(id);
        channel = bot.getChannelById(channelId);
        new Thread(() -> {
            try {
                List<Message> messages = channel.getIterableHistory().takeAsync(1000).get();
                lastMsg = messages.get(0);
                prevMessages = messages.stream()
                        .map(m -> m.getAuthor().getName() + ": " + m.getContentDisplay()).collect(Collectors.toList());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public List<String> buffer() {
        return List.copyOf(prevMessages);
    }

    @Override
    public void sendLine(String s) {
        Messages.sendMessage(channel, s);
    }

    @Override
    public String get(int pos) {
        return prevMessages.get(pos);
    }

    @Override
    public List<String> updateBuffer() {
        //Newest to oldest
        List<String> pushedOut = new ArrayList<>();
        MessageHistory msgHist = channel.getHistoryAfter(lastMsg.getIdLong(), 100).complete();
        List<Message> retHist = msgHist.getRetrievedHistory();
        lastMsg = retHist.get(0);
        //Push out the bottom, add to the top
        while (!retHist.isEmpty()) {
            Message toPush = retHist.get(0);
            pushedOut.add(prevMessages.remove(prevMessages.size() - 1));
            prevMessages.add(0, toPush.getAuthor().getName() + ": " + toPush.getContentDisplay());
            retHist.remove(toPush);
        }
        return pushedOut;
    }
}
