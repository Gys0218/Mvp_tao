package com.example.lenovo.mvp_tao.ui.home.news.list_news;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.base.BaseFragment;
import com.example.lenovo.mvp_tao.bean.Comment;
import com.example.lenovo.mvp_tao.bean.DownListNews;
import com.example.lenovo.mvp_tao.bean.Newsinfo;
import com.example.lenovo.mvp_tao.bean.Relevant;
import com.example.lenovo.mvp_tao.bean.newList;
import com.example.lenovo.mvp_tao.bean.newListt;
import com.example.lenovo.mvp_tao.bean.newsChannelList;
import com.example.lenovo.mvp_tao.bean.userCommentList;
import com.example.lenovo.mvp_tao.ui.home.news.NewsContract;
import com.example.lenovo.mvp_tao.ui.home.news.NewsPresenter;
import com.example.lenovo.mvp_tao.ui.home.news.data.NewsDataRepository;
import com.example.lenovo.mvp_tao.ui.home.news.data.NewsLocalDataSource;
import com.example.lenovo.mvp_tao.ui.home.news.data.NewsRemoteDataSource;
import com.example.lenovo.mvp_tao.ui.home.news.details_news.DetailsActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsReuseFragment extends BaseFragment implements NewsContract.View, NewsMyAdapterRv.OnClickListener {
        private NewsContract.Presenter mPresenter;
        private String channelName;
        private String channelId;
        private NewsPresenter newsPresenter;
        private RecyclerView rv;
        private NewsMyAdapterRv adapterRv;
        private String cursor="0";
        private RefreshLayout refreshlayout;
        private SmartRefreshLayout refreshLayout;
        private int position;
        private int scorllY;


    @Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
        if (args != null){
            channelId = args.getString("channelId");
            channelName = args.getString("channelName");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null){
            position = savedInstanceState.getInt("postition", 0);
            scorllY = savedInstanceState.getInt("scorllY", 0);
        }

        if (newsPresenter!=null) {
            setPresenter(newsPresenter);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_reuse, container, false);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        refreshLayout = view.findViewById(R.id.refreshLayout);

        newsPresenter = new NewsPresenter(NewsDataRepository.getInstance(NewsRemoteDataSource.getInstance(), NewsLocalDataSource.getInstance(getActivity())));
        setPresenter(newsPresenter);
        newsPresenter.downListNews(channelId,cursor);


        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                refreshlayout = refreshLayout;
                newsPresenter.downListNews(channelId,cursor);

                refreshlayout.finishLoadmore(2000);
            }
        });

        return view;

    }





    @Override
    public void setPresenter(NewsContract.Presenter presenter) {
        newsPresenter = (NewsPresenter) presenter;
        newsPresenter.attachView(this);

        //调用方法进行网络请求

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        getitemPositionAndScrollY();
        outState.putInt("position",position);
        outState.putInt("scorllY",scorllY);
    }
    private void scrollToTargetPosition(){
        if(position != 0 && scorllY != 0){
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) rv.getLayoutManager();
            linearLayoutManager.scrollToPositionWithOffset(position, scorllY);
        }


    }


    @Override
    public void getListNewsChannelFail(String message) {

    }

    @Override
    public void getListNewsChannelSuccess(ArrayList<newsChannelList> list) {
        //返回的频道条目
    }

    @Override
    public void getUpListNewsFail(String message) {

    }

    @Override
    public void getUpListNewsSuccess(ArrayList<newList> list) {
        //刷新新闻列表返回的数据

    }

    @Override
    public void getDownListNewsFail(String message) {

    }

    @Override
    public void getDownListNewsSucess(DownListNews downListNews) {

        if (refreshlayout!=null){
            refreshlayout.finishLoadmore();
        }
        cursor = downListNews.getCursor();
            ArrayList<newListt> newList = downListNews.getNewList();

            LinearLayoutManager manager = new LinearLayoutManager(getActivity());
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            rv.setLayoutManager(manager);
            adapterRv = new NewsMyAdapterRv(getActivity(), newList);
            rv.setAdapter(adapterRv);
            scrollToTargetPosition();

            adapterRv.setOnClickListener(this);
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
    public void getReleventSucess(ArrayList<Relevant> relevant) {

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


    @Override
    public void Click(String newsId) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("newsId",newsId);
        startActivity(intent);
    }

    public void getitemPositionAndScrollY() {
        LinearLayoutManager manager = (LinearLayoutManager) rv.getLayoutManager();
        int itemPosition = manager.findFirstVisibleItemPosition();
        View view = manager.findViewByPosition(itemPosition);
        if (view!=null){
            scorllY = itemPosition;
            scorllY = view.getTop();
        }

    }


}
