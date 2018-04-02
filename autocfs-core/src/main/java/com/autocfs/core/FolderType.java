package com.autocfs.core;

import java.io.File;

public class FolderType {
    private MimeType mimeType;

    public static FolderType getFolderType(String[] list) {
        return null;
    }

    public static FolderType getFolderType(File[] files) {
        return null;
    }

    protected FolderType(String mediatype, String subtype) {
        mimeType = new MimeType(mediatype, subtype);
    }
    @Override
    public int hashCode() {
        return mimeType.hashCode() * 9;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof  FolderType) && hashCode() == o.hashCode();
    }

    public String getMediatype() {
        return mimeType.getMediatype();
    }

    public String getSubtype() {
        return mimeType.getSubtype();
    }
}
