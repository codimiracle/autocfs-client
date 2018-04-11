package com.autocfs.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DynamicCopier implements Copier {
    private long transferred = 0;
    private int lastTransferred;
    private byte[] buffered;
    private InputStream input;
    private OutputStream output;

    public DynamicCopier(InputStream input, OutputStream output) {
        this.input = input;
        this.output = output;
    }

    private byte[] getBuffer() {
        if (buffered == null) {
            buffered = new byte[(int) (Math.random() * 1024) + 1024];
        }
        return buffered;
    }

    @Override
    public long getTransferred() {
        return transferred;
    }

    @Override
    public int getLastTransferred() {
        return lastTransferred;
    }

    @Override
    public Transferable transfer() throws IOException {
        byte[] buffer = getBuffer();
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
