package com.autocfs.core;

import org.junit.Before;
import org.junit.Test;

public class MimeTypeConventionHandlerTest {
    MetadataDescriptor descriptor;
    MimeTypeConvention handler;
    @Before
    public void setUp() {
        descriptor = new AutocfsMetadataDescriptorFactory().getDescriptor("D:/readme.txt");
        handler = new MimeTypeConvention(descriptor);
    }

    @Test
    public void testHandle() {
        handler.handle(descriptor);
    }

    @Test
    public void testAddListener() {
        handler.addConvensionHandlerListener(new MimeTypeConvention.ConventionHandlerListener() {
            @Override
            public void onHandling(ListenableConvention.ProgressMessage message) {
                System.out.println(message.getProgress());
            }
            public void onHandleBegin(ListenableConvention.HandlerMessage message) {
                System.out.println(message.getDescriptor().getMetadata().getSourceAsString() + " handling...");
            }

            public void onHandleEnd(ListenableConvention.ResultsMessage message) {
                System.out.println(message.getDescriptor().getMetadata().getSourceAsString() + " finish with code:" + message.getResultCode());
            }
        });
        handler.handle(descriptor);
    }
}
