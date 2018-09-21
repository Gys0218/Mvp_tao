package com.example.lenovo.mvp_tao.ui.home.news;

import android.support.v4.app.Fragment;

import com.example.lenovo.mvp_tao.base.BasePresenter;
import com.example.lenovo.mvp_tao.base.BaseView;
import com.example.lenovo.mvp_tao.bean.Comment;
import com.example.lenovo.mvp_tao.bean.DownListNews;
import com.example.lenovo.mvp_tao.bean.Newsinfo;
import com.example.lenovo.mvp_tao.bean.Relevant;
import com.example.lenovo.mvp_tao.bean.newList;
import com.example.lenovo.mvp_tao.bean.newsChannelList;
import com.example.lenovo.mvp_tao.bean.userCommentList;

import java.util.ArrayList;

public interface NewsContract {

    public static final String PARAMS_CHANNER_ID = "channelId";

    public interface View extends BaseView<NewsContract.Presenter>{
        //频道
        void getListNewsChannelFail(String message);
        void getListNewsChannelSuccess(ArrayList<newsChannelList> list);

        //刷新新闻列表
        void getUpListNewsFail(String message);
        void getUpListNewsSuccess(ArrayList<newList> list);

        //加载新闻列表
        void getDownListNewsFail(String message);
        void getDownListNewsSucess(DownListNews downListNews);

        //新闻详情
        void getNewsInfoFail(String message);
        void getNewsInfoSuccess(Newsinfo newsinfo);

        //相关新闻
        void getgetReleventFail(String message);
        void getReleventSucess(ArrayList<Relevant> list);

        //评论列表
        void getListCommentFail(String message);
        void getListCommentSucess(Comment comment);

        //评论
        void getCommentFail(String message);
        void getCommentSucess(Object o );

    }


    public interface Presenter extends BasePresenter<NewsContract.View>{
        //频道列表
        void listNewsChannel();
        //刷新新闻列表
        void NewsUpListNews(String channelId);
        //加载新闻列表
        void downListNews(String channelId,String cursor);
        //新闻详情
        void newInfo(String userId,String newsId);
        //相关新闻
        void relevant(String newsId);
        //评论列表
        void listComment(String userId);
        //评论
        void Comment(String userId,String objectI ,String objectType,String content);

    }

}
