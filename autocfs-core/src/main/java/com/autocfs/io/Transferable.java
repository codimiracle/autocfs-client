package com.autocfs.io;

public interface Transferable {
    public long getTransferred();
    public Transferable transfer() throws Throwable;
}
