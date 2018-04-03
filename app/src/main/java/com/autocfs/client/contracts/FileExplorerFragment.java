package com.autocfs.client.contracts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import com.autocfs.client.R;
import com.autocfs.client.adapters.FileExplorerAdapter;

import java.io.File;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FileExplorerFragment extends Fragment implements FileExplorerContract.View {
    private ListView mFileExplorerList;
    private FileExplorerContract.Presenter mPresenter;
    private FileExplorerAdapter mFileExplorerAdapter;

    public FileExplorerFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_file_explorer, container, false);
        mFileExplorerList = root.findViewById(R.id.file_explorer_list);
        return root;
    }

    @Override
    public void showList(List<File> list) {
        mFileExplorerAdapter.setList(list);
        mFileExplorerList.refreshDrawableState();

    }

    @Override
    public void scrollToPosition(int position) {
    }

    @Override
    public void setPresenter(FileExplorerContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
