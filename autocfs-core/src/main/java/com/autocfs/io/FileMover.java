package com.autocfs.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

public class FileMover implements Copier {
    private long transferred;
    private int lastTransferred;
    private File destination;
    private File handling = null;
    private Copier copier;
    private Vector<File> files;
    private Iterator<File> iterator;

    public FileMover(File[] files, File destination) {
        if (!destination.isDirectory()) {
            throw new IllegalArgumentException("Destination must be a directory!");
        }
        this.destination = destination;
        this.files = new Vector<>();
        this.files.addAll(Arrays.asList(files));
        iterator = this.files.iterator();
    }

    private void cleanHandling() {
        handling = null;
        copier = null;
    }

    private long move(File file, File dir) throws IOException {
        File target = new File(dir.getAbsoluteFile() + File.separator + file.getName());
        if (file.renameTo(target)) {
            cleanHandling();
            return target.length();
        } else {
            copier = new StreamCopier(new FileInputStream(file), new FileOutputStream(target));
            return -1L;
        }
    }

    @Override
    public long getTransferred() {
        return transferred;
    }

    @Override
    public int getLastTransferred() {
        return lastTransferred;
    }

    @Override
    public Transferable transfer() throws IOException {
        if (handling == null && iterator.hasNext()) {
            handling = iterator.next();
        }
        if (copier == null) {
            long bytes = move(handling, destination);
            if (bytes != -1) {
                return this;
            }
        }
        Transferable transferable = copier.transfer();
        if (transferable == null) {
            cleanHandling();
            return null;
        }
        return this;
    }
}
