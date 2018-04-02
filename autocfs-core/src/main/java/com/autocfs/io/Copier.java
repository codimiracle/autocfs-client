package com.autocfs.io;

import java.io.IOException;

public interface Copier {
    public long transfer() throws IOException;
}
