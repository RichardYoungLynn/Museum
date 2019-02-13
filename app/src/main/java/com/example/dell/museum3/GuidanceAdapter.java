package com.example.dell.museum3;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dell on 2018/12/31.
 */

public class GuidanceAdapter extends RecyclerView.Adapter<GuidanceAdapter.ViewHolder>{

    private Context mContext;

    private List<Guidance_class> mGuidanceList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView guidanceContent;

        public ViewHolder(View view){
            super(view);
            cardView=(CardView)view;
            guidanceContent=(TextView)view.findViewById(R.id.guidance_content);
        }
    }

    public GuidanceAdapter(List<Guidance_class> guidanceList){
        mGuidanceList=guidanceList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.guidance_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Guidance_class guidance=mGuidanceList.get(position);
        holder.guidanceContent.setText(guidance.getGuidanceContent());
    }

    @Override
    public int getItemCount(){
        return mGuidanceList.size();
    }

}
