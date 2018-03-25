package com.autocfs.core;

public interface MetadataDescriptor {

    public static final String PROTOCOL = "autocfs";

    public String getMetadataType();
    public Metadata getMetadata();
    public String toUri();
}
