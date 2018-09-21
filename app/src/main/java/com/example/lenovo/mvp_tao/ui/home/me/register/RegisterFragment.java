package com.example.lenovo.mvp_tao.ui.home.me.register;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends BaseFragment implements RegisterContract.View {

    private RegisterContract.Presenter mPresenter;

    private ImageView img_return;
    private ImageView img_finish;
    private ImageView img_head;
    private EditText edit_username;
    private TextView dbtn_done;
    private TextView tv_skip;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);


        img_return = view.findViewById(R.id.img_return);
        img_finish = view.findViewById(R.id.img_finish);
        img_head = view.findViewById(R.id.img_head);
        edit_username = view.findViewById(R.id.edit_username);
        dbtn_done = view.findViewById(R.id.dbtn_done);
        tv_skip = view.findViewById(R.id.tv_skip);
        img_head.setOnClickListener(new View.OnClickListener() {

            private boolean mIsShowing;
            private Button btn_finish;
            private Button btn_xiangce;
            private Button btn_xiangji;

            @Override
            public void onClick(View v) {
                popupwindow();
            }

            private void popupwindow() {
                //设置要显示的view
                View view = View.inflate(getActivity(), R.layout.popupwindow_register, null);
                //此处可按需求为各控件设置属性

                PopupWindow popupWindow = new PopupWindow(view);
                //设置弹出窗口大小
                popupWindow.setWidth(WindowManager.LayoutParams.FILL_PARENT);
                popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                //必须设置以下两项，否则弹出窗口无法取消
                popupWindow.setFocusable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
                //设置动画效果
                popupWindow.setAnimationStyle(R.style.anim_menu_bottombar);
                //设置显示位置,findViewById获取的是包含当前整个页面的view
                popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);

                btn_xiangce = view.findViewById(R.id.btn_xiangce);
                btn_xiangji = view.findViewById(R.id.btn_xiangji);
                btn_finish = view.findViewById(R.id.btn_finish);


                btn_xiangji.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mPresenter.getMapDepot();

                    }
                });

                btn_xiangce.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mPresenter.getQuanXian(getActivity());

                    }
                });
            }
        });

        tv_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edit_username.getText().toString();

                StringBuffer sb = new StringBuffer();
                for (int i = 0; i <10 ; i++) {
                    sb.append((int) Math.random()*(10));
                }

                if (userName==null){
                    edit_username.setText(userName+sb.toString());
                }

            }
        });

        return view;

    }

    @Override
    public void onTakePhotoSuccess(Bitmap bitmap) {
        // 拍照后大图的 filepath
        img_head.setImageBitmap(bitmap);
    }

    @Override
    public void onSaveBitmapSuccess(Bitmap bitmap) {
        // 保存剪切后的原图 filePath
        img_head.setImageBitmap(bitmap);
    }

    @Override
    public void onThisBitmapSuccess(Bitmap bitmap) {
        //保存剪切后的原图 filePath
        img_head.setImageBitmap(bitmap);
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.attachView(this);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mPresenter.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
