package com.autocfs.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamCopier implements Copier{
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

    public long transfer() throws IOException {
        int read = input.read(buffer);
        if (read != -1) {
            output.write(buffer, 0, read);
            output.flush();
        }
        return read;
    }
}
