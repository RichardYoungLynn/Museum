package com.example.dell.museum3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.litepal.crud.DataSupport;

import java.nio.BufferUnderflowException;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {

    public static final String USER_ACCOUNT="user_account";

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Intent intent=getIntent();
        final String userAccount=intent.getStringExtra(HomePageActivity.USER_ACCOUNT);
        Toolbar toolbar=(Toolbar)findViewById(R.id.home_page_toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.home);
        }
        List<User> userList= DataSupport.findAll(User.class);
        User user=new User();
        for (User user1:userList){
            if (user1.getAccount().equals(userAccount)){
                user=user1;
            }
        }
        TextView mailTextView=(TextView)findViewById(R.id.mail);
        TextView userNameTextView=(TextView)findViewById(R.id.username);
        TextView callTextView=(TextView)findViewById(R.id.call);
//        user.setName(mailTextView.getText().toString());
//        user.setMail(userNameTextView.getText().toString());
//        user.setCall(callTextView.getText().toString());
//        user.save();
        Button introductionButton=(Button) findViewById(R.id.introduction_button);
        introductionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePageActivity.this,IntroductionActivity.class);
                startActivity(intent);
            }
        });
        Button informationButton=(Button)findViewById(R.id.information_button);
        informationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePageActivity.this,InformationActivity.class);
                startActivity(intent);
            }
        });
        Button collectionButton=(Button)findViewById(R.id.collection_button);
        collectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePageActivity.this,ServiceActivity.class);
                startActivity(intent);
            }
        });
        Button serviceButton=(Button)findViewById(R.id.service_button);
        serviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePageActivity.this,CollectionActivity.class);
                intent.putExtra(HomePageActivity.USER_ACCOUNT,userAccount);
                startActivity(intent);
            }
        });
//        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.home_page_fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(HomePageActivity.this,"...",Toast.LENGTH_SHORT).show();
//            }
//        });
        NavigationView navView=(NavigationView)findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_store:
                        Intent intent1=new Intent(HomePageActivity.this,StoreActivity.class);
                        intent1.putExtra(HomePageActivity.USER_ACCOUNT,userAccount);
                        startActivity(intent1);
                        break;
                    case R.id.nav_setting:
                        Intent intent2=new Intent(HomePageActivity.this,SettingActivity.class);
                        intent2.putExtra(HomePageActivity.USER_ACCOUNT,userAccount);
                        startActivity(intent2);
                        break;
                    case R.id.nav_location:
                        Intent intent3=new Intent(HomePageActivity.this,LocationActivity.class);
                        intent3.putExtra(HomePageActivity.USER_ACCOUNT,userAccount);
                        startActivity(intent3);
                    default:
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:;
        }
        return true;
    }

}
