package com.example.dell.museum3;

import android.app.*;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.media.Image;
import android.support.v4.app.*;
import android.support.v7.app.*;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InformationActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TITLE="title";

    public static final String IMAGE_ID="image_id";

    ImageView newsImage;

    ImageView forenoticeImage;

    ImageView eventImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Toolbar toolbar=(Toolbar)findViewById(R.id.information_toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        newsImage=(ImageView)findViewById(R.id.news_image);
        forenoticeImage=(ImageView)findViewById(R.id.forenotice_image);
        eventImage=(ImageView)findViewById(R.id.event_image);
        newsImage.setOnClickListener(this);
        forenoticeImage.setOnClickListener(this);
        eventImage.setOnClickListener(this);
        replaceFragment(new News());
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.news_image:
                replaceFragment(new News());
                break;
            case R.id.forenotice_image:
                replaceFragment(new Forenotice());
                break;
            case R.id.event_image:
                replaceFragment(new Event());
                break;
            default:
                break;
        }
    }

    private void replaceFragment(android.support.v4.app.Fragment fragment){
        android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.information_frame_layout,fragment);
        transaction.commit();
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
