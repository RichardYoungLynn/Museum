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
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by dell on 2018/12/29.
 */

public class BranchAdapter extends RecyclerView.Adapter<BranchAdapter.ViewHolder>{

    private Context mContext;

    private List<Branch> mBranchList;

    private String userAccount;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView branchImage;
        TextView branchName;

        public ViewHolder(View view){
            super(view);
            cardView=(CardView)view;
            branchImage=(ImageView)view.findViewById(R.id.branch_image);
            branchName=(TextView)view.findViewById(R.id.branch_name);
        }
    }

    public BranchAdapter(List<Branch> branchList,String userAccount){
        mBranchList=branchList;
        this.userAccount=userAccount;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.branch_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Branch branch=mBranchList.get(position);
                Intent intent=new Intent(mContext,NextCollectionActivity.class);
                intent.putExtra(CollectionActivity.BRANCH_NAME,branch.getBranchName());
                intent.putExtra(HomePageActivity.USER_ACCOUNT,userAccount);
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Branch branch=mBranchList.get(position);
        holder.branchName.setText(branch.getBranchName());
        Glide.with(mContext).load(branch.getBranchImageId()).into(holder.branchImage);
    }

    @Override
    public int getItemCount(){
        return mBranchList.size();
    }

}
