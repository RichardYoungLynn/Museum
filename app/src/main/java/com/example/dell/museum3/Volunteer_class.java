package com.example.dell.museum3;

import org.litepal.crud.DataSupport;

/**
 * Created by dell on 2019/1/23.
 */

public class Volunteer_class extends DataSupport {
    private String volunteerContent;

    public Volunteer_class(String volunteerContent) {
        this.volunteerContent=volunteerContent;
    }

    public String getVolunteerContent() {
        return volunteerContent;
    }
}
