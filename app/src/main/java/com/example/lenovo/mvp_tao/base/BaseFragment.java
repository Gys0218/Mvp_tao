package com.example.lenovo.mvp_tao.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.trello.rxlifecycle2.components.support.RxFragment;

public class BaseFragment extends RxFragment {

    public BaseActivity baseActivity;


    protected boolean isNeedAddToBackStack(){
        return true;
    }

    protected boolean isNeedHidePreFragment(){
        return true;
    }

    protected int getEnterAnimId(){
        return 0;
    }
    protected int getPreExistAnimId(){
        return 0;
    }
    protected int getPopExistAnimId(){
        return 0;
    }
    protected int getPopPreEnterAnimId(){
        return 0;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        baseActivity = (BaseActivity) context;
    }
}
