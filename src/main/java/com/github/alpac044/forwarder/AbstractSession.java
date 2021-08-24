package com.github.alpac044.forwarder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSession implements Session{
    private boolean isTerminated = false;
    private long id;
    public AbstractSession(long id){
        this.id = id;
    }

    @Override
    public void sendLine(String s) throws IOException {

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

}
