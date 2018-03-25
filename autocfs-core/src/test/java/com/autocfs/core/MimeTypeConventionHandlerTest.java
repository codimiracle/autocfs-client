package com.autocfs.core;

import org.junit.Before;
import org.junit.Test;

public class MimeTypeConventionHandlerTest {
    MetadataDescriptor descriptor;
    MimeTypeConventionHandler handler;
    @Before
    public void setUp() {
        descriptor = new AutocfsMetadataDescriptorFactory().getDescriptor("D:/readme.txt");
        handler = new MimeTypeConventionHandler();
    }

    @Test
    public void testHandle() {
        handler.handle(descriptor);
    }
}
