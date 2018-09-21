package com.example.lenovo.mvp_tao.ui.home.news;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.base.BaseFragment;
import com.example.lenovo.mvp_tao.bean.Comment;
import com.example.lenovo.mvp_tao.bean.DownListNews;
import com.example.lenovo.mvp_tao.bean.Newsinfo;
import com.example.lenovo.mvp_tao.bean.Relevant;
import com.example.lenovo.mvp_tao.bean.newList;
import com.example.lenovo.mvp_tao.bean.newsChannelList;
import com.example.lenovo.mvp_tao.bean.userCommentList;
import com.example.lenovo.mvp_tao.data.UserDataRepository;
import com.example.lenovo.mvp_tao.ui.home.news.data.NewsDataRepository;
import com.example.lenovo.mvp_tao.ui.home.news.data.NewsLocalDataSource;
import com.example.lenovo.mvp_tao.ui.home.news.data.NewsRemoteDataSource;
import com.example.lenovo.mvp_tao.utils.StatusBarManager;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment implements NewsContract.View {
    private NewsContract.Presenter mPresenter;


    private TabLayout tablayout;
    private ViewPager vp;
    private ImageView add;
    private MyAdapter adapter;
    private NewsPresenter newsPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        newsPresenter = new NewsPresenter(NewsDataRepository.getInstance(NewsRemoteDataSource.getInstance(), NewsLocalDataSource.getInstance(getActivity())));

        tablayout = view.findViewById(R.id.tablayout);
        vp = view.findViewById(R.id.vp);
        add = view.findViewById(R.id.add);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);


        setHasOptionsMenu(true);
        StatusBarManager.setStatusBarColor(activity, ContextCompat.getColor(activity, R.color.text_bg_color_g));//D33D3C


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (newsPresenter != null){

            newsPresenter.listNewsChannel();

        }
    }

    @Override
    public void setPresenter(NewsContract.Presenter presenter) {

        newsPresenter= (NewsPresenter) presenter;
        newsPresenter.attachView(this);

    }


    @Override
    public void getListNewsChannelFail(String message) {

        Log.d("NewsFragment---新闻", message);

    }

    @Override
    public void getListNewsChannelSuccess(ArrayList<newsChannelList> list) {

        adapter = new MyAdapter(getChildFragmentManager(), list);
        tablayout.setupWithViewPager(vp);
        vp.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void getUpListNewsFail(String message) {

    }

    @Override
    public void getUpListNewsSuccess(ArrayList<newList> list) {

    }

    @Override
    public void getDownListNewsFail(String message) {

    }

    @Override
    public void getDownListNewsSucess(DownListNews downListNews) {

    }

    @Override
    public void getNewsInfoFail(String message) {

    }

    @Override
    public void getNewsInfoSuccess(Newsinfo newsinfo) {

    }

    @Override
    public void getgetReleventFail(String message) {

    }

    @Override
    public void getReleventSucess(ArrayList<Relevant> list) {

    }

    @Override
    public void getListCommentFail(String message) {

    }

    @Override
    public void getListCommentSucess(Comment comment) {

    }

    @Override
    public void getCommentFail(String message) {

    }

    @Override
    public void getCommentSucess(Object o) {

    }

}
