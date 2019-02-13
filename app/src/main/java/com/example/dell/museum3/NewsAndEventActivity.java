package com.example.dell.museum3;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class NewsAndEventActivity extends AppCompatActivity {

    private List<NewsAndEvent_class> newsAndEvent_classList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_and_event);
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.news_and_event_collapsing_toolbar);
        ImageView newsAndEventImageView=(ImageView)findViewById(R.id.news_and_event_image_view);
        TextView newsAndEventContentTextView=(TextView)findViewById(R.id.news_and_event_content_text);
        Intent intent=getIntent();
        String newsAndEventTitle=intent.getStringExtra(InformationActivity.TITLE);
        int newsAndEventImageId=intent.getIntExtra(InformationActivity.IMAGE_ID,0);
        collapsingToolbarLayout.setTitle(newsAndEventTitle);
        Glide.with(this).load(newsAndEventImageId).into(newsAndEventImageView);
        newsAndEvent_classList=DataSupport.findAll(NewsAndEvent_class.class);
        for (NewsAndEvent_class newsAndEvent_class:newsAndEvent_classList){
            if (newsAndEvent_class.getTitle().equals(newsAndEventTitle)){
                newsAndEventContentTextView.setText(newsAndEvent_class.getContent());
            }
        }
        Toolbar toolbar=(Toolbar)findViewById(R.id.news_and_event_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
