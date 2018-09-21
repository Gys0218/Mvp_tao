package com.example.lenovo.mvp_tao.ui.home.news.data;

import android.app.Activity;
import android.util.Log;

import com.example.lenovo.mvp_tao.bean.Comment;
import com.example.lenovo.mvp_tao.bean.DownListNews;
import com.example.lenovo.mvp_tao.bean.HttpResult;
import com.example.lenovo.mvp_tao.bean.NewsChannel;
import com.example.lenovo.mvp_tao.bean.Newsinfo;
import com.example.lenovo.mvp_tao.bean.Relevant;
import com.example.lenovo.mvp_tao.bean.UpListNews;
import com.example.lenovo.mvp_tao.data.soure.ServerException;
import com.example.lenovo.mvp_tao.retrofit.Apiservice;
import com.example.lenovo.mvp_tao.retrofit.DataRetrofit;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class NewsRemoteDataSource implements NewsDataSource{

    private static NewsRemoteDataSource INSTANCE = null;
    private Apiservice apiservice;


    public NewsRemoteDataSource(){
        apiservice = DataRetrofit.getRetrofit();
    }

    public static synchronized NewsRemoteDataSource  getInstance(){

        if(INSTANCE == null){
            INSTANCE = new NewsRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void listNewsChannel(RxFragment fragment, Map<String, String> map, Observer<NewsChannel> observer) {
        Observable<HttpResult<NewsChannel>> channel = apiservice.listNewsChannel();
        Log.e("UserRemoteDataSource", map.toString());
        channel.flatMap(new Function<HttpResult<NewsChannel>, ObservableSource<NewsChannel>>() {
            @Override
            public ObservableSource<NewsChannel> apply(HttpResult<NewsChannel> userHttpResult) throws Exception {

                if (userHttpResult.getCode() == 0) {
                    return Observable.just(userHttpResult.getData());
                }
                return Observable.error(new ServerException(userHttpResult.getCode(), userHttpResult.getMessage()));
            }
        }).subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .compose(fragment.<NewsChannel>bindUntilEvent(FragmentEvent.DETACH))//此方法暂时不知
                .subscribe(observer);
    }

    @Override
    public void upListNews(RxFragment fragment, Map<String, String> map, Observer<UpListNews> observer) {
        Observable<HttpResult<UpListNews>> observable = apiservice.upListNews(map);
        observable.flatMap(new Function<HttpResult<UpListNews>, ObservableSource<UpListNews>>() {
            @Override
            public ObservableSource<UpListNews> apply(HttpResult<UpListNews> upListNewsHttpResult) throws Exception {
                if (upListNewsHttpResult.getCode() == 0){
                    return Observable.just(upListNewsHttpResult.getData());
                }
                return Observable.error(new ServerException(upListNewsHttpResult.getCode(),upListNewsHttpResult.getMessage()));
            }
        }).subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .compose(fragment.<UpListNews>bindUntilEvent(FragmentEvent.DETACH))
                .subscribe(observer);
    }

    @Override
    public Observable<DownListNews> getDownNews(Map<String, String> map) {
        Observable<HttpResult<DownListNews>> observable = apiservice.downListNews(map);
        return observable.flatMap(new Function<HttpResult<DownListNews>, ObservableSource<DownListNews>>() {
            @Override
            public ObservableSource<DownListNews> apply(HttpResult<DownListNews> downListNewsHttpResult) throws Exception {
                if (downListNewsHttpResult.getCode() == 0){
                    DownListNews data = downListNewsHttpResult.getData();
                    if (data!=null&&data.getNewList()!=null&&data.getNewList().size()>0){
                        return Observable.just(data);
                    }
                    return Observable.error(new ServerException(1,"错误"));
                }
                return Observable.error(new ServerException(downListNewsHttpResult.getCode(),downListNewsHttpResult.getMessage()));

            }
        });


    }

    @Override
    public void saveNews(String channelId, DownListNews data) {

    }

    @Override
    public void NewsInfo(LifecycleProvider lifecycleProvider, Map<String, String> map, Observer<Newsinfo> observer) {
        Observable<HttpResult<Newsinfo>> newsinfo = apiservice.newsinfo(map);
        newsinfo.flatMap(new Function<HttpResult<Newsinfo>, ObservableSource<Newsinfo>>() {
            @Override
            public ObservableSource<Newsinfo> apply(HttpResult<Newsinfo> newsinfoHttpResult) throws Exception {
                if (newsinfoHttpResult.getCode() == 0){
                    Log.e("NewsRemoteDataSource", newsinfoHttpResult.getData().toString());
                    return Observable.just(newsinfoHttpResult.getData());
                }
                return Observable.error(new ServerException(newsinfoHttpResult.getCode(),newsinfoHttpResult.getMessage()));
            }
        }).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose((lifecycleProvider instanceof RxAppCompatActivity) ? ((RxAppCompatActivity) lifecycleProvider).<Newsinfo>bindUntilEvent(ActivityEvent.DESTROY):lifecycleProvider.<Newsinfo>bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(observer);
    }

    @Override
    public void Relevent(LifecycleProvider lifecycleProvider, Map<String, String> map, Observer<ArrayList<Relevant>> observer) {
        Observable<HttpResult<List<Relevant>>> observable = apiservice.relevant(map);
        observable.flatMap(new Function<HttpResult<List<Relevant>>, ObservableSource<List<Relevant>>>() {
            @Override
            public ObservableSource<List<Relevant>> apply(HttpResult<List<Relevant>> listHttpResult) throws Exception {
                if (listHttpResult.getCode() == 0){
                    return Observable.just(listHttpResult.getData());
                }
                return Observable.error(new ServerException(listHttpResult.getCode(),listHttpResult.getMessage()));
            }
        })
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose((lifecycleProvider instanceof RxAppCompatActivity) ? ((RxAppCompatActivity) lifecycleProvider).<Relevant>bindUntilEvent(ActivityEvent.DESTROY):lifecycleProvider.<Relevant>bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(observer);
    }

    @Override
    public void ListComment(LifecycleProvider lifecycleProvider, Map<String, String> map, Observer<Comment> observer) {
        Observable<HttpResult<Comment>> observable = apiservice.listComment(map);
        observable.flatMap(new Function<HttpResult<Comment>, ObservableSource<Comment>>() {
            @Override
            public ObservableSource<Comment> apply(HttpResult<Comment> arrayListHttpResult) throws Exception {
                if (arrayListHttpResult.getCode() == 0){
                    return Observable.just(arrayListHttpResult.getData());
                }
                return Observable.error(new ServerException(arrayListHttpResult.getCode(),arrayListHttpResult.getMessage()));
            }
        }).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(lifecycleProvider instanceof RxAppCompatActivity ? (((RxAppCompatActivity) lifecycleProvider).<ArrayList<Comment>>bindUntilEvent(ActivityEvent.DESTROY)) : lifecycleProvider.<ArrayList<Comment>>bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(observer);
    }

    @Override
    public void Comment(LifecycleProvider lifecycleProvider, Map<String, String> map, Observer<Object> observer) {
        Observable<HttpResult<Object>> observable = apiservice.comment(map);
        observable.flatMap(new Function<HttpResult<Object>, ObservableSource<Object>>() {
            @Override
            public ObservableSource<Object> apply(HttpResult<Object> objectHttpResult) throws Exception {
                if (objectHttpResult.getCode() == 0){
                    return Observable.just(new Object());
                }
                return Observable.error(new ServerException(objectHttpResult.getCode(),objectHttpResult.getMessage()));
            }
        }).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose((lifecycleProvider instanceof RxAppCompatActivity) ? ((RxAppCompatActivity) lifecycleProvider).bindUntilEvent(ActivityEvent.DESTROY) : lifecycleProvider.bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(observer);
    }
}
