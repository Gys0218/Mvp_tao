package com.example.lenovo.mvp_tao.ui.home.news.data;

import android.app.Activity;
import android.content.Context;

import com.example.lenovo.mvp_tao.bean.Comment;
import com.example.lenovo.mvp_tao.bean.DownListNews;
import com.example.lenovo.mvp_tao.bean.NewsChannel;
import com.example.lenovo.mvp_tao.bean.Newsinfo;
import com.example.lenovo.mvp_tao.bean.Relevant;
import com.example.lenovo.mvp_tao.bean.UpListNews;
import com.example.lenovo.mvp_tao.ui.home.news.NewsContract;
import com.example.lenovo.mvp_tao.utils.FilesUtils;
import com.example.lenovo.mvp_tao.utils.SystemFacade;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;

public class NewsLocalDataSource implements NewsDataSource {

    private static NewsLocalDataSource INSTANCE = null;
    private File mDataCacheFileDir;
    private final File cacheDir;

    public static synchronized NewsLocalDataSource  getInstance(Context context){

        if(INSTANCE == null){
            INSTANCE = new NewsLocalDataSource(context);
        }
        return INSTANCE;
    }

    public NewsLocalDataSource(Context context){
        cacheDir = SystemFacade.getExternalCacheDir(context);
        if (cacheDir != null&&cacheDir.exists()){
            mDataCacheFileDir = new File(cacheDir,"news_fils");
        }

    }

    @Override
    public void listNewsChannel(RxFragment fragment, Map<String, String> map, Observer<NewsChannel> observer) {

    }

    @Override
    public void upListNews(RxFragment fragment, Map<String, String> map, Observer<UpListNews> observer) {

    }

    @Override
    public Observable<DownListNews> getDownNews(Map<String, String> map) {
        final String channelId = map.get(NewsContract.PARAMS_CHANNER_ID);
        return Observable.create(new ObservableOnSubscribe<DownListNews>() {
            @Override
            public void subscribe(ObservableEmitter<DownListNews> emitter) throws Exception {
                DownListNews newsFromFile = FilesUtils.getNewsFromFile(createCacheFile(channelId));
                if (newsFromFile!=null){
                    emitter.onNext(newsFromFile);
                }
                emitter.onComplete();
            }
        });

    }

    @Override
    public void saveNews(String channelId, DownListNews data) {
        FilesUtils.writeNewsDataToFile(data,createCacheFile(channelId));
    }

    @Override
    public void NewsInfo(LifecycleProvider lifecycleProvider, Map<String, String> map, Observer<Newsinfo> observer) {

    }

    @Override
    public void Relevent(LifecycleProvider lifecycleProvider, Map<String, String> map, Observer<ArrayList<Relevant>> observer) {

    }

    @Override
    public void ListComment(LifecycleProvider lifecycleProvider, Map<String, String> map, Observer<Comment> list) {

    }

    @Override
    public void Comment(LifecycleProvider lifecycleProvider, Map<String, String> map, Observer<Object> observer) {

    }


    private File createCacheFile(String channelId) {
        if (mDataCacheFileDir != null) {
            if(!mDataCacheFileDir.exists()){
                mDataCacheFileDir.mkdirs();
            }
            return new File(mDataCacheFileDir, channelId);
        }

        return null;
    }
}
