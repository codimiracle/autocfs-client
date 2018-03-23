package com.autocfs.client.datastructs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by Codimiracle on 2018/3/23.
 */

public abstract class AbstractMetadata implements Metadata {

    private String dataAsString;
    private String sourceAsString;
    private InputStream dataAsStream;
    private InputStream sourceAsStream;

    public AbstractMetadata(String source, String data) {
        this(new ByteArrayInputStream(source.getBytes()), new ByteArrayInputStream(data.getBytes()));
        this.sourceAsString = source;
        this.dataAsString = data;
    }

    public AbstractMetadata(InputStream source, InputStream data) {
        this.sourceAsStream = source;
        this.dataAsStream = data;
    }

    private String parseString(InputStream stream, Charset charset) throws IOException {
        InputStreamReader reader = new InputStreamReader(stream, charset);
        StringBuilder builder = new StringBuilder();
        char[] buffer = new char[2048];
        int length = 0;
        while ((length = reader.read(buffer)) != -1) {
            builder.append(buffer, 0, length);
        }
        return builder.toString();
    }

    @Override
    public String getSourceAsString(Charset charset) {
        if (charset != Charset.defaultCharset()) {
            try {
                return parseString(this.sourceAsStream, charset);
            } catch (IOException e) {
                return null;
            }
        }
        if (sourceAsString == null && charset == Charset.defaultCharset()) {
            try {
                this.sourceAsString = parseString(this.sourceAsStream, Charset.defaultCharset());
            } catch (IOException e) {
                return null;
            }
        }
        return this.sourceAsString;
    }

    @Override
    public String getSourceAsString() {

        if (this.sourceAsString == null) {
            return this.getSourceAsString(Charset.defaultCharset());
        }
        return this.sourceAsString;
    }


    @Override
    public String getDataAsString() {
        if (dataAsString == null) {
            return this.getSourceAsString(Charset.defaultCharset());
        }
        return dataAsString;
    }

    @Override
    public String getDataAsString(Charset charset) {
        if (charset != Charset.defaultCharset()) {
            try {
                return parseString(dataAsStream, charset);
            } catch (IOException e) {
                return null;
            }
        }
        if (this.dataAsString == null && charset == Charset.defaultCharset()) {
            try {
                this.dataAsString = parseString(dataAsStream, Charset.defaultCharset());
            } catch (IOException e) {
                return null;
            }

        }
        return dataAsString;
    }

    @Override
    public InputStream getSourceAsInputStream() {
        return sourceAsStream;
    }

    @Override
    public InputStream getDataAsInputStream() {
        return dataAsStream;
    }

    @Override
    public String toUriData() {
        return getDataAsString();
    }
}
