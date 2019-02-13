package com.example.dell.museum3;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
//        Toolbar toolbar=(Toolbar)findViewById(R.id.register_toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().hide();
        final EditText registerAccountEditText=(EditText)findViewById(R.id.register_account_edit);
        final EditText registerPasswordEditText=(EditText)findViewById(R.id.register_password_edit);
        final EditText confirmPasswordEditText=(EditText)findViewById(R.id.confirm_password_edit);
        Button confirmRegisterButton=(Button)findViewById(R.id.confirm_register_button);
        confirmRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String registerAccount=registerAccountEditText.getText().toString();
                String registerPassword=registerPasswordEditText.getText().toString();
                String confirmPassword=confirmPasswordEditText.getText().toString();
                if (registerAccount.isEmpty()||registerPassword.isEmpty()){
                    Toast.makeText(RegisterActivity.this,"账号或密码不完整",Toast.LENGTH_SHORT).show();
                }else if (!registerAccount.matches("^[a-zA-Z0-9_]{4,15}$")||!registerPassword.matches("^[a-zA-Z]\\w{5,17}$")){
                    Toast.makeText(RegisterActivity.this,"账号或密码格式不正确",Toast.LENGTH_SHORT).show();
                }else if(confirmPassword.isEmpty()){
                    Toast.makeText(RegisterActivity.this,"请再次输入密码",Toast.LENGTH_SHORT).show();
                }else if (!registerPassword.equals(confirmPassword)){
                    Toast.makeText(RegisterActivity.this,"再次输入的密码不正确",Toast.LENGTH_SHORT).show();
                }else{
                    User user=new User();
                    user.setAccount(registerAccount);
                    user.setPassword(registerPassword);
                    user.save();
                    Toast.makeText(RegisterActivity.this,"注册成功", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        Button cancelRegisterButton=(Button)findViewById(R.id.cancel_register_button);
        cancelRegisterButton.setOnClickListener(new View.OnClickListener() {
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
