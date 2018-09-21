package com.example.lenovo.mvp_tao.ui.home.news.details_news;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.base.BaseActivity;
import com.example.lenovo.mvp_tao.bean.Comment;
import com.example.lenovo.mvp_tao.bean.DownListNews;
import com.example.lenovo.mvp_tao.bean.Newsinfo;
import com.example.lenovo.mvp_tao.bean.Relevant;
import com.example.lenovo.mvp_tao.bean.newList;
import com.example.lenovo.mvp_tao.bean.newsChannelList;
import com.example.lenovo.mvp_tao.bean.userCommentList;
import com.example.lenovo.mvp_tao.ui.home.news.NewsContract;
import com.example.lenovo.mvp_tao.ui.home.news.NewsPresenter;
import com.example.lenovo.mvp_tao.ui.home.news.data.NewsDataRepository;
import com.example.lenovo.mvp_tao.ui.home.news.data.NewsLocalDataSource;
import com.example.lenovo.mvp_tao.ui.home.news.data.NewsRemoteDataSource;
import com.example.lenovo.mvp_tao.utils.CustomRadioButton;
import com.example.lenovo.mvp_tao.utils.StatusBarManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class DetailsActivity extends BaseActivity implements NewsContract.View, View.OnClickListener {

    private ImageView img_return;
    private TextView title;
    private TextView origin;
    private ImageView add_shoucang;
    private TextView time;
    private WebView webview;
    private ImageView major;
    private RecyclerView rv_xiangguan;
    private RecyclerView rv_pinglun;
    private CustomRadioButton rbn_share;
    private CustomRadioButton rbn_pinglun;
    private CustomRadioButton rbn_shoucang;
    private NewsContract.Presenter mPresenter;
    private String newsId;
    private XiangGuanAapter aapter;
    private NewsPresenter newsPresenter;
    private Praisedapter praisedapter;
    private TextView tv_close;
    private TextView tv_confirm;
    private EditText et_discuss;
    private PopupWindow popupWindow;
    private String userId = "d56ea66e7ee741f498ca51242c8c6394";
    private ImageView img_load;
    private ArrayList<userCommentList> list;
    private ArrayList<userCommentList> userCommentLists;
    private int b = 3;
    private String content1;

    private String getNewContent(String htmltext) {

        Document doc = Jsoup.parse(htmltext);
        Elements elements = doc.getElementsByTag("img");
        for (Element element : elements) {
            element.attr("width", "100%").attr("height", "auto");
        }

        Log.d("VACK", doc.toString());
        return doc.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        newsId = intent.getStringExtra("newsId");
        initView();

        StatusBarManager.lightStatusBar(this);
        StatusBarManager.setStatusBarColor(this, ContextCompat.getColor(this, R.color.text_detailsActivity));//D33D3C

        newsPresenter = new NewsPresenter(NewsDataRepository.getInstance(NewsRemoteDataSource.getInstance(), NewsLocalDataSource.getInstance(this)));
        setPresenter(newsPresenter);
        newsPresenter.newInfo(userId, newsId);

        //todo        UserId设置死的  登录页面完善后修改
        newsPresenter.listComment(userId);
        newsPresenter.relevant(newsId); //请求评论列表


    }

    @Override
    public void getListNewsChannelFail(String message) {

    }

    public void getListNewsChannelSuccess(ArrayList<newsChannelList> list) {

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
        content1 = newsinfo.getContent();
        newsId = newsinfo.getNewsId();


        String content = newsinfo.getContent();
        title.setText(newsinfo.getTitle());
        origin.setText(newsinfo.getOrigin());
        time.setText(newsinfo.getPublishTime());

        webview.loadDataWithBaseURL(null, getNewContent(newsinfo.getContent()), "text/html", "UTF-8", null);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setUseWideViewPort(true);         //将图片调整到适合WebView的大小

        webview.setWebChromeClient(new WebChromeClient());
        webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);    //自适应屏幕
    }

    @Override
    public void getgetReleventFail(String message) {

    }

    @Override
    public void getReleventSucess(ArrayList<Relevant> list) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_xiangguan.setLayoutManager(manager);

        rv_xiangguan.setNestedScrollingEnabled(false);

        aapter = new XiangGuanAapter(this, list);
        rv_xiangguan.setAdapter(aapter);
    }

    @Override
    public void getListCommentFail(String message) {
        Log.d("评论列表", message);
    }

    @Override
    public void getListCommentSucess(Comment comment) {

        //评论列表
        list = comment.getUserCommentList();


        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_pinglun.setLayoutManager(manager);
        rv_pinglun.setNestedScrollingEnabled(false);    //設置嵌套不可滑動

        userCommentLists = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            userCommentLists.add(list.get(i));
        }

        praisedapter = new Praisedapter(this, userCommentLists);
        rv_pinglun.setAdapter(praisedapter);


    }

    @Override
    public void getCommentFail(String message) {

    }

    @Override
    public void getCommentSucess(Object o) {
        Toast.makeText(this, "发布成功", Toast.LENGTH_SHORT).show();
        newsPresenter.listComment(userId);
    }


    @Override
    public void setPresenter(NewsContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.attachView(this);

    }

    @Override
    public Activity getActivity() {
        return null;
    }

    private void initView() {
        img_return = (ImageView) findViewById(R.id.img_return);
        title = (TextView) findViewById(R.id.title);
        origin = (TextView) findViewById(R.id.origin);
        add_shoucang = (ImageView) findViewById(R.id.add_shoucang);
        time = (TextView) findViewById(R.id.time);
        webview = (WebView) findViewById(R.id.webview);
        major = (ImageView) findViewById(R.id.major);
        rv_xiangguan = (RecyclerView) findViewById(R.id.rv_xiangguan);
        rv_pinglun = (RecyclerView) findViewById(R.id.rv_pinglun);
        rbn_share = (CustomRadioButton) findViewById(R.id.rbn_share);
        rbn_pinglun = (CustomRadioButton) findViewById(R.id.rbn_pinglun);
        rbn_shoucang = (CustomRadioButton) findViewById(R.id.rbn_shoucang);
        img_load = findViewById(R.id.img_load);

        //点击分享
        rbn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, content1);
                startActivity(Intent.createChooser(intent, "分享"));
            }
        });

        //评论列表点击加载更多
        img_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b >= list.size()) {
                    Toast.makeText(DetailsActivity.this, "没有更多数据", Toast.LENGTH_SHORT).show();
                } else {
                    for (int i = 0; i < 3; i++) {
//                        mlist.clear();
                        userCommentLists.add(list.get(b));
                        b++;
                    }
//                    mpresenter.getSendData(channelId, "d56ea66e7ee741f498ca51242c8c6394", "0", "测试");
                    praisedapter.notifyDataSetChanged();

                }

            }
        });

        rbn_pinglun.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rbn_pinglun:
                showpopuoComment();
                break;

        }
    }

    @SuppressLint("WrongConstant")
    private void showpopuoComment() {
        View view = LayoutInflater.from(this).inflate(R.layout.exittext_news_details, null);
        tv_close = view.findViewById(R.id.tv_close);
        tv_confirm = view.findViewById(R.id.tv_confirm);
        et_discuss = view.findViewById(R.id.et_discuss);
        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
            }
        });

        popupWindow = new PopupWindow(view, RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT, false);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
            }
        });
        popupWindow.setFocusable(true);

        //设置点击外边窗口popupwindow消失
        popupWindow.setOutsideTouchable(true);
        //设置弹出窗体软键盘
        popupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);

        //设置模式，和Activity一样，覆盖，调整大小
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        ColorDrawable drawable = new ColorDrawable(0x000000);
        popupWindow.setBackgroundDrawable(drawable);

        //拉起小键盘
        InputMethodManager inputMethodManager = (InputMethodManager) et_discuss.getContext().getSystemService(Service.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);


        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 0.4f;
        getWindow().setAttributes(params);

//        popupWindow.update();

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            // 在dismiss中恢复透明度
            public void onDismiss() {
                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.alpha = 1f;
                getWindow().setAttributes(params);
            }
        });

        //发布评论信息
        tv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_discuss.getText().toString() != null && "".equals(et_discuss.getText().toString())) {
                    Toast.makeText(DetailsActivity.this, "评论内容不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                //todo        UserId设置死的  登录模块完善后修改
                newsPresenter.Comment(userId, "d56ea66e7ee741f498ca51242c8c6394", "0", et_discuss.getText().toString());

                popupWindow.dismiss();

            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            System.out.println("按下了back键   onKeyDown()");
            finish();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
