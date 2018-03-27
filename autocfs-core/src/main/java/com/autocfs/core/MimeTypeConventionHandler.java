package com.autocfs.core;

import com.google.common.base.Preconditions;


public class MimeTypeConventionHandler extends AbstractListenableConventionHandler {
    @Override
    public void handle(MetadataDescriptor descriptor) {
        descriptor = Preconditions.checkNotNull(descriptor);
        if (!descriptor.getMetadataType().equals("file")) {
            throw new IllegalArgumentException("MimeType convention handler only accept 'file' descriptor");
        }
        Metadata metadata = descriptor.getMetadata();
        String source = metadata.getSourceAsString();
        String mimeType = metadata.getDataAsString();
        for (int i = 1; i <= 1000; i++) {
            publishMessage(descriptor, (i / 1000.0f));
        }
        System.out.println("archiving...." + source + " to " + mimeType );
    }


}
