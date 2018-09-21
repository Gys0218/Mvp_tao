package com.example.lenovo.mvp_tao.ui.home.news.list_news;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.mvp_tao.R;
import com.example.lenovo.mvp_tao.bean.newListt;

import java.util.ArrayList;

public class NewsMyAdapterRv extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private ArrayList<newListt> list;
    private static final int TYPE_TITLE = 0;
    private static final int TYPE_RIGHT_IMG = 1;
    private static final int TYPE_BIG_IMG = 2;
    private static final int TYPE_THREE_IMG = 3;
    public NewsMyAdapterRv(FragmentActivity newsReuseFragment, ArrayList<newListt> list) {
        this.context=newsReuseFragment;
        this.list=list;
    }

    public void setList(ArrayList<newListt> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==0){
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout2, null);
            return new ViewHolder(inflate);
        }else if (viewType==1){
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout3 , null);
            return new ViewHolder1(inflate);
        }else if (viewType==2){
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout5, null);
            return new ViewHolder2(inflate);
        }else if (viewType==3){
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout4, null);
            return new ViewHolder3(inflate);
        }
        return null;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof ViewHolder){
            ((ViewHolder) holder).textView6.setText(list.get(position).getTitle());
                 ((ViewHolder) holder).textView11.setText(list.get(position).getPublishTime());
//                  ((ViewHolder) holder).textView7.setText(list.get(position).getPageviews());
             ((ViewHolder) holder).textView10.setText(list.get(position).getLayoutType());


        }else if (holder instanceof  ViewHolder1){
            ((ViewHolder1) holder).textView5.setText(list.get(position).getTitle());
             ((ViewHolder1) holder).textView13.setText(list.get(position).getLayoutType());
              ((ViewHolder1) holder).textView14.setText(list.get(position).getOrigin());
              ((ViewHolder1) holder).textView15.setText(list.get(position).getPublishTime());
            Glide.with(context).load(list.get(position).getImageListThumb().get(0)).into(((ViewHolder1) holder).imageView6);
//             Glide.with(context).load(list.get(position).getImageListThumb().get(position)).into(((ViewHolder1) holder).imageView6);


        }else if (holder instanceof ViewHolder2){
            ((ViewHolder2) holder).textView20.setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getImageListThumb().get(0)).into(((ViewHolder2) holder).imageView13);


        }else if (holder instanceof ViewHolder3){
            ((ViewHolder3) holder).textView16.setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getImageListThumb().get(0)).into(((ViewHolder3) holder).imageView9);
            Glide.with(context).load(list.get(position).getImageListThumb().get(1)).into(((ViewHolder3) holder).imageView10);
            Glide.with(context).load(list.get(position).getImageListThumb().get(2)).into(((ViewHolder3) holder).imageView11);

        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (onClickListener != null){
                    onClickListener.Click(list.get(position).getNewsId());
                }

            }
        });



    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView6;
        private TextView textView11;
        private TextView textView10;
        private TextView textView7;
        private  ImageView imageView16;

        public ViewHolder(View itemView) {
            super(itemView);
            textView6=itemView.findViewById(R.id.textView6);
            textView11=itemView.findViewById(R.id.textView11);
            textView10=itemView.findViewById(R.id.textView10);
            textView7=itemView.findViewById(R.id.textView7);
            imageView16=itemView.findViewById(R.id.imageView16);
        }
    }
    static class ViewHolder1 extends RecyclerView.ViewHolder{
        private TextView textView5;
        private TextView textView13;
        private TextView textView14;
        private TextView textView15;
        private ImageView imageView14;
        private ImageView imageView6;
        public ViewHolder1(View itemView) {
            super(itemView);
            textView5=itemView.findViewById(R.id.textView5);
            textView13=itemView.findViewById(R.id.news_tv_username);
            textView14=itemView.findViewById(R.id.textView14);
            textView15=itemView.findViewById(R.id.textView15);
            imageView6=itemView.findViewById(R.id.imageView6);
            imageView14=itemView.findViewById(R.id.imageView14);
        }

    }
    static class ViewHolder2 extends RecyclerView.ViewHolder{
        private TextView textView20;
        private ImageView imageView13;
        private  ImageView imageView18;
        public ViewHolder2(View itemView) {
            super(itemView);
            textView20=itemView.findViewById(R.id.textView20);
            imageView13=itemView.findViewById(R.id.imageView13);
            imageView18=itemView.findViewById(R.id.imageView18);
        }
    }
    static class ViewHolder3 extends RecyclerView.ViewHolder{
        private TextView textView16;
        private ImageView imageView9;
        private ImageView imageView10;
        private ImageView imageView11;
        private ImageView imageView12;
        public ViewHolder3(View itemView) {
            super(itemView);
            textView16=itemView.findViewById(R.id.news_tv_time);
            imageView9=itemView.findViewById(R.id.imageView9);
            imageView10=itemView.findViewById(R.id.imageView10);
            imageView11=itemView.findViewById(R.id.imageView11);
            imageView12=itemView.findViewById(R.id.imageView12);
        }
    }
    @Override
    public int getItemViewType(int position) {
        newListt newListt = list.get(position);

        if (newListt.getLayoutType().equals("0")) {
            return TYPE_TITLE;
        }
        if (newListt.getLayoutType().equals("1")) {
            return TYPE_RIGHT_IMG;
        }
        if (newListt.getLayoutType().equals("2")) {
            return TYPE_BIG_IMG;
        }
        if (newListt.getLayoutType().equals("3")) {
            return TYPE_THREE_IMG;
        }

        return TYPE_TITLE;

    }

    public OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void Click(String newsId);
    }

}

