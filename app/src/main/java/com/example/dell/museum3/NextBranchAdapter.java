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
 * Created by dell on 2018/12/29.
 */

public class NextBranchAdapter extends RecyclerView.Adapter<NextBranchAdapter.ViewHolder>{

    private Context mContext;

    private List<NextBranch> mNextBranchList;

    private String userAccount;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView nextBranchImage;
        TextView nextBranchName;

        public ViewHolder(View view){
            super(view);
            cardView=(CardView)view;
            nextBranchImage=(ImageView)view.findViewById(R.id.next_branch_image);
            nextBranchName=(TextView)view.findViewById(R.id.next_branch_name);
        }
    }

    public NextBranchAdapter(List<NextBranch> nextBranchList,String userAccount){
        this.mNextBranchList=nextBranchList;
        this.userAccount=userAccount;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.next_branch_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                NextBranch nextBranch=mNextBranchList.get(position);
                Intent intent=new Intent(mContext,ExhibitActivity.class);
                intent.putExtra(NextCollectionActivity.NEXT_BRANCH_NAME,nextBranch.getNextBranchName());
                intent.putExtra(NextCollectionActivity.NEXT_BRANCH_IMAGE_ID,nextBranch.getNextBranchImageId());
                intent.putExtra(HomePageActivity.USER_ACCOUNT,userAccount);
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        NextBranch nextBranch=mNextBranchList.get(position);
        holder.nextBranchName.setText(nextBranch.getNextBranchName());
        Glide.with(mContext).load(nextBranch.getNextBranchImageId()).into(holder.nextBranchImage);
    }

    @Override
    public int getItemCount(){
        return mNextBranchList.size();
    }

}
