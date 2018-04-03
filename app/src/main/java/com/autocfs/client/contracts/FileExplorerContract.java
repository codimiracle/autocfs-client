package com.autocfs.client.contracts;

import android.widget.Adapter;
import android.widget.ListAdapter;

import java.io.File;
import java.util.List;

public interface FileExplorerContract {
    public interface View extends BaseView<Presenter> {
        public void showList(List<File> list);
        public void scrollToPosition(int position);
    }
    public interface Presenter extends BasePresenter {
        public void changeDirectory(File directory);
        public void changeDirectory(String path);
        public void refresh();
    }
}
