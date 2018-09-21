package com.example.lenovo.mvp_tao.ui.home.news.details_news;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.bean.Relevant;

import java.util.ArrayList;

public class XiangGuanAapter extends RecyclerView.Adapter<XiangGuanAapter.MyHolder>{
    private  Context context;
    private ArrayList<Relevant> list;
    public XiangGuanAapter(Context context, ArrayList<Relevant> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public XiangGuanAapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout3, null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull XiangGuanAapter.MyHolder holder, int position) {
        Relevant relevant = list.get(position);
        holder.textView5.setText(relevant.getTitle());
        Glide.with(context).load(relevant.getImageListThumb().get(0)).into(holder.imageView6);
        holder.textView13.setText(relevant.getOrigin()+"");
        holder.textView14.setText(relevant.getPageviews()+"");
        holder.textView15.setText(relevant.getPublishTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView textView5;
        private ImageView imageView6;
        private TextView textView13;
        private TextView textView14;
        private TextView textView15;
        private ImageView imageView14;

        public MyHolder(View itemView) {
            super(itemView);
            textView5 = itemView.findViewById(R.id.textView5);
            imageView6 = itemView.findViewById(R.id.imageView6);
            textView13 = itemView.findViewById(R.id.news_tv_username);
            textView14 = itemView.findViewById(R.id.textView14);
            textView15 = itemView.findViewById(R.id.textView15);
            imageView14 = itemView.findViewById(R.id.imageView14);
        }
    }
}
