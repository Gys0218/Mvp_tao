package com.example.lenovo.mvp_tao.ui.home.news.data;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.lenovo.mvp_tao.bean.Comment;
import com.example.lenovo.mvp_tao.bean.DownListNews;
import com.example.lenovo.mvp_tao.bean.NewsChannel;
import com.example.lenovo.mvp_tao.bean.Newsinfo;
import com.example.lenovo.mvp_tao.bean.Relevant;
import com.example.lenovo.mvp_tao.bean.UpListNews;
import com.example.lenovo.mvp_tao.data.UserDataRepository;
import com.example.lenovo.mvp_tao.data.UserDataSource;
import com.example.lenovo.mvp_tao.data.UserRemoteDataSource;
import com.example.lenovo.mvp_tao.ui.home.news.NewsContract;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.components.support.RxFragment;
import com.trello.rxlifecycle2.internal.Preconditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

public class NewsDataRepository implements NewsDataSource{

    @NonNull
    private NewsDataSource mRemote;
    private NewsDataSource mLocal;
    private Map<String, DownListNews> mMemoryCache;

    @Nullable
    private static NewsDataRepository INSTANCE = null;

    private NewsDataRepository(@NonNull NewsDataSource remote,NewsDataSource local){

        mRemote = remote;
        mLocal = local;

    }

    public static synchronized NewsDataRepository getInstance(NewsDataSource remote,NewsDataSource local){

        if (INSTANCE == null){
            INSTANCE = new NewsDataRepository(remote,local);
        }
        return INSTANCE;

    }

    @Override
    public void listNewsChannel(RxFragment fragment, Map<String, String> map, Observer<NewsChannel> observer) {
        mRemote.listNewsChannel(fragment,map,observer);
    }

    @Override
    public void upListNews(RxFragment fragment, Map<String, String> map, Observer<UpListNews> observer) {
        mRemote.upListNews(fragment,map,observer);
    }

    @Override
    public Observable<DownListNews> getDownNews(Map<String, String> map) {
        String channelId = map.get(NewsContract.PARAMS_CHANNER_ID);
        if (mMemoryCache!=null&&mMemoryCache.get(NewsContract.PARAMS_CHANNER_ID)!=null){
            return Observable.just(mMemoryCache.get(NewsContract.PARAMS_CHANNER_ID));
        }

        Observable<DownListNews> remoteObservable = getAndSaveRemoteNewsData(map);

        return Observable.concat(mLocal.getDownNews(map),remoteObservable);
    }

    @Override
    public void saveNews(String channelId, DownListNews data) {

    }

    @Override
    public void NewsInfo(LifecycleProvider lifecycleProvider, Map<String, String> map, Observer<Newsinfo> observer) {
        mRemote.NewsInfo(lifecycleProvider,map,observer);
    }

    @Override
    public void Relevent(LifecycleProvider lifecycleProvider, Map<String, String> map, Observer<ArrayList<Relevant>> observer) {
        mRemote.Relevent(lifecycleProvider,map,observer);
    }

    @Override
    public void ListComment(LifecycleProvider lifecycleProvider, Map<String, String> map, Observer<Comment> list) {
        mRemote.ListComment(lifecycleProvider,map,list);
    }

    @Override
    public void Comment(LifecycleProvider lifecycleProvider, Map<String, String> map, Observer<Object> observer) {
        mRemote.Comment(lifecycleProvider,map,observer);
    }

    private Observable<DownListNews> getAndSaveRemoteNewsData(Map<String, String> map) {
        final String channelId = map.get(NewsContract.PARAMS_CHANNER_ID);

        Observable<DownListNews> observable = mRemote.getDownNews(map);

        return observable.doOnNext(new Consumer<DownListNews>() {
            @Override
            public void accept(DownListNews data) throws Exception {

                saveRefreshDataToMemory(channelId, data);//保存刷新
                saveLoadMoreDataToMemory(channelId,data);//保存加载更多
                mLocal.saveNews(channelId,mMemoryCache.get(channelId).getNewsDataForSdcardCache());
            }
        });
    }

    private void saveLoadMoreDataToMemory(String channelId, DownListNews data) {
        if (mMemoryCache == null){
            mMemoryCache = new HashMap<>();
        }
        DownListNews downListNews = mMemoryCache.get(channelId);
        if (downListNews == null){
            downListNews = new DownListNews();
            mMemoryCache.put(channelId,downListNews);
        }

        downListNews.mergeLoadMoreData(data);
    }


    /**
     * 保存刷新回来的数据到内存
     *
     * @param channelId
     * @param data
     */
    private void  saveRefreshDataToMemory(String channelId, DownListNews data) {
        if (mMemoryCache == null) {
            mMemoryCache = new HashMap<>();
        }


        DownListNews downListNews = mMemoryCache.get(channelId);

        if (downListNews == null) {
            downListNews = new DownListNews();
            mMemoryCache.put(channelId, data);
        }

        if (data.getNewList().size() >= 7) {
            downListNews.replace(data);
        } else {
            downListNews.mergeRefreshData(data);
        }


    }
}
