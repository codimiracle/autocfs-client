package com.autocfs.core;

import com.google.common.base.Preconditions;


public class MimeTypeConventionHandler implements ConventionHandler {
    @Override
    public void handle(MetadataDescriptor descriptor) {
        descriptor = Preconditions.checkNotNull(descriptor);
        if (!descriptor.getMetadataType().equals("file")) {
            throw new IllegalArgumentException("MimeType convention handler only accept 'file' descriptor");
        }
        Metadata metadata = descriptor.getMetadata();
        String source = metadata.getSourceAsString();
        String mimeType = metadata.getDataAsString();
        System.out.println("archive " + source + " to " + mimeType );
    }
}
