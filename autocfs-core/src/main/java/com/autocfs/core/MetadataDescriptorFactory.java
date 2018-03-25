package com.autocfs.core;

import java.io.File;
import java.io.InputStream;

public interface MetadataDescriptorFactory {
    public MetadataDescriptor getDescriptor(File source);
    public MetadataDescriptor getDescriptor(String metadataType, String source, String data);
    public MetadataDescriptor getDescriptor(String metadataType, InputStream source, InputStream data);
}
