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

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by dell on 2018/12/31.
 */

public class ForenoticeAdapter extends RecyclerView.Adapter<ForenoticeAdapter.ViewHolder>{

    private Context mContext;

    private List<Forenotice_class> mForenoticeList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView forenoticeContent;

        public ViewHolder(View view){
            super(view);
            cardView=(CardView)view;
            forenoticeContent=(TextView)view.findViewById(R.id.forenotice_content);
        }
    }

    public ForenoticeAdapter(List<Forenotice_class> forenoticeList){
        mForenoticeList=forenoticeList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.forenotice_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Forenotice_class forenotice=mForenoticeList.get(position);
        holder.forenoticeContent.setText(forenotice.getForenoticeContent());
    }

    @Override
    public int getItemCount(){
        return mForenoticeList.size();
    }

}
