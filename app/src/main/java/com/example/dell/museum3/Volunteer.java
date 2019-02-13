package com.example.dell.museum3;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2019/1/23.
 */

public class Volunteer extends android.support.v4.app.Fragment{

    private RecyclerView volunteerRecyclerView;

    private List<Volunteer_class> volunteer_classList=new ArrayList<>();

    public Volunteer(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.volunteer_fragment,container,false);
        volunteerRecyclerView=(RecyclerView)view.findViewById(R.id.volunteer_recycler_view);
        initAdapter();
        return view;
    }

    public void initAdapter(){
        List<Volunteer_class> volunteer_classes= DataSupport.findAll(Volunteer_class.class);
        for (Volunteer_class volunteer_class:volunteer_classes){
            volunteer_classList.add(volunteer_class);
        }
        VolunteerAdapter volunteerAdapter=new VolunteerAdapter(volunteer_classList);
        volunteerRecyclerView.setLayoutManager(new GridLayoutManager(volunteerRecyclerView.getContext(),1));
        volunteerRecyclerView.setAdapter(volunteerAdapter);
    }

}
