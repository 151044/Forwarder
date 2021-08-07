package com.github.alpac044.forwarder.discord;

import com.github.alpac044.forwarder.AbstractSession;

import java.util.List;

public class ChannelSession extends AbstractSession {

    public ChannelSession(long id) {
        super(id);
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
