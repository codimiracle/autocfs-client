package com.autocfs.client.contracts;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.autocfs.client.R;

import static com.google.common.base.Preconditions.checkNotNull;


public class AutocfsFragment extends Fragment implements AutocfsContract.View {

    private Button mButton;
    private AutocfsContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_autocfs,container, false);
        return v;
    }

    @Override
    public void setMessage(String message) {
        mButton.setText(message);
    }

    @Override
    public void setPresenter(AutocfsContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
