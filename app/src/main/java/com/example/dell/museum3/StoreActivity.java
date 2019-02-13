package com.example.dell.museum3;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class StoreActivity extends AppCompatActivity {

    private List<NextBranch> nextBranchList=new ArrayList<>();

    private NextBranchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
//        Intent intent=getIntent();
//        String nextBranchName=intent.getStringExtra(NextCollectionActivity.NEXT_BRANCH_NAME);
//        List<Collection> collections= DataSupport.where("nextBranchName = ?",nextBranchName).find(Collection.class);
//        for (Collection collection:collections){
//            NextBranch nextBranch=new NextBranch(collection.getNextBranchName(),collection.getNextBranchImageId());
//            nextBranchList.add(nextBranch);
//        }
        User mUser=new User();
        Intent intent=getIntent();
        String userAccount=intent.getStringExtra(HomePageActivity.USER_ACCOUNT);
        List<User> users= DataSupport.findAll(User.class);
        for (User user:users){
            if (user.getAccount().equals(userAccount)){
                mUser=user;
                break;
            }
        }
        Toolbar toolbar=(Toolbar)findViewById(R.id.store_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.store_recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new NextBranchAdapter(mUser.getNextBranchList(),mUser.getAccount());
        recyclerView.setAdapter(adapter);
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
