package com.autocfs.client.datastructs;

import static com.google.common.base.Preconditions.checkNotNull;

public class AbstractConvention implements Convention {

    private MetadataDescriptor descriptor;
    private ConventionHandler handler;

    public AbstractConvention(MetadataDescriptor descriptor) {
        this(descriptor, null);
    }

    public AbstractConvention(MetadataDescriptor descriptor, ConventionHandler handler) {
        this.descriptor = checkNotNull(descriptor);
        this.handler = handler;
    }

    @Override
    public MetadataDescriptor getDescriptor() {
        return descriptor;
    }

    public void setHandler(ConventionHandler handler) {
        this.handler = handler;
    }
    @Override
    public ConventionHandler getHandler() {
        return handler;
    }
}
