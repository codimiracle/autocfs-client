package com.autocfs.core;

/**
 * Created by Codimiracle on 2018/3/23.
 */

public abstract class AbstractMetadataDescriptor implements MetadataDescriptor {

    @Override
    public String toUri() {
        return PROTOCOL + "://" + getMetadataType() + ":" + getMetadata().toUriSource() + ":" + getMetadata().toUriData();
    }
}
