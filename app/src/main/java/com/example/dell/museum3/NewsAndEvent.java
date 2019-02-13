package com.example.dell.museum3;

import org.litepal.crud.DataSupport;

/**
 * Created by dell on 2018/12/30.
 */

public class NewsAndEvent{

    private String title;

    private int imageId;

    public NewsAndEvent(String title,int imageId){
        this.title=title;
        this.imageId=imageId;
    }

    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return imageId;
    }

}
