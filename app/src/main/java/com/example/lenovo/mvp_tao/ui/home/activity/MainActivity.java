package com.example.lenovo.mvp_tao.ui.home.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.View;

import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.base.BaseActivity;
import com.example.lenovo.mvp_tao.data.UserDataRepository;
import com.example.lenovo.mvp_tao.ui.home.me.login.LoginFragment;
import com.example.lenovo.mvp_tao.ui.home.me.login.LoginPresenter;
import com.umeng.socialize.UMShareAPI;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginPresenter presenter = new LoginPresenter(UserDataRepository.getInstance());
        addFragment(LoginFragment.class,presenter,R.id.form,null,null);



        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();



    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(MainActivity.this).onActivityResult(requestCode, resultCode, data);
    }


}
