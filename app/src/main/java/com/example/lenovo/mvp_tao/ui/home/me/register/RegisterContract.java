package com.example.lenovo.mvp_tao.ui.home.me.register;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.example.lenovo.mvp_tao.base.BasePresenter;
import com.example.lenovo.mvp_tao.base.BaseView;

public interface RegisterContract {


    public interface View extends BaseView<RegisterContract.Presenter>{
        void onTakePhotoSuccess(Bitmap bitmap);   // 拍照后大图的 filepath
        void onSaveBitmapSuccess(Bitmap bitmap);  // 保存剪切后的原图 filePath

        void onThisBitmapSuccess(Bitmap bitmap);   //保存剪切后的原图 filePath

    }


    public interface Presenter extends BasePresenter<RegisterContract.View>{
        void getQuanXian(Context context);

        void getMapDepot();

        void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);

        void onActivityResult(int requestCode, int resultCode, Intent data);
    }
}
