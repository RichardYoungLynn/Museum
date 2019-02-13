package com.example.dell.museum3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
//        Toolbar toolbar=(Toolbar)findViewById(R.id.change_password_toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().hide();
        final EditText accountEditText=(EditText)findViewById(R.id.change_password_account_edit);
        final EditText oldPasswordEditText=(EditText)findViewById(R.id.old_password_edit);
        final EditText newPasswordEditText=(EditText)findViewById(R.id.new_password_edit);
        Button confirmChangePasswordButton=(Button)findViewById(R.id.confirm_change_password_button);
        confirmChangePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldAccount=accountEditText.getText().toString();
                String newPassword=newPasswordEditText.getText().toString();
                String oldPassword=oldPasswordEditText.getText().toString();
                if (oldAccount.isEmpty()||oldPassword.isEmpty()){
                    Toast.makeText(ChangePasswordActivity.this,"账号或密码不完整", Toast.LENGTH_SHORT).show();
                }else if (newPassword.isEmpty()){
                    Toast.makeText(ChangePasswordActivity.this,"请输入新密码", Toast.LENGTH_SHORT).show();
                }else if (!newPassword.matches("^[a-zA-Z]\\w{5,17}$")){
                    Toast.makeText(ChangePasswordActivity.this,"新密码格式不正确", Toast.LENGTH_SHORT).show();
                }else{
                    List<User> users= DataSupport.where("account = ?",oldAccount).find(User.class);
                    boolean unsuccessful=true;
                    for (User u: users){
                        if (u.getPassword().equals(oldPassword)){
                            User user=new User();
                            user.setPassword(newPassword);
                            user.updateAll("account = ?",oldAccount);
                            Toast.makeText(ChangePasswordActivity.this,"成功修改密码", Toast.LENGTH_SHORT).show();
                            unsuccessful=false;
                            Intent intent=new Intent(ChangePasswordActivity.this,LoginActivity.class);
                            startActivity(intent);
                        }
                    }
                    if(unsuccessful){
                        Toast.makeText(ChangePasswordActivity.this,"原密码不正确",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        Button cancelChangePasswordButton=(Button)findViewById(R.id.cancel_change_password_button);
        cancelChangePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case android.R.id.home:
//                finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

}
