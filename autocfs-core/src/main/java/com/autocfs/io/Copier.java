package com.autocfs.io;

import java.io.IOException;

public interface Copier extends Transferable {

    public int getLastTransferred();
    @Override
    Transferable transfer() throws IOException;
}
