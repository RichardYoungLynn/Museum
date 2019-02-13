package com.example.dell.museum3;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/12/31.
 */

public class Guidance extends android.support.v4.app.Fragment{

    private RecyclerView guidanceRecyclerView;

    private List<Guidance_class> guidanceList=new ArrayList<>();

    public Guidance(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.guidance_fragment,container,false);
        guidanceRecyclerView=(RecyclerView)view.findViewById(R.id.guidance_recycler_view);
        initAdapter();
        return view;
    }

    public void initAdapter(){
        List<Guidance_class> guidance_classes= DataSupport.findAll(Guidance_class.class);
        for (Guidance_class guidance_class:guidance_classes){
            guidanceList.add(guidance_class);
        }
        GuidanceAdapter guidanceAdapter=new GuidanceAdapter(guidanceList);
        guidanceRecyclerView.setLayoutManager(new GridLayoutManager(guidanceRecyclerView.getContext(),1));
        guidanceRecyclerView.setAdapter(guidanceAdapter);
    }

}
