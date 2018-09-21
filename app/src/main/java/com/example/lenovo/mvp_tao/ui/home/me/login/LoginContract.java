package com.example.lenovo.mvp_tao.ui.home.me.login;

import com.example.lenovo.mvp_tao.base.BasePresenter;
import com.example.lenovo.mvp_tao.base.BaseView;
import com.example.lenovo.mvp_tao.bean.User;

public interface LoginContract {

    public interface View extends BaseView<LoginContract.Presenter>{
        //请求完的数据返回到P层
        void verificationCodeSuccess();
        void verifictionCodeFail();


        void loginSuccess(User user);
        void loginFail(String message);
    }

    public interface Presenter extends BasePresenter<LoginContract.View>{
        //V层数据发送到M层进行网络请求
        void getVerificationCode(String phoneNumbar);

        void login(String phoneNumbar,String code);
    }

}
