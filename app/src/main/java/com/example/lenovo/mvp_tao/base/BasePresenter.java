package com.example.lenovo.mvp_tao.base;

public interface BasePresenter<T extends BaseView> {

    void attachView(T baseView);

    void detachView();

}
