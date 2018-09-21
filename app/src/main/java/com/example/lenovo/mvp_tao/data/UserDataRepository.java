package com.example.lenovo.mvp_tao.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.lenovo.mvp_tao.bean.NewsChannel;
import com.example.lenovo.mvp_tao.bean.UpListNews;
import com.example.lenovo.mvp_tao.bean.User;
import com.trello.rxlifecycle2.components.support.RxFragment;
import com.trello.rxlifecycle2.internal.Preconditions;

import java.util.Map;

import io.reactivex.Observer;

public class UserDataRepository implements UserDataSource {

    @NonNull
    private UserDataSource mRemoteDataSource;

    @Nullable
    private static UserDataRepository INSTANCE = null;

    private UserDataRepository(@NonNull UserDataSource remoteDataSource){

        mRemoteDataSource = Preconditions.checkNotNull(remoteDataSource,"Login remote data source is not allowed null");

    }

    public static UserDataRepository getInstance(){

        if (INSTANCE == null){
            synchronized (UserDataRepository.class){
                if (INSTANCE == null){
                    INSTANCE = new UserDataRepository(new UserRemoteDataSource());
                }
            }
        }
        return INSTANCE;

    }

    @Override
    public void sendVerificationCode(RxFragment fragment, Map<String, String> map, Observer<Object> observer) {

        mRemoteDataSource.sendVerificationCode(fragment,map,observer);

    }

    @Override
    public void login(RxFragment fragment, Map<String, String> map, Observer<User> observer) {

        mRemoteDataSource.login(fragment,map,observer);

    }




}
