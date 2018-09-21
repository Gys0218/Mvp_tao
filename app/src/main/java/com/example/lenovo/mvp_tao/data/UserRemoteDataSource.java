package com.example.lenovo.mvp_tao.data;

import android.util.Log;

import com.example.lenovo.mvp_tao.bean.HttpResult;
import com.example.lenovo.mvp_tao.bean.NewsChannel;
import com.example.lenovo.mvp_tao.bean.UpListNews;
import com.example.lenovo.mvp_tao.bean.User;
import com.example.lenovo.mvp_tao.data.soure.ServerException;
import com.example.lenovo.mvp_tao.retrofit.Apiservice;
import com.example.lenovo.mvp_tao.retrofit.DataRetrofit;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class UserRemoteDataSource implements UserDataSource {
    private Apiservice apiservice;


    public UserRemoteDataSource(){
        apiservice = DataRetrofit.getRetrofit();
    }
    @Override
    public void sendVerificationCode(RxFragment fragment, Map<String, String> map, Observer<Object> observer) {
        Log.e("object", map.toString());
        Observable<HttpResult<Object>> observable = apiservice.sendVerificationCode(map);

        observable.flatMap(new Function<HttpResult<Object>, ObservableSource<Object>>() {
            @Override
            public ObservableSource<Object> apply(HttpResult<Object> objectHttpResult) throws Exception {
                if (objectHttpResult.getCode() == 0){
                    return Observable.just(new Object());
                }
                return Observable.error(new ServerException(objectHttpResult.getCode(),objectHttpResult.getMessage()));
            }
        })
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(fragment.<Object>bindUntilEvent(FragmentEvent.DETACH))
                .subscribe(observer);
    }//15146898436





    @Override
    public void login(RxFragment fragment, Map<String, String> map, Observer<User> observer) {
        Observable<HttpResult<User>> observable = apiservice.login(map);
        Log.e("UserRemoteDataSource", map.toString());
        observable.flatMap(new Function<HttpResult<User>, ObservableSource<User>>() {
            @Override
            public ObservableSource<User> apply(HttpResult<User> userHttpResult) throws Exception {

                if (userHttpResult.getCode() == 0) {
                    return Observable.just(userHttpResult.getData());
                }
                return Observable.error(new ServerException(userHttpResult.getCode(), userHttpResult.getMessage()));
            }
        }).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(fragment.<User>bindUntilEvent(FragmentEvent.DETACH))//此方法暂时不知
                .subscribe(observer);
    }



}
