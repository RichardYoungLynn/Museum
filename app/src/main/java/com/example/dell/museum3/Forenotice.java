package com.example.dell.museum3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/12/30.
 */

public class Forenotice extends Fragment{

    RecyclerView forenoticeRecyclerView;
    private List<Forenotice_class> forenoticeList=new ArrayList<>();

    public Forenotice(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.forenotice_fragment,container,false);
        forenoticeRecyclerView=(RecyclerView)view.findViewById(R.id.forenotice_recycler_view);
        initAdapter();
        return view;
    }

    public void initAdapter(){
        List<Forenotice_class> forenotice_classList= DataSupport.findAll(Forenotice_class.class);
        for (Forenotice_class forenotice_class:forenotice_classList){
            forenoticeList.add(forenotice_class);
        }
        ForenoticeAdapter adapter=new ForenoticeAdapter(forenoticeList);
        forenoticeRecyclerView.setLayoutManager(new GridLayoutManager(forenoticeRecyclerView.getContext(),1));
        forenoticeRecyclerView.setAdapter(adapter);
    }

}
