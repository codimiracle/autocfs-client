package com.autocfs.core;

import com.google.common.base.Preconditions;


public class MimeTypeConvention extends AbstractCovention {


    public MimeTypeConvention(MetadataDescriptor descriptor) {
        super(descriptor);
    }

    public void handle(MetadataDescriptor descriptor) {
        descriptor = Preconditions.checkNotNull(descriptor);
        if (!descriptor.getMetadataType().equals("file")) {
            throw new IllegalArgumentException("MimeType convention handler only accept 'file' descriptor");
        }
        Metadata metadata = descriptor.getMetadata();
        String source = metadata.getSourceAsString();
        String mimeType = metadata.getDataAsString();
        MimeType mt = MimeType.getMimeType(mimeType);

        publishStartedMessage(descriptor);
        for (int i = 1; i <= 1000; i++) {
            publishMessage(descriptor, (i / 1000.0f));

        }
        publishFinishedMessage(descriptor, 0x00);
    }
}
