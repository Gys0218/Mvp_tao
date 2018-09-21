package com.example.lenovo.mvp_tao.ui.home.activity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.base.BaseActivity;
import com.example.lenovo.mvp_tao.data.UserDataRepository;
import com.example.lenovo.mvp_tao.ui.home.me.MeFragment;
import com.example.lenovo.mvp_tao.ui.home.news.NewsFragment;
import com.example.lenovo.mvp_tao.ui.home.news.NewsPresenter;
import com.example.lenovo.mvp_tao.ui.home.news.data.NewsDataRepository;
import com.example.lenovo.mvp_tao.ui.home.news.data.NewsLocalDataSource;
import com.example.lenovo.mvp_tao.ui.home.news.data.NewsRemoteDataSource;
import com.example.lenovo.mvp_tao.ui.home.topic.TopicFragment;

public class HomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radiogroup;
    private RadioButton news;
    private RadioButton topic;
    private RadioButton me;
    private NewsPresenter newsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);

        radiogroup.setOnCheckedChangeListener(this);
        news = (RadioButton) findViewById(R.id.news);
        topic = (RadioButton) findViewById(R.id.topic);
        me = (RadioButton) findViewById(R.id.me);

        newsPresenter = new NewsPresenter(NewsDataRepository.getInstance(NewsRemoteDataSource.getInstance(), NewsLocalDataSource.getInstance(this)));

        news.setChecked(true);
        addFragment(NewsFragment.class, newsPresenter,R.id.form,null,null);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.news:
                addFragment(NewsFragment.class, newsPresenter,R.id.form,null,null);
                break;
            case R.id.topic:

                addFragment(TopicFragment.class, newsPresenter,R.id.form,null,null);

                break;
            case R.id.me:

                addFragment(MeFragment.class, newsPresenter,R.id.form,null,null);

                break;
        }
    }

}
