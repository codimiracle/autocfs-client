package com.autocfs.client.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.autocfs.client.R;

import java.io.File;
import java.util.List;

public class FileExplorerAdapter extends BaseAdapter {
    private Context mContext;

    public FileExplorerAdapter(Context context) {
        this.mContext = context;
    }

    private List<File> list;

    public void setList(List<File> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public File getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.file_explorer_item, parent);
        }
        ImageView icon = convertView.findViewById(R.id.file_explorer_item_icon);
        TextView name = convertView.findViewById(R.id.file_explorer_item_name);
        TextView details = convertView.findViewById(R.id.file_explorer_item_details);
        return convertView;
    }
}
