package com.example.lenovo.mvp_tao.ui.home.news.data;

import android.app.Activity;

import com.example.lenovo.mvp_tao.bean.Comment;
import com.example.lenovo.mvp_tao.bean.DownListNews;
import com.example.lenovo.mvp_tao.bean.NewsChannel;
import com.example.lenovo.mvp_tao.bean.Newsinfo;
import com.example.lenovo.mvp_tao.bean.Relevant;
import com.example.lenovo.mvp_tao.bean.UpListNews;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.ArrayList;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;

public interface NewsDataSource {

    //频道
    void listNewsChannel(RxFragment fragment, Map<String,String> map, Observer<NewsChannel> observer);
    //刷新新闻列表
    void upListNews(RxFragment fragment, Map<String,String> map, Observer<UpListNews> observer);
    //加载新闻列表
    Observable<DownListNews> getDownNews(Map<String,String> map);
    //保存新闻
    void saveNews(String channelId, DownListNews data);
    //新闻详情
    void NewsInfo(LifecycleProvider lifecycleProvider, Map<String,String> map, Observer<Newsinfo> observer);
    //相关新闻
    void Relevent(LifecycleProvider lifecycleProvider, Map<String,String> map, Observer<ArrayList<Relevant>> observer);
    //评论列表
    void ListComment(LifecycleProvider lifecycleProvider, Map<String,String> map, Observer<Comment> observer);
    //评论
    void Comment(LifecycleProvider lifecycleProvider,Map<String,String> map,Observer<Object> observer);

}
