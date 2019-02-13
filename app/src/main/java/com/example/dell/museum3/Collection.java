package com.example.dell.museum3;

import org.litepal.crud.DataSupport;

/**
 * Created by dell on 2019/1/19.
 */

public class Collection extends DataSupport{

    private String branchName;

    private int branchImageId;

    private String nextBranchName;

    private int nextBranchImageId;

    private String exhibitContent;

    private String firstExhibitName;

    private int firstExhibitImageId;

    private String secondExhibitName;

    private int secondExhibitImageId;

    public Collection(String branchName, int branchImageId, String nextBranchName, int nextBranchImageId, String exhibitContent, String firstExhibitName, int firstExhibitImageId, String secondExhibitName, int secondExhibitImageId) {
        this.branchName = branchName;
        this.branchImageId = branchImageId;
        this.nextBranchName = nextBranchName;
        this.nextBranchImageId = nextBranchImageId;
        this.exhibitContent = exhibitContent;
        this.firstExhibitName = firstExhibitName;
        this.firstExhibitImageId = firstExhibitImageId;
        this.secondExhibitName = secondExhibitName;
        this.secondExhibitImageId = secondExhibitImageId;
    }

    public int getBranchImageId() {
        return branchImageId;
    }

    public void setBranchImageId(int branchImageId) {
        this.branchImageId = branchImageId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getExhibitContent() {
        return exhibitContent;
    }

    public void setExhibitContent(String exhibitContent) {
        this.exhibitContent = exhibitContent;
    }

    public int getFirstExhibitImageId() {
        return firstExhibitImageId;
    }

    public void setFirstExhibitImageId(int firstExhibitImageId) {
        this.firstExhibitImageId = firstExhibitImageId;
    }

    public String getFirstExhibitName() {
        return firstExhibitName;
    }

    public void setFirstExhibitName(String firstExhibitName) {
        this.firstExhibitName = firstExhibitName;
    }

    public int getNextBranchImageId() {
        return nextBranchImageId;
    }

    public void setNextBranchImageId(int nextBranchImageId) {
        this.nextBranchImageId = nextBranchImageId;
    }

    public String getNextBranchName() {
        return nextBranchName;
    }

    public void setNextBranchName(String nextBranchName) {
        this.nextBranchName = nextBranchName;
    }

    public int getSecondExhibitImageId() {
        return secondExhibitImageId;
    }

    public void setSecondExhibitImageId(int secondExhibitImageId) {
        this.secondExhibitImageId = secondExhibitImageId;
    }

    public String getSecondExhibitName() {
        return secondExhibitName;
    }

    public void setSecondExhibitName(String secondExhibitName) {
        this.secondExhibitName = secondExhibitName;
    }

}
