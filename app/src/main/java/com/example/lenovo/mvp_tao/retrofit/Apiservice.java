package com.example.lenovo.mvp_tao.retrofit;

import com.example.lenovo.mvp_tao.bean.AboutUs;
import com.example.lenovo.mvp_tao.bean.Comment;
import com.example.lenovo.mvp_tao.bean.DetailsTopic;
import com.example.lenovo.mvp_tao.bean.DownListNews;
import com.example.lenovo.mvp_tao.bean.EditInfo;
import com.example.lenovo.mvp_tao.bean.Equipment;
import com.example.lenovo.mvp_tao.bean.Feedback;
import com.example.lenovo.mvp_tao.bean.Follow;
import com.example.lenovo.mvp_tao.bean.HeadImage;
import com.example.lenovo.mvp_tao.bean.HttpResult;
import com.example.lenovo.mvp_tao.bean.Info;
import com.example.lenovo.mvp_tao.bean.ListComment;
import com.example.lenovo.mvp_tao.bean.ListFeedback;
import com.example.lenovo.mvp_tao.bean.ListNotify;
import com.example.lenovo.mvp_tao.bean.LoadTopic;
import com.example.lenovo.mvp_tao.bean.MoreFollow;
import com.example.lenovo.mvp_tao.bean.News;
import com.example.lenovo.mvp_tao.bean.NewsChannel;
import com.example.lenovo.mvp_tao.bean.Newsinfo;
import com.example.lenovo.mvp_tao.bean.Newssearch;
import com.example.lenovo.mvp_tao.bean.Profession;
import com.example.lenovo.mvp_tao.bean.Question;
import com.example.lenovo.mvp_tao.bean.RefreshTopic;
import com.example.lenovo.mvp_tao.bean.Relevant;
import com.example.lenovo.mvp_tao.bean.Search;
import com.example.lenovo.mvp_tao.bean.Searchtopic;
import com.example.lenovo.mvp_tao.bean.Tags;
import com.example.lenovo.mvp_tao.bean.Topic;
import com.example.lenovo.mvp_tao.bean.UpListNews;
import com.example.lenovo.mvp_tao.bean.User;
import com.example.lenovo.mvp_tao.bean.UserProtocol;
import com.example.lenovo.mvp_tao.bean.Useriofo;
import com.example.lenovo.mvp_tao.bean.Versions;
import com.example.lenovo.mvp_tao.bean.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface Apiservice {
    //登录和第三方路劲相同参数和返回值不相同，所以使用用一个注解
    // users/phoneLogin     headers：Content-Type:application/json
    @Headers("Content-Type:application/json")
    @POST("users/phoneLogin")
    Observable<HttpResult<User>> login(@Body Map<String,String> params);


    //快速登录
    @Headers("Content-Type:application/json")
    @POST("users/fastLogin")
    Observable<HttpResult<User>> fastLogin(@Body Map<String,String> params);



    //手机号登出
    @Headers("Content-Type:application/json")
    @POST("users/logout")
    Observable<HttpResult<Object>> logout(@Body Map<String,String> params);



    //发送验证码
    @Headers("Content-Type:application/json")
    @POST("users/sendVerificationCode")
    Observable<HttpResult<Object>> sendVerificationCode(@Body Map<String,String> params);



    //职业列表        users/phoneLogin
    @Headers("Content-Type:application/json")
    @POST("/users/listProfession")
    Observable<HttpResult<Profession>> listProfession(@Body Map<String,String> params);



    //版本升级
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("users/updateVersion")
    Observable<HttpResult<Versions>> versions(@Body Map<String,String> params);



    //手机硬件设备信息统计  equipment
    @Headers("Content-Type:application/json")
    @POST("users/insertDevice")
    Observable<HttpResult<Equipment>> equipment(@Body Map<String,String> params);



    //用户中心-首页   user_center_home
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("users/center")   //headler : Content-Type:application/x-www-form-urlencoded
    Observable<HttpResult<User>> user_center_home(@Body Map<String,String> params);



    //设置-修改设置信息
    @Headers("Content-Type:application/json")
    @POST("users/updateUserSetting")
    Observable<HttpResult<Object>> updateUserSetting(@Body Map<String,String> params);



    //设置-个人设置       headerl:Content-Type:application/x-www-form-urlencoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("users/info")
    Observable<HttpResult<Info>> info(@Body Map<String,String> params);



    //设置-修改个人信息
    @Headers("Content-Type:application/json")
    @POST("users/updateInfo")
    Observable<HttpResult<Object>> updateInfo(@Body Map<String,String> params);



    //上传图片
    @Headers("Content-Type:multipart/form-data")
    @POST("users/uploadHeadImage")
    Observable<HttpResult<HeadImage>> uploadHeadImage(@Body Map<String,String> params);


    //用户反馈-提交反馈
    @Headers("Content-Type:multipart/form-data")
    @POST("users/feedback")
    Observable<HttpResult<Feedback>> feedback(@Body Map<String,String> params);



    //用户反馈-反馈列表
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("users/listFeedback")
    Observable<HttpResult<ListFeedback>> listFeedback(@Body Map<String,String> params);



    //用户反馈-常见问题
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("users/question")
    Observable<HttpResult<Question>> question(@Body Map<String,String> params);



    //评论-评论列表       heanderl : Content-Type:application/x-www-form-urlencoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("users/listComment")
    Observable<HttpResult<Comment>> listComment(@FieldMap Map<String,String> params);



    //用户评论新闻|话题
    @Headers("Content-Type:application/json")
    @POST("users/comment")
    Observable<HttpResult<Object>> comment(@Body Map<String,String> params);



    //用户收藏新闻|话题
    @Headers("Content-Type:application/json")
    @POST("users/favourite")
    Observable<HttpResult<Object>> favourite(@Body Map<String,String> params);



    //用户点赞新闻|话题
    @Headers("Content-Type:application/json")
    @POST("users/like")
    Observable<HttpResult<Object>> like(@Body Map<String,String> params);



    //用户举报新闻|话题
    @Headers("Content-Type:application/json")
    @POST("users/report")
    Observable<HttpResult<Object>> report(@Body Map<String,String> params);


    //关注用户
    @Headers("Content-Type:application/json")
    @POST("users/follow")
    Observable<HttpResult<Object>> follow(@Body Map<String,String> params);



    //关注-我的关注列表
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("users/listFollow")
    Observable<HttpResult<Follow>> listFollow(@Body Map<String,String> params);



    //关注-我的关注列表-删除关注用户
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("users/batchDelFollow")
    Observable<HttpResult<Object>> batchDelFollow(@Body Map<String,String> params);



    //关注-更多关注-关注列表
    @Headers("Content-Type:application/json")
    @POST("users/moreFollow")
    Observable<HttpResult<MoreFollow>> moreFollow(@Body Map<String,String> params);



    //收藏-新闻列表
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("users/favourite/news")
    Observable<HttpResult<News>> news(@Body Map<String,String> params);



    //收藏-话题列表
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("users/favourite/topic")
    Observable<HttpResult<Topic>> topic(@Body Map<String ,String> params);



    //收藏-删除我的收藏     //Content-Type:application/x-www-form-urlencoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("users/batchDelFavourite")
    Observable<HttpResult<Object>> batchDelFavourite(@Body Map<String,String> params);



    //收藏-话题列表       headerl : Content-Type:application/x-www-form-urlencoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("users/listTopic")
    Observable<HttpResult<Topic>> listTopic(@Body Map<String,String> params);



    //用户主页-用户信息     headerl ; Content-Type:application/x-www-form-urlencoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("users/homePage/info")
    Observable<HttpResult<Useriofo>> homePage_info(@Body Map<String,String> params);



    //用户主页-话题列表
    @Headers("Content-Type:application/json")
    @POST("users/homePage/list")
    Observable<HttpResult<Topic>> homePage_list(@Body Map<String,String> params);



    //消息通知-消息列表 // todo 外层集合  可能会有问题
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("users/listNotify")
    Observable<HttpResult<ArrayList<ListNotify>>> listNotify(@Body Map<String,String> params);




    //消息通知-清空通知     Content-Type:application/x-www-form-urlencoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("users/deleteAllNotify")
    Observable<HttpResult<Object>> deleteAllNotify(@Body Map<String,String> params);



    //用户协议      Content-Type:application/x-www-form-urlencoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("users/userProtocol")
    Observable<HttpResult<UserProtocol>> userProtocol(@Body Map<String,String> params);



    //关于我们      Content-Type:application/x-www-form-urlencoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("users/aboutUs")
    Observable<HttpResult<AboutUs>> aboutUs(@Body Map<String,String> params);



    //添加新闻      Content-Type:multipart/form-data
    @Headers("Content-Type:multipart/form-data")
    @POST("news/insert")
    Observable<HttpResult<Object>> insert(@Body Map<String,String> params);



    //新闻频道      Content-Type:application/x-www-form-urlencoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("news/listNewsChannel")
    Observable<HttpResult<NewsChannel>> listNewsChannel();



    //新闻上拉刷新列表      Content-Type:application/json
    @Headers("Content-Type:application/json")
    @POST("news/upListNews")
    Observable<HttpResult<UpListNews>> upListNews(@Body Map<String ,String > params);



    //新闻下拉加载列表      Content-Type:application/json
    @Headers("Content-Type:application/json")
    @POST("news/downListNews")
    Observable<HttpResult<DownListNews>> downListNews(@Body Map<String ,String> params);



    //新闻详情  Content-Type:application/x-www-form-urlencoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("news/info")
    Observable<HttpResult<Newsinfo>> newsinfo(@FieldMap Map<String,String> params);


    //新闻屏蔽  Content-Type:application/json
    @Headers("Content-Type:application/json")
    @POST("news/screen")
    Observable<HttpResult<Object>> screen(@Body Map<String,String> params);


    //相关新闻      Content-Type:application/x-www-form-urlencoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("news/relevant")
    Observable<HttpResult<List<Relevant>>> relevant(@FieldMap Map<String,String> params);



    //  热门搜索        Content-Type:application/x-www-form-urlencoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("search/hot")
    Observable<HttpResult<Search>> search(@Body Map<String,String> params);



    //搜索新闻      Content-Type:application/json
    @Headers("Content-Type:application/json")
    @POST("news/search")
    Observable<HttpResult<Newssearch>> newssearch(@Body Map<String,String> params);



    //搜索话题      Content-Type:application/json
    @Headers("Content-Type:application/json")
    @POST("topic/search")
    Observable<HttpResult<Searchtopic>> searchtopic(@Body Map<String ,String> params);



    //发布话题      Content-Type:multipart/form-data
    @Headers("Content-Type:multipart/form-data")
    @POST("topic/insertTopic")
    Observable<HttpResult<Object>> insertTopic(@Body Map<String ,String> params);



    //编辑话题详情        Content-Type:application/x-www-form-
    //TODO 实体类
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("topic/edit/info")
    Observable<HttpResult<EditInfo>> editinfo(@Body Map<String,String> params);



    //发布话题      Content-Type:multipart/form-data
    @Headers("Content-Type:multipart/form-data")
    @POST("topic/updateTopic")
    Observable<HttpResult<Object>> updateTopic(@Body Map<String ,String> params);



    //4.4刷新话题列表        Content-Type:application/json
    @Headers("Content-Type:application/json")
    @POST("topic/refreshTopic")
    Observable<HttpResult<RefreshTopic>> refreshTopic(@Body Map<String,String> params);



    //加载话题列表        Content-Type:application/json
    @Headers("Content-Type:application/json")
    @POST("topic/loadTopic")
    Observable<HttpResult<LoadTopic>> loadTopic(@Body Map<String,String> params);



    //话题详情      Content-Type:application/x-www-form-urlencoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("topic/info")
    Observable<HttpResult<DetailsTopic>> detailsTopic(@Body Map<String,String> params);



    //评论列表      Content-Type:application/json
    @Headers("Content-Type:application/json")
    @POST("comment/listComment")
    Observable<HttpResult<ListComment>> listDiscuss(@Body Map<String,String> params);



    //标签搜索      Content-Type:application/json
    @Headers("Content-Type:application/json")
    @POST("tags/search")
    Observable<HttpResult<Tags>> tags(@Body Map<String ,String > params);



    //热门标签      Content-Type:application/x-www-form-urlencoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("tags/hot")   //TODO 外层数组，
    Observable<HttpResult<ArrayList<data>>> hotTags(@Body Map<String,String> params);



}
