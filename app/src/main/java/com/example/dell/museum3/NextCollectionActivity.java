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

public class NextCollectionActivity extends AppCompatActivity {

    public static final String NEXT_BRANCH_NAME="next_branch_name";

    public static final String NEXT_BRANCH_IMAGE_ID="next_branch_image_id";

    private List<NextBranch> nextBranchList=new ArrayList<>();

    private NextBranchAdapter adapter;

    private String userAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_collection);
        Intent intent=getIntent();
        String branchName=intent.getStringExtra(CollectionActivity.BRANCH_NAME);
        userAccount=intent.getStringExtra(HomePageActivity.USER_ACCOUNT);
        List<Collection> collections= DataSupport.where("branchName = ?",branchName).find(Collection.class);
        for (Collection collection:collections){
            NextBranch nextBranch=new NextBranch(collection.getNextBranchName(),collection.getNextBranchImageId());
            nextBranchList.add(nextBranch);
        }
//        for (int i=0;i<nextBranchList.size()-1;i++){
//            for (int j=nextBranchList.size()-1;j>i;j--){
//                if (nextBranchList.get(j).equals(nextBranchList.get(i))){
//                    nextBranchList.remove(j);
//                }
//            }
//        }
        Toolbar toolbar=(Toolbar)findViewById(R.id.next_collection_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.next_branch_recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new NextBranchAdapter(nextBranchList,userAccount);
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
