package com.example.dell.museum3;

import android.os.ParcelUuid;

/**
 * Created by dell on 2018/12/30.
 */

public class Exhibit {

    private String exhibitContent;

    private String firstExhibitName;

    private int firstExhibitImageId;

    private String secondExhibitName;

    private int secondExhibitImageId;

    public Exhibit(String exhibitContent,String firstExhibitName,int firstExhibitImageId,String secondExhibitName,int secondExhibitImageId){
        this.exhibitContent=exhibitContent;
        this.firstExhibitName=firstExhibitName;
        this.firstExhibitImageId=firstExhibitImageId;
        this.secondExhibitName=secondExhibitName;
        this.secondExhibitImageId=secondExhibitImageId;
    }

    public String getExhibitContent() {
        return exhibitContent;
    }

    public String getFirstExhibitName() {
        return firstExhibitName;
    }

    public int getFirstExhibitImageId() {
        return firstExhibitImageId;
    }

    public String getSecondExhibitName() {
        return secondExhibitName;
    }

    public int getSecondExhibitImageId() {
        return secondExhibitImageId;
    }

}
