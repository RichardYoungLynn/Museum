package com.example.dell.museum3;

import org.litepal.crud.DataSupport;

/**
 * Created by dell on 2018/12/31.
 */

public class Guidance_class extends DataSupport{
    private String guidanceContent;

    public Guidance_class(String guidanceContent) {
        this.guidanceContent=guidanceContent;
    }

    public String getGuidanceContent() {
        return guidanceContent;
    }
}
