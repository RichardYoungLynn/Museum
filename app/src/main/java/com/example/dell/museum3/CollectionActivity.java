package com.example.dell.museum3;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CollectionActivity extends AppCompatActivity {

    private String[] strings={"青铜器","陶瓷器","中国书画","金银玉石器","漆木牙角器","文房用具","徽州雕刻","潘玉良作品"};

    private static final String TAG = "CollectionActivity";

    public static final String BRANCH_NAME="branch_name";

    private List<Branch> branchList=new ArrayList<>();

    private BranchAdapter adapter;

    private String userAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        Intent intent=getIntent();
        String userAccount=intent.getStringExtra(HomePageActivity.USER_ACCOUNT);
        Toolbar toolbar=(Toolbar)findViewById(R.id.collection_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        for (int i=0;i<strings.length;i++){
            List<Collection> collections=DataSupport.where("branchName = ?",strings[i]).find(Collection.class);
            for (Collection collection:collections){
                branchList.add(new Branch(collection.getBranchName(),collection.getBranchImageId()));
                break;
            }
        }
//        List<Collection> collections= DataSupport.findAll(Collection.class);
//        branchList.add(new Branch(collections.get(0).getBranchName(),collections.get(0).getBranchImageId()));
//        for(Collection collection: collections){
//            Branch branch=new Branch(collection.getBranchName(),collection.getBranchImageId());
//            for (int i=0;i<branchList.size();i++){
//                if (!branchList.get(i).equals(branch)){
//                    branchList.add(branch);
//                }
//            }
//        }
        Log.d(TAG, branchList.size()+"123123");
//        for (int i=0;i<branchList.size()-1;i++){
//            for (int j=branchList.size()-1;j>i;j--){
//                if (branchList.get(j).equals(branchList.get(i))){
//                    branchList.remove(j);
//                }
//            }
//        }
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.branch_recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new BranchAdapter(branchList,userAccount);
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
