package com.autocfs.client.contracts;

/**
 * Created by Codimiracle on 2018/3/19.
 */

public interface AutocfsContract {
    public interface View extends BaseView<Presenter> {
        public void setMessage(String message);
    }
    public interface Presenter extends BasePresenter {
        public void sayHello();
    }
}
