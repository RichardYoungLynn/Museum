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
 * Created by dell on 2019/1/23.
 */

public class VolunteerAdapter extends RecyclerView.Adapter<VolunteerAdapter.ViewHolder>{

    private Context mContext;

    private List<Volunteer_class> mVolunteerList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView volunteerContent;

        public ViewHolder(View view){
            super(view);
            cardView=(CardView)view;
            volunteerContent=(TextView)view.findViewById(R.id.volunteer_content);
        }
    }

    public VolunteerAdapter(List<Volunteer_class> volunteerList){
        mVolunteerList=volunteerList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.volunteer_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Volunteer_class volunteer=mVolunteerList.get(position);
        holder.volunteerContent.setText(volunteer.getVolunteerContent());
    }

    @Override
    public int getItemCount(){
        return mVolunteerList.size();
    }

}
