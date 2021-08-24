package com.github.alpac044.forwarder.process;

import com.github.alpac044.forwarder.AbstractSession;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProcessSession extends AbstractSession {
    private BufferedWriter writer;
    private BufferedReader reader;
    private Process proc;
    private List<String> buffer;

    public ProcessSession(long id, Process proc) {
        super(id);
        this.proc = proc;
        writer = new BufferedWriter(new OutputStreamWriter(proc.getOutputStream()));
        reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
    }
    @Override
    public List<String> updateBuffer() throws IOException {
        List<String> toAdd = new ArrayList<>();
        while(reader.ready()) {
            String read = reader.readLine();
            toAdd.add(read);
        }
        buffer.addAll(toAdd);
        return toAdd;
    }

    @Override
    public List<String> buffer() {
        return buffer;
    }

    @Override
    public void sendLine(String s) throws IOException {
        writer.write(s);
    }

    @Override
    public void terminate() {
        super.terminate();
    }

    @Override
    public String get(int pos) {
        return null;
    }
}
