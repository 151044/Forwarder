package com.github.alpac044.forwarder;

import java.io.IOException;
import java.util.List;

public interface Session {
    List<String> buffer();
    void sendLine(String s) throws IOException;
    long id();
    boolean isTerminated();
    void terminate();
    String get(int pos);
    List<String> updateBuffer() throws IOException;
}
