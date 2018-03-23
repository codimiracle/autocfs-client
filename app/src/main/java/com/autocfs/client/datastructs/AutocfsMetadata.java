package com.autocfs.client.datastructs;

import java.io.InputStream;

/**
 * Created by Codimiracle on 2018/3/23.
 */

public class AutocfsMetadata extends AbstractMetadata {

    public AutocfsMetadata(String source, String data) {
        super(source, data);
    }

    public AutocfsMetadata(InputStream source, InputStream data) {
        super(source, data);
    }
}
