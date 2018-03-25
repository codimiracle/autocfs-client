package com.autocfs.core;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class AutocfsConventionHandlerTest {
    private ConventionHandler handler;

    @Before
    public void setUp() {
        handler = new ConventionHandler() {
            @Override
            public void handle(MetadataDescriptor descriptor) {
                assertTrue(true);
            }
        };
    }

    @Test
    public void testHandle() {
        handler.handle(null);
    }
}
