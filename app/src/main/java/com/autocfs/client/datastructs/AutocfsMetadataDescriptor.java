package com.autocfs.client.datastructs;

import java.io.InputStream;

/**
 * Created by Codimiracle on 2018/3/23.
 */

public class AutocfsMetadataDescriptor extends AbstractMetadataDescriptor {
    private Metadata metadata;
    private String type;

    public AutocfsMetadataDescriptor(String type, Metadata metadata) {
        this.type = type;
        this.metadata = metadata;
    }

    @Override
    public String getMetadataType() {
        return type;
    }

    @Override
    public Metadata getMetadata() {
        return metadata;
    }

}
