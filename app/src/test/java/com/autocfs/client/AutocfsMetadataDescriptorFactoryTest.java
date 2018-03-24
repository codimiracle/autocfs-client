package com.autocfs.client;

import com.autocfs.client.datastructs.AutocfsMetadataDescriptorFactory;
import com.autocfs.client.datastructs.MetadataDescriptor;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Created by Codimiracle on 2018/3/24.
 */

public class AutocfsMetadataDescriptorFactoryTest {
    private AutocfsMetadataDescriptorFactory factory;
    @Before
    public void setUp()
    {
        factory = new AutocfsMetadataDescriptorFactory();
    }

    @Test
    public void testGetDescriptorByFile() {
        MetadataDescriptor descriptor = factory.getDescriptor(new File("./settings.gradle"));
    }
}
