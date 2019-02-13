package com.example.dell.museum3;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class ExhibitActivity extends AppCompatActivity {

    private List<NextBranch> nextBranchList=new ArrayList<>();

    private User mUser;

    private Collection collection;

    private ExhibitAdapter adapter;

    private List<Exhibit> exhibitList=new ArrayList<>();

    private Exhibit exhibit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibit);
        mUser=new User();
        Intent intent=getIntent();
        final String userAccount=intent.getStringExtra(HomePageActivity.USER_ACCOUNT);
        final String exhibitName=intent.getStringExtra(NextCollectionActivity.NEXT_BRANCH_NAME);
        final int exhibitImageId=intent.getIntExtra(NextCollectionActivity.NEXT_BRANCH_IMAGE_ID,0);
        List<Collection> collections= DataSupport.findAll(Collection.class);
        for (Collection collection:collections){
            if(collection.getNextBranchName().equals(exhibitName)){
                this.collection=collection;
                break;
            }
        }
        exhibit=new Exhibit(collection.getExhibitContent(),collection.getFirstExhibitName(),collection.getFirstExhibitImageId(),collection.getSecondExhibitName(),collection.getSecondExhibitImageId());
        exhibitList.add(exhibit);
        Toolbar toolbar=(Toolbar)findViewById(R.id.exhibit_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.exhibit_collapsing_toolbar);
        final ImageView exhibitImageView=(ImageView)findViewById(R.id.exhibit_image_view);
        collapsingToolbarLayout.setTitle(exhibitName);
        Glide.with(this).load(exhibitImageId).into(exhibitImageView);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.exhibit_recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new ExhibitAdapter(exhibitList,userAccount);
        recyclerView.setAdapter(adapter);
        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.exhibit_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<User> users= DataSupport.findAll(User.class);
                for (User user:users){
                    if (user.getAccount().equals(userAccount)){
                        mUser=user;
                        break;
                    }
                }
//                Intent intent=new Intent(ExhibitActivity.this,StoreActivity.class);
//                intent.putExtra(NextCollectionActivity.NEXT_BRANCH_NAME,exhibitName);
                nextBranchList=mUser.getNextBranchList();
//                NextBranch nextBranch=new NextBranch(exhibitName,exhibitImageId);
//                nextBranchList.add(nextBranch);
                nextBranchList.add(0,new NextBranch(exhibitName,exhibitImageId));
                mUser.setNextBranchList(nextBranchList);
                mUser.updateAll("account = ?",userAccount);
                Toast.makeText(ExhibitActivity.this,"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });
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
