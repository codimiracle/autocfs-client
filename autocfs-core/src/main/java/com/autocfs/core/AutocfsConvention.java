package com.autocfs.core;

/**
 * Created by Codimiracle on 2018/3/24.
 */

public class AutocfsConvention extends AbstractCovention {

    private ConventionHandler handler;

    public AutocfsConvention(MetadataDescriptor descriptor) {
        super(descriptor);
    }

    public AutocfsConvention(MetadataDescriptor descriptor, ConventionHandler handler) {
        super(descriptor);
        this.handler = handler;
    }

    public void setHandler(ConventionHandler handler) {
        this.handler = handler;
    }

    public ConventionHandler getHandler() {
        return handler;
    }
}
