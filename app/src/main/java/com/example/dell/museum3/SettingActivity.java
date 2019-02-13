package com.example.dell.museum3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Intent intent=getIntent();
        final String userAccount=intent.getStringExtra(HomePageActivity.USER_ACCOUNT);
        final EditText userNameEditText=(EditText)findViewById(R.id.setting_user_name);
        final EditText mailEditText=(EditText)findViewById(R.id.setting_mail);
        final EditText callEditText=(EditText)findViewById(R.id.setting_call);
        Button confirmSettingButton=(Button)findViewById(R.id.confirm_setting_button);
        confirmSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user=new User();
                String userName=userNameEditText.getText().toString();
                String mail=mailEditText.getText().toString();
                String call=callEditText.getText().toString();
                user.setName(userName);
                user.setMail(mail);
                user.setCall(call);
                user.updateAll("account = ?",userAccount);
            }
        });
        Button cancelSettingButton=(Button)findViewById(R.id.cancel_setting_button);
        cancelSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
