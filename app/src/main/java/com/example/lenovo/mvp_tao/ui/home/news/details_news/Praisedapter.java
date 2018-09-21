package com.example.lenovo.mvp_tao.ui.home.news.details_news;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.bean.Comment;
import com.example.lenovo.mvp_tao.bean.userCommentList;

import java.util.ArrayList;

public class Praisedapter extends RecyclerView.Adapter<Praisedapter.MyHolder>{
    private Context context;
    private ArrayList<userCommentList> list;

    public Praisedapter(Context context, ArrayList<userCommentList> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public Praisedapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.loading_news, null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Praisedapter.MyHolder holder, int position) {

        /**
         * private ImageView news_img_head;
         private TextView news_tv_username;
         private TextView news_tv_time;
         private RadioButton news_img_praise;
         */
        userCommentList userCommentList = list.get(position);
        Log.d("ObjectId", userCommentList.getObjectId());
        holder.news_tv_username.setText(userCommentList.getContent());
        holder.news_tv_time.setText(userCommentList.getCommentTime());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private ImageView news_img_head;
        private TextView news_tv_username;
        private TextView news_tv_time;
        private ImageView news_img_praise;
        public MyHolder(View itemView) {
            super(itemView);

            news_img_head = itemView.findViewById(R.id.news_img_head);
            news_tv_username = itemView.findViewById(R.id.news_tv_username);
            news_tv_time = itemView.findViewById(R.id.news_tv_time);
            news_img_praise = itemView.findViewById(R.id.news_img_praise);

        }
    }
}
