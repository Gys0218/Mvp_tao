package com.example.lenovo.mvp_tao.ui.home.me.login;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.base.BaseFragment;
import com.example.lenovo.mvp_tao.bean.User;
import com.example.lenovo.mvp_tao.ui.home.me.register.RegisterFragment;
import com.example.lenovo.mvp_tao.ui.home.me.register.RegisterPresenter;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class LoginFragment extends BaseFragment implements LoginContract.View, View.OnClickListener {
    private LoginContract.Presenter mPresenter;

    private EditText edit_getphoneNumbar;
    private Button btn_getCode;
    private EditText edit_code;
    private TextView btn_login;
    private CheckBox check_protocol;
    UMAuthListener umAuthListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_LONG).show();
            Log.e("data", data.toString());

            RegisterPresenter registerPresenter = new RegisterPresenter();
            baseActivity.addFragment(RegisterFragment.class,registerPresenter,R.id.form,null,null);

        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(getActivity(), "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getActivity(), "取消授权", Toast.LENGTH_LONG).show();
        }
    };
    private ImageView img_weibo;
    private ImageView img_wechat;
    private ImageView img_qq;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        edit_getphoneNumbar = view.findViewById(R.id.edit_getphoneNumbar);
        btn_getCode = view.findViewById(R.id._btn_getCode);
        edit_code = view.findViewById(R.id.edit_code);
        btn_login = view.findViewById(R.id.btn_login);
        check_protocol = view.findViewById(R.id.check_protocol);

        img_weibo = view.findViewById(R.id.img_weibo);
        img_wechat = view.findViewById(R.id.img_wechat);
        img_qq = view.findViewById(R.id.img_qq);

        img_qq.setOnClickListener(this);
        img_weibo.setOnClickListener(this);
        img_wechat.setOnClickListener(this);


        check_protocol.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                btn_login.setEnabled(isChecked);

            }
        });

        btn_getCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumbar = edit_getphoneNumbar.getText().toString();

                mPresenter.getVerificationCode(phoneNumbar);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNumbar = edit_getphoneNumbar.getText().toString();
                String code = edit_code.getText().toString();

                mPresenter.login(phoneNumbar,code);
            }
        });




        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(getActivity(), mPermissionList, 123);
        }

        login();
        return view;
    }

    private void login() {

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(getActivity()).onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void verificationCodeSuccess() {
        btn_getCode.setText("验证码发送成功");
    }

    @Override
    public void verifictionCodeFail() {
        btn_getCode.setText("验证码发送失败");
    }

    @Override
    public void loginSuccess(User user) {
        //登录成功的回调方法15146898436
        baseActivity.addFragment(RegisterFragment.class,mPresenter,R.id.form,null,null);

    }


    @Override
    public void loginFail(String message) {
        Toast.makeText(getContext(), "登录失败" + message, Toast.LENGTH_SHORT).show();
        Log.e("loginFail", message);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;

        presenter.attachView(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_weibo:
                UMShareAPI.get(getActivity()).getPlatformInfo(getActivity(), SHARE_MEDIA.SINA, umAuthListener);
                break;
            case R.id.img_wechat:
                UMShareAPI.get(getActivity()).getPlatformInfo(getActivity(), SHARE_MEDIA.WEIXIN, umAuthListener);
                break;
            case R.id.img_qq:
                UMShareAPI.get(getActivity()).getPlatformInfo(getActivity(), SHARE_MEDIA.QQ, umAuthListener);
                break;
        }
    }
}
