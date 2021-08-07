package com.github.alpac044.forwarder.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import javax.security.auth.login.LoginException;

public class DiscordBot {
    private JDA jda;
    public DiscordBot(String token) throws LoginException, InterruptedException {
        jda = JDABuilder.createDefault(token).build().awaitReady();
    }

    public JDA getJda() {
        return jda;
    }

    public TextChannel getChannelById(long id){
        return jda.getTextChannelById(id);
    }
}
