package com.example.lenovo.mvp_tao.base;

import android.app.Activity;

public interface BaseView<T extends BasePresenter>{

    void setPresenter(T presenter);

    Activity getActivity();

}
