package com.autocfs.client.contracts;

import java.io.File;

public class FileExplorerPresenter implements FileExplorerContract.Presenter{
    private final FileExplorerContract.View mView;

    public FileExplorerPresenter(FileExplorerContract.View view) {
        this.mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void changeDirectory(File directory) {

    }

    @Override
    public void changeDirectory(String path) {

    }

    @Override
    public void refresh() {

    }
}
