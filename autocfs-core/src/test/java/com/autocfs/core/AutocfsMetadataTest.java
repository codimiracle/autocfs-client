package com.autocfs.core;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Codimiracle on 2018/3/23.
 */

public class AutocfsMetadataTest {
    private AutocfsMetadata metadata;
    @Before
    public void setUp() {
        metadata = new AutocfsMetadata("Source", "数据");
    }

    @Test
    public  void testGetSourceAsString() {
        assertEquals("Source", metadata.getSourceAsString());
    }

    @Test
    public void testGetDataAsString() {
        assertEquals("数据", metadata.getDataAsString());
    }

    @Test
    public void testGetDataAsInputStream() {
        InputStream input = metadata.getDataAsInputStream();
        InputStreamReader reader = new InputStreamReader(input, Charset.defaultCharset());
        char[] chars = new char[1024];
        try {
            assertEquals("数据", new String(chars, 0, reader.read(chars)));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testGetSourceAsInputStream() {
        InputStream input = metadata.getSourceAsInputStream();
        InputStreamReader reader = new InputStreamReader(input, Charset.defaultCharset());
        char[] chars = new char[1024];
        try {
            assertEquals("Source", new String(chars, 0, reader.read(chars)));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
