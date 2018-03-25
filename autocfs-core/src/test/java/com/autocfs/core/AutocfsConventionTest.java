package com.autocfs.core;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertSame;

/**
 * Created by Codimiracle on 2018/3/24.
 */

public class AutocfsConventionTest {

    private Convention convention;
    private Metadata metadata;
    private MetadataDescriptor descriptor;
    private ConventionHandler handler;

    @Before
    public void setUp() {
        metadata = new AutocfsMetadata("Source", "Data");
        descriptor = new AutocfsMetadataDescriptor("file", metadata);
        convention = new AutocfsConvention(descriptor);
    }

    @Test
    public void testGetDescriptor() {
        assertSame(descriptor, convention.getDescriptor());
    }

    @Test
    public void testGetHandlerNull() {
        assertNull(convention.getHandler());
    }

    @Test
    public void testGetHandlerNotNull() {
        handler = new ConventionHandler() {
            @Override
            public void handle(MetadataDescriptor descriptor) {
                assertEquals("file", descriptor.getMetadataType());
            }
        };
        convention.setHandler(handler);
        assertSame(handler, convention.getHandler());
    }

}
