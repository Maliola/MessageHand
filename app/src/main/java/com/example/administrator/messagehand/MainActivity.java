package com.example.administrator.messagehand;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Administrator on 2016/12/28.
 */

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }
    public void jump1(View view){
        Intent intent=new Intent(MainActivity.this,TestActivity.class);
        startActivity(intent);
    }
    public void jump2(View view){
        Intent intent=new Intent(MainActivity.this,TestActivity1.class);
        startActivity(intent);
    }
    public void jump3(View view){
        Intent intent=new Intent(MainActivity.this,TestActivity2.class);
        startActivity(intent);
    }
}
