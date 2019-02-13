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

public class News extends Fragment{

    private RecyclerView newsRecyclerView;
    private List<NewsAndEvent> newsList=new ArrayList<>();

    public News(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.news_fragment,container,false);
        newsRecyclerView=(RecyclerView)view.findViewById(R.id.news_recycler_view);
        initAdapter();
        return view;
    }

    public void initAdapter(){
        List<NewsAndEvent_class> newsAndEvent_classes= DataSupport.findAll(NewsAndEvent_class.class);
        for (NewsAndEvent_class newsAndEvent_class: newsAndEvent_classes){
            if (newsAndEvent_class.getTag()==1){
                newsList.add(new NewsAndEvent(newsAndEvent_class.getTitle(),newsAndEvent_class.getImageId()));
            }
        }
        NewsAndEventAdapter adapter=new NewsAndEventAdapter(newsList);
        newsRecyclerView.setLayoutManager(new GridLayoutManager(newsRecyclerView.getContext(),1));
        newsRecyclerView.setAdapter(adapter);
    }

}
