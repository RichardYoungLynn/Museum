package com.example.dell.museum3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by dell on 2018/12/30.
 */

public class NewsAndEventAdapter extends RecyclerView.Adapter<NewsAndEventAdapter.ViewHolder>{

    private Context mContext;

    private List<NewsAndEvent> mNewsAndEventList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView image;
        TextView title;

        public ViewHolder(View view){
            super(view);
            cardView=(CardView)view;
            image=(ImageView)view.findViewById(R.id.news_and_event_image);
            title=(TextView)view.findViewById(R.id.news_and_event_title);
        }
    }

    public NewsAndEventAdapter(List<NewsAndEvent> newsAndEventList){
        mNewsAndEventList=newsAndEventList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.news_and_event_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                NewsAndEvent newsAndEvent=mNewsAndEventList.get(position);
                Intent intent=new Intent(mContext,NewsAndEventActivity.class);
                intent.putExtra(InformationActivity.TITLE,newsAndEvent.getTitle());
                intent.putExtra(InformationActivity.IMAGE_ID,newsAndEvent.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        NewsAndEvent newsAndEvent=mNewsAndEventList.get(position);
        holder.title.setText(newsAndEvent.getTitle());
        Glide.with(mContext).load(newsAndEvent.getImageId()).into(holder.image);
    }

    @Override
    public int getItemCount(){
        return mNewsAndEventList.size();
    }

}
