package com.example.lenovo.mvp_tao.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.example.lenovo.mvp_tao.R;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.List;

public abstract class BaseActivity extends RxAppCompatActivity {

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();

    }

    public <T extends BaseFragment> void addFragment(@NonNull Class<T> tClass,BasePresenter presenter,int containerId,String tag,Bundle args){

        if (TextUtils.isEmpty(tag)){
            tag = tClass.getName();
        }

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        Fragment addedFragment = mFragmentManager.findFragmentByTag(tag);


        BaseFragment targetFragment = null;

        if (addedFragment == null){
            try {
                targetFragment = tClass.newInstance();

                if (targetFragment instanceof BaseView){
                    ((BaseView) targetFragment).setPresenter(presenter);
                }
                fragmentTransaction.add(containerId,targetFragment,tag);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }else {
            targetFragment = (BaseFragment) addedFragment;
            if (targetFragment.isHidden()){
                addFragmentAnimation(fragmentTransaction,targetFragment);
            }
            fragmentTransaction.show(targetFragment);
        }
        if (targetFragment != null){
            addFragmentAnimation(fragmentTransaction,targetFragment);
            hidePreFragment(fragmentTransaction,targetFragment);

            if (targetFragment.isNeedAddToBackStack()){
                fragmentTransaction.addToBackStack(tag);
            }
            fragmentTransaction.commit();
        }
    }

    private void hidePreFragment(FragmentTransaction transaction, BaseFragment baseFragment) {
        if (baseFragment.isNeedHidePreFragment()){
            List<Fragment> addFragments = mFragmentManager.getFragments();

            for (Fragment fragment:addFragments) {
                if (fragment != baseFragment){
                    transaction.hide(fragment);
                }
            }
        }
    }

    private void addFragmentAnimation(FragmentTransaction transaction, BaseFragment targetFragment) {
        transaction.setCustomAnimations(targetFragment.getEnterAnimId(),targetFragment.getPreExistAnimId(),targetFragment.getPopPreEnterAnimId(),targetFragment.getPopExistAnimId());
    }

}
