package com.autocfs.io;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class IOCopierTest {
    private StreamCopier copier;
    private ByteArrayOutputStream output;
    private ByteArrayInputStream input;


    @Before
    public void setUp() {
        input = new ByteArrayInputStream("Hello World!".getBytes());
        output = new ByteArrayOutputStream(1024);
        copier = new StreamCopier(input, output);
    }

    @Test
    public void copy() {
        try {
            copier.transfer();
            assertArrayEquals("Hello World!".getBytes(), output.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
