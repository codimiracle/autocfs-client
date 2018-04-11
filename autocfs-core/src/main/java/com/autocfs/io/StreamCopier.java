package com.autocfs.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamCopier implements Copier{
    private long transferred = 0;
    private int lastTransferred;
    private byte[] buffer;
    private InputStream input;
    private OutputStream output;

    public StreamCopier(InputStream input, OutputStream output) {
        this(input, output, 1024);
    }

    public StreamCopier(InputStream input, OutputStream output, int bufferSize) {
        this.input = input;
        this.output = output;
        this.buffer = new byte[bufferSize];
    }

    @Override
    public long getTransferred() {
        return transferred;
    }

    public int getLastTransferred() {
        return lastTransferred;
    }

    public Transferable transfer() throws IOException {
        lastTransferred = input.read(buffer);
        if (lastTransferred != -1) {
            transferred += lastTransferred;
            output.write(buffer, 0, lastTransferred);
            output.flush();
            return this;
        }
        return null;
    }
}
