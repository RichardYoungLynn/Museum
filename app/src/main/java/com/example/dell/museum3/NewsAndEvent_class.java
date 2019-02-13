package com.example.dell.museum3;

import org.litepal.crud.DataSupport;

/**
 * Created by dell on 2019/1/21.
 */

public class NewsAndEvent_class extends DataSupport{

    private int tag;

    private String title;

    private int imageId;

    private String content;

    public NewsAndEvent_class(int tag,String title, int imageId, String content) {
        this.tag=tag;
        this.title = title;
        this.imageId = imageId;
        this.content = content;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
