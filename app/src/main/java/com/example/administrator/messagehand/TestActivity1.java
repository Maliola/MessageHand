package com.example.administrator.messagehand;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.messagehand.bean.Person;

/**
 * Created by Administrator on 2016/11/29.
 */

public class TestActivity1 extends AppCompatActivity {
    private TextView hello;
    private final int State1=1;
    private final int State3=3;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what){
                case State1:
                    Person person= (Person) msg.obj;
                    Toast.makeText(TestActivity1.this,person.getName()+person.getSex(),Toast.LENGTH_SHORT).show();
                    break;
                case State3:
                    Toast.makeText(TestActivity1.this,""+State3,Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1);
        hello= (TextView) findViewById(R.id.hello);
        Message message=new Message();
        message.what=State1;
        message.obj=new Person("小红","女");
        mHandler.sendMessage(message);


        //postDelayed是延迟多少时间再post，postAtTime是在设定的目标时间再post
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(TestActivity1.this,"5秒了",Toast.LENGTH_SHORT).show();
            }
        }, 5000);
        mHandler.postAtTime(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(TestActivity1.this,"10秒了",Toast.LENGTH_SHORT).show();
            }
        }, SystemClock.uptimeMillis() +10000);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hello.setText("大家好！");
            }
        });
    }
}
