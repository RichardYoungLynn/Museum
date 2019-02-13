package com.example.dell.museum3;

import android.support.v7.widget.CardView;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by dell on 2019/1/19.
 */

public class User extends DataSupport{

    private String name;

    private String account;

    private String password;

    private String mail;

    private String call;

    private int profilePhotoImageId;

    public List<NextBranch> nextBranchList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public int getProfilePhotoImageId() {
        return profilePhotoImageId;
    }

    public void setProfilePhotoImageId(int profilePhotoImageId) {
        this.profilePhotoImageId = profilePhotoImageId;
    }

    public List<NextBranch> getNextBranchList() {
        return nextBranchList;
    }

    public void setNextBranchList(List<NextBranch> nextBranchList) {
        this.nextBranchList = nextBranchList;
    }

}

