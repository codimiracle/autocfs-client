package com.autocfs.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

public class FileMover implements Copier{
    private Vector<File> files;

    public FileMover(File[] files) {
        this.files = new Vector<File>();
        this.files.addAll(Arrays.asList(files));
    }

    @Override
    public int transfer() throws IOException {
        return 0;
    }
}
