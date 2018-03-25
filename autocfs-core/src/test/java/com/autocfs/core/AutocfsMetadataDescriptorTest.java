package com.autocfs.core;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertSame;

public class AutocfsMetadataDescriptorTest {
    private MetadataDescriptor descriptor;
    private Metadata metadata;
    @Before
    public void setUp() {
        metadata = new AutocfsMetadata("Source", "Data");
        descriptor = new AutocfsMetadataDescriptor("file", metadata);
    }

    @Test
    public void testGetMetadata() {
        assertSame(metadata, descriptor.getMetadata());
    }

    @Test
    public void testGetMetadataType() {
        assertEquals("file", descriptor.getMetadataType());
    }

    @Test
    public void testToUri() {
        assertEquals("autocfs://file:Source:Data", descriptor.toUri());
    }
}
