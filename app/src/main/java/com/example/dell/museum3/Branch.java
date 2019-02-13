package com.example.dell.museum3;

/**
 * Created by dell on 2018/12/29.
 */

public class Branch {

    private String branchName;

    private int branchImageId;

    public Branch(String branchName,int branchImageId){
        this.branchName=branchName;
        this.branchImageId=branchImageId;
    }

    public String getBranchName() {
        return branchName;
    }

    public int getBranchImageId() {
        return branchImageId;
    }

}
