package com.example.lenovo.mvp_tao.ui.home.me.register;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;

import com.example.lenovo.mvp_tao.utils.PhoneUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View mView;
    private File file;
    private Intent intent;
    private boolean panduan;
    private String filePath;
    private Uri ImageUri;

    public RegisterPresenter() {
        super();
    }

    @Override
    public void getQuanXian(Context context) {
        //写个运行时权限
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//相片类型
        ((Fragment)mView).startActivityForResult(intent,4);//进入相册请求图片


    }

    private void openCamera() {
        //创建一个保存图片的路径
        File outputImage = new File(mView.getActivity().getExternalCacheDir(), "output_image.jpg");
        try {
            if (outputImage.exists()) {
                outputImage.delete();
            }
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //如果android7.0以上的系统，需要做个判断
        if (Build.VERSION.SDK_INT >= 24) {
            ImageUri = FileProvider.getUriForFile(mView.getActivity(), "com.example.lenovo.mvp_tao", outputImage);//7.0
        } else {
            ImageUri = Uri.fromFile(outputImage); //7.0以下
        }
        //利用隐式Intent 打开系统相机
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, ImageUri);
        ((Fragment)mView).startActivityForResult(intent, 1);//这里的TAKE_PHOTO是定义的一个静态常数变量
    }

    @Override
    public void getMapDepot() {
        openCamera();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            //截取相机拍照后的图片
            case 1:
                startPhotoZoom(ImageUri);//这里调用了截取图片的方法
                break;
            //返回截取后的结果
            case 2:
                if (resultCode == mView.getActivity().RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(mView.getActivity().getContentResolver().openInputStream(ImageUri));
                        mView.onSaveBitmapSuccess(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 4:
                Uri myUri=PhoneUtils.onCutmyPhoneResult(mView.getActivity(),requestCode,resultCode,data);//;获得相册图片uri
                startPhotoZoom(myUri);
                break;
        }


    }

    private void startPhotoZoom(Uri imageUri) {
        File CropPhoto = new File(mView.getActivity().getExternalCacheDir(), "Crop.jpg");//这个是创建一个截取后的图片路径和名称。
        try {
            if (CropPhoto.exists()) {
                CropPhoto.delete();
            }
            CropPhoto.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageUri = Uri.fromFile(CropPhoto);
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(imageUri, "image/*");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); //添加这一句表示对目标应用临时授权该Uri所代表的文件
        }
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        //输出的宽高
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", false);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, ImageUri);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true); // no face detection
        ((Fragment)mView).startActivityForResult(intent, 2);//这里的RESULT_REQUEST_CODE是在startActivityForResult里使用的返回值。
    }


    @Override
    public void attachView(RegisterContract.View baseView) {

        mView=baseView;

    }

    @Override
    public void detachView() {
        mView = null;
    }
}
