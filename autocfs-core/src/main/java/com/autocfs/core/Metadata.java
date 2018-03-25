package com.autocfs.core;

import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * autocfs://type:source:data
 * autocfs://folder:source:data
 */
public interface Metadata {
    public String getSourceAsString();
    public String getSourceAsString(Charset charset);
    public String getDataAsString();
    public String getDataAsString(Charset charset);

    public InputStream getSourceAsInputStream();

    public InputStream getDataAsInputStream();

    public String toUriSource();
    public String toUriData();
}
