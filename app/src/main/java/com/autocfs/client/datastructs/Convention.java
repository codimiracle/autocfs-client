package com.autocfs.client.datastructs;

public interface Convention {
    public MetadataDescriptor getDescriptor();
    public void setHandler(ConventionHandler handler);
    public ConventionHandler getHandler();
}
