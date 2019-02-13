package com.example.dell.museum3;

/**
 * Created by dell on 2018/12/29.
 */

public class NextBranch {

    private String nextBranchName;

    private int nextBranchImageId;

    public NextBranch(String nextBranchName,int nextBranchImageId){
        this.nextBranchName=nextBranchName;
        this.nextBranchImageId=nextBranchImageId;
    }

    public String getNextBranchName() {
        return nextBranchName;
    }

    public int getNextBranchImageId() {
        return nextBranchImageId;
    }

}
