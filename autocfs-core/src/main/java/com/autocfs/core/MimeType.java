package com.autocfs.core;

import static com.google.common.base.Preconditions.checkNotNull;

public class MimeType {
    private String mediatype;
    private String subtype;

    protected MimeType(String mediatype, String subtype) {
        this.mediatype = mediatype;
        this.subtype = subtype;
    }

    public static MimeType getMimeType(String mimeType) {
        mimeType = checkNotNull(mimeType);
        int index = mimeType.indexOf("/");
        return getMimeType(mimeType.substring(0, index), mimeType.substring(index + 1));
    }

    public static MimeType getMimeType(String mediatype, String subtype) {
        if (mediatype.contains("*") || subtype.contains("*")) {
            throw new IllegalArgumentException("expected MimeType definitely but included '*'.");
        }
        return new MimeType(mediatype, subtype);
    }

    public String getMediatype() {
        return mediatype;
    }

    public String getSubtype() {
        return subtype;
    }

    @Override
    public int hashCode() {
        return mediatype.hashCode() + 8 + subtype.hashCode() * 7;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof MimeType) && o.hashCode() == hashCode();

    }
}
