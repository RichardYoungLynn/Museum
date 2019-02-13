package com.example.dell.museum3;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.stream.StreamStringLoader;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by dell on 2018/12/30.
 */

public class ExhibitAdapter extends RecyclerView.Adapter<ExhibitAdapter.ViewHolder>{

    private Context mContext;

    private List<Exhibit> mExhibitList;

    private String userAccount;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView1,cardView2,cardView3;
        ImageView firstExhibitImage,secondExhibitImage;
        TextView firstExhibitName,secondExhibitName,exhibitContent;

        public ViewHolder(View view){
            super(view);
            cardView1=(CardView)view.findViewById(R.id.cardview1);
            cardView2=(CardView)view.findViewById(R.id.cardview2);
            cardView3=(CardView)view.findViewById(R.id.cardview3);
            exhibitContent=(TextView)view.findViewById(R.id.exhibit_content_text);
            firstExhibitImage=(ImageView)view.findViewById(R.id.first_exhibit_image);
            firstExhibitName=(TextView)view.findViewById(R.id.first_exhibit_name);
            secondExhibitImage=(ImageView)view.findViewById(R.id.second_exhibit_image);
            secondExhibitName=(TextView)view.findViewById(R.id.second_exhibit_name);
        }
    }

    public ExhibitAdapter(List<Exhibit> exhibitList,String userAccount){
        mExhibitList=exhibitList;
        this.userAccount=userAccount;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.exhibit_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Exhibit exhibit=mExhibitList.get(position);
                Intent intent=new Intent(mContext,ExhibitActivity.class);
                intent.putExtra(NextCollectionActivity.NEXT_BRANCH_NAME,exhibit.getFirstExhibitName());
                intent.putExtra(NextCollectionActivity.NEXT_BRANCH_IMAGE_ID,exhibit.getFirstExhibitImageId());
                intent.putExtra(HomePageActivity.USER_ACCOUNT,userAccount);
                mContext.startActivity(intent);
            }
        });
        holder.cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Exhibit exhibit=mExhibitList.get(position);
                Intent intent=new Intent(mContext,ExhibitActivity.class);
                intent.putExtra(NextCollectionActivity.NEXT_BRANCH_NAME,exhibit.getSecondExhibitName());
                intent.putExtra(NextCollectionActivity.NEXT_BRANCH_IMAGE_ID,exhibit.getSecondExhibitImageId());
                intent.putExtra(HomePageActivity.USER_ACCOUNT,userAccount);
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Exhibit exhibit=mExhibitList.get(position);
        holder.exhibitContent.setText(exhibit.getExhibitContent());
        holder.firstExhibitName.setText(exhibit.getFirstExhibitName());
        holder.secondExhibitName.setText(exhibit.getSecondExhibitName());
        Glide.with(mContext).load(exhibit.getFirstExhibitImageId()).into(holder.firstExhibitImage);
        Glide.with(mContext).load(exhibit.getSecondExhibitImageId()).into(holder.secondExhibitImage);
    }

    @Override
    public int getItemCount(){
        return mExhibitList.size();
    }

}
