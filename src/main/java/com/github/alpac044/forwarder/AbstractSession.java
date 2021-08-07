package com.github.alpac044.forwarder;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSession implements Session{
    private List<String> list = new ArrayList<>();
    private boolean isTerminated = false;
    private long id;
    public AbstractSession(long id){
        this.id = id;
    }
    @Override
    public List<String> buffer() {
        return List.copyOf(list);
    }

    @Override
    public void sendLine(String s) {

    }

    @Override
    public long id() {
        return id;
    }

    @Override
    public boolean isTerminated() {
        return isTerminated;
    }

    @Override
    public void terminate() {
        isTerminated = true;
    }

    @Override
    public String get(int pos) {
        return list.get(pos);
    }
}
