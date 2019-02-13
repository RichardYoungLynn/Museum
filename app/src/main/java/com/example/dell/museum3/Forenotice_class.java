package com.example.dell.museum3;

import org.litepal.crud.DataSupport;

/**
 * Created by dell on 2018/12/31.
 */

public class Forenotice_class extends DataSupport{

    private String forenoticeContent;

    public Forenotice_class(String forenoticeContent) {
        this.forenoticeContent = forenoticeContent;
    }

    public String getForenoticeContent() {
        return forenoticeContent;
    }
}
