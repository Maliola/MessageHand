package com.example.administrator.messagehand;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.messagehand.bean.Person;

/**
 * Created by Administrator on 2016/11/29.
 */

public class TestActivity extends AppCompatActivity {
    private MsgThread msgThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        startThread();

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msgThread.sendMsg(123, new Person("二狗","男"));
            }
        });
    }

    /**
     * 启动线程
     */
    private void startThread(){
        msgThread = new MsgThread();
        msgThread.start();
    }
    public class MsgThread extends Thread{
        public Handler handler = null;

        @Override
        public void run() {
            Looper.prepare();
            handler = new Handler(Looper.myLooper()){
                @Override
                public void handleMessage(Message msg){
                    Person person= (Person) msg.obj;
                    Toast.makeText(TestActivity.this,"MsgThread"+msg.what+"--"+person.toString(),Toast.LENGTH_SHORT).show();
                    super.handleMessage(msg);
                }
            };
            Looper.loop();
        }

        public void sendMsg(int what, Object object){
            Message message = handler.obtainMessage();
            message.what = what;
            message.obj = object;
            handler.sendMessage(message);
        }
    }
}
