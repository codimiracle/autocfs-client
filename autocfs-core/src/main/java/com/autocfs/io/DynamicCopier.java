package com.autocfs.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DynamicCopier implements Copier {
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
    public long transfer() throws IOException {
        byte[] buffer = getBuffer();
        int read = input.read(buffer);
        if (read != -1) {
            output.write(buffer, 0, read);
            output.flush();
        }
        return read;
    }
}
