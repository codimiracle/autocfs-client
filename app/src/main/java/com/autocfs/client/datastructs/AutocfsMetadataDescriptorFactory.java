package com.autocfs.client.datastructs;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicException;
import net.sf.jmimemagic.MagicMatch;
import net.sf.jmimemagic.MagicMatchNotFoundException;
import net.sf.jmimemagic.MagicParseException;

import java.io.File;
import java.io.InputStream;

/**
 * Created by Codimiracle on 2018/3/23.
 */

public class AutocfsMetadataDescriptorFactory implements MetadataDescriptorFactory {

    private MetadataDescriptor getDescriptorUncheck(String type, String source, String data) {
        Metadata metadata = new AutocfsMetadata(source, data);
        return new AutocfsMetadataDescriptor(type.toLowerCase(), metadata);
    }

    private MetadataDescriptor getDescriptorUncheck(String type, InputStream source, InputStream data) {
        Metadata metadata = new AutocfsMetadata(source, data);
        return new AutocfsMetadataDescriptor(type.toLowerCase(), metadata);
    }

    @Override
    public MetadataDescriptor getDescriptor(File source) {
        if (!source.exists() && source.isDirectory()) {
            throw new IllegalArgumentException(source.getPath() + " - File Not Found");
        }
        String data = "application/octet-stream";
        try {
            MagicMatch match = Magic.getMagicMatch(source, false);
            data = match.getMimeType();
        } catch (MagicParseException e) {
            e.printStackTrace();
        } catch (MagicMatchNotFoundException e) {
            e.printStackTrace();
        } catch (MagicException e) {
            e.printStackTrace();
        }
        return getDescriptorUncheck("file", source.getPath(), data);
    }

    private void check(String type) {
        if (type.toLowerCase().equals("file") || type.toLowerCase().equals("folder")) {
            throw new IllegalArgumentException("you shouldn't use file/folder metadata type.");
        }
    }

    @Override
    public MetadataDescriptor getDescriptor(String type, String source, String data) {
        check(type);
        return getDescriptorUncheck(type, source, data);
    }

    @Override
    public MetadataDescriptor getDescriptor(String type, InputStream source, InputStream data) {
        check(type);
        return getDescriptorUncheck(type,source,data);
    }
}
