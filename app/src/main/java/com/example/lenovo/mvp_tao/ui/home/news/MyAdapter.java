package com.example.lenovo.mvp_tao.ui.home.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lenovo.mvp_tao.bean.newsChannelList;
import com.example.lenovo.mvp_tao.ui.home.news.list_news.NewsReuseFragment;

import java.util.ArrayList;

public class MyAdapter extends FragmentPagerAdapter{
    private ArrayList<newsChannelList> list;

    public MyAdapter(FragmentManager manager, ArrayList<newsChannelList> list) {
        super(manager);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        NewsReuseFragment newsReuseFragment = new NewsReuseFragment();
        Bundle bundle = new Bundle();
        bundle.putString("channelId",list.get(position).getChannelId());
        bundle.putString("channelName",list.get(position).getChannelName());
        newsReuseFragment.setArguments(bundle);
        return newsReuseFragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getChannelName();
    }
}
