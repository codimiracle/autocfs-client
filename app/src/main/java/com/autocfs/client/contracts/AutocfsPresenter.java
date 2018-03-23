package com.autocfs.client.contracts;

import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;


public class AutocfsPresenter implements AutocfsContract.Presenter {
    private AutocfsContract.View mView;

    public AutocfsPresenter(AutocfsContract.View view) {
        mView = checkNotNull(view);
        mView.setPresenter(this);
    }

    public void sayHello() {
        mView.setMessage("Hello World");
    }
}
