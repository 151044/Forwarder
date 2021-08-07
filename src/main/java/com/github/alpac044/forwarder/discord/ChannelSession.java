package com.github.alpac044.forwarder.discord;

import com.github.alpac044.forwarder.AbstractSession;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;

public class ChannelSession extends AbstractSession {
    private TextChannel channel;
    public ChannelSession(long id, DiscordBot bot, long channelId) {
        super(id);
        channel = bot.getChannelById(channelId);
    }

    @Override
    public List<String> buffer() {
        return null;
    }

    @Override
    public void sendLine(String s) {

    }

    @Override
    public long id() {
        return 0;
    }

    @Override
    public String get(int pos) {
        return null;
    }

    @Override
    public String updateBuffer() {
        return null;
    }
}
