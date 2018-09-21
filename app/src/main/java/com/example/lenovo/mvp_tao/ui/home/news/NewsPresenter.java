package com.example.lenovo.mvp_tao.ui.home.news;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.lenovo.mvp_tao.bean.Comment;
import com.example.lenovo.mvp_tao.bean.DownListNews;
import com.example.lenovo.mvp_tao.bean.NewsChannel;
import com.example.lenovo.mvp_tao.bean.Newsinfo;
import com.example.lenovo.mvp_tao.bean.Relevant;
import com.example.lenovo.mvp_tao.bean.UpListNews;
import com.example.lenovo.mvp_tao.bean.newList;
import com.example.lenovo.mvp_tao.bean.newsChannelList;
import com.example.lenovo.mvp_tao.bean.userCommentList;
import com.example.lenovo.mvp_tao.data.UserDataSource;
import com.example.lenovo.mvp_tao.ui.home.news.data.NewsDataSource;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewsPresenter implements NewsContract.Presenter{
    private NewsContract.View mView;
    private NewsDataSource mNewsDataRepository;

    @Override
    public void attachView(NewsContract.View baseView) {
        mView = baseView;
    }


    public NewsPresenter(NewsDataSource newsDataRepository){
        mNewsDataRepository = newsDataRepository;
    }

    //频道
    @Override
    public void listNewsChannel() {
        HashMap<String, String> map = new HashMap<>();
        mNewsDataRepository.listNewsChannel((RxFragment) mView, map, new io.reactivex.Observer<NewsChannel>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(NewsChannel newsChannel) {
                ArrayList<newsChannelList> list = newsChannel.getNewsChannelList();

                mView.getListNewsChannelSuccess(list);
            }

            @Override
            public void onError(Throwable e) {
                mView.getListNewsChannelFail(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    //刷新新闻列表
    @Override
    public void NewsUpListNews(String channelId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("userId","d56ea66e7ee741f498ca51242c8c6394");
        map.put("channelId",channelId);
        map.put("cursor","0");


        mNewsDataRepository.upListNews((RxFragment) mView, map, new io.reactivex.Observer<UpListNews>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(UpListNews upListNews) {
                ArrayList<newList> newList = upListNews.getNewList();
                mView.getUpListNewsSuccess(newList);
            }

            @Override
            public void onError(Throwable e) {
                mView.getListNewsChannelFail(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void downListNews(String channelId, String cursor) {
        HashMap<String, String> map = new HashMap<>();
        map.put("channelId",channelId);
        map.put("cursor",cursor);

        mNewsDataRepository.getDownNews(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose( (mView instanceof RxAppCompatActivity) ? ((RxAppCompatActivity) mView).<DownListNews>bindUntilEvent(ActivityEvent.DESTROY):(((RxFragment)mView).<DownListNews>bindUntilEvent(FragmentEvent.DETACH)))
                .subscribe(new Observer<DownListNews>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DownListNews downListNews) {

                        mView.getDownListNewsSucess(downListNews);

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.getDownListNewsFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void newInfo(String userId, String newsId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("userId",userId);
        map.put("newsId",newsId);
        mNewsDataRepository.NewsInfo((LifecycleProvider) mView, map, new Observer<Newsinfo>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Newsinfo newsinfo) {
                mView.getNewsInfoSuccess(newsinfo);
            }

            @Override
            public void onError(Throwable e) {
                mView.getNewsInfoFail(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void relevant(String newsId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("newsId",newsId);
        mNewsDataRepository.Relevent((LifecycleProvider) mView, map, new Observer<ArrayList<Relevant>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<Relevant> relevant) {
                mView.getReleventSucess(relevant);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void listComment(String userId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("userId",userId);

        mNewsDataRepository.ListComment((LifecycleProvider) mView, map, new Observer<Comment>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Comment comment) {
                mView.getListCommentSucess(comment);
            }

            @Override
            public void onError(Throwable e) {
                mView.getListCommentFail(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void Comment(String userId, String objectId, String objectType, String content) {
        HashMap<String, String> map = new HashMap<>();
        map.put("userId",userId);
        map.put("objectId",objectId);
        map.put("objectType",objectType);
        map.put("content",content);

        mNewsDataRepository.Comment((LifecycleProvider) mView, map, new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                mView.getCommentSucess(o);
            }

            @Override
            public void onError(Throwable e) {
                mView.getCommentFail(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }


    @Override
    public void detachView() {
        mView =null;
    }
}
