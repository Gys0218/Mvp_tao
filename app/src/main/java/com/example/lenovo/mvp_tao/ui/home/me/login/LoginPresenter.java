package com.example.lenovo.mvp_tao.ui.home.me.login;

import android.util.Log;

import com.example.lenovo.mvp_tao.bean.User;
import com.example.lenovo.mvp_tao.data.UserDataSource;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private UserDataSource mUserDataRepository;

    public LoginPresenter(UserDataSource userDataRepository){
        mUserDataRepository = userDataRepository;
    }

    @Override
    public void getVerificationCode(String phoneNumbar) {
        HashMap<String, String> map = new HashMap<>();
        map.put("phone", phoneNumbar);
        map.put("smsType", "0");

        mUserDataRepository.sendVerificationCode((RxFragment) view, map, new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                view.verificationCodeSuccess();
            }

            @Override
            public void onError(Throwable e) {
                view.verifictionCodeFail();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void login(String phoneNumbar, String code) {
        HashMap<String, String> map = new HashMap<>();
        map.put("phone", phoneNumbar);
        map.put("verificationCode", code);
        map.put("platform", "1");
        map.put("appVersion", "1.0.0");
        map.put("deviceId", "1454564545");

        mUserDataRepository.login((RxFragment) view, map, new Observer<User>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(User user) {
                Log.e("LoginPresenter登录成功的回调", user.toString());
                view.loginSuccess(user);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("LoginPresenter登录失败的回调", e.getMessage());
                view.loginFail(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void attachView(LoginContract.View baseView) {
        view = baseView;
    }

    @Override
    public void detachView() {

    }
}
