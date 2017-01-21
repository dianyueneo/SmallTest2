package com.wangpos.by.cashier3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.by.autolayout.AutoLayoutActivity;

import net.wequick.small.Small;

public class MainActivity extends AutoLayoutActivity implements View.OnClickListener{

    Button btn;

    TextView tv;

    boolean isSetUP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv_1);
        btn = (Button)findViewById(R.id.gotoNext);
        btn.setOnClickListener(this);

        tv.setText("测试内容");

        setUp();
    }

    private void setUp(){
        Small.setUp(this, new Small.OnCompleteListener() {
            @Override
            public void onComplete() {
                isSetUP = true;
                System.out.println("setUp成功");
            }
        });
    }

    private void gotoNext(){
        System.out.println("gotoNext 开始调用");

        if(!isSetUP){
            Toast.makeText(this, "正在setUp", Toast.LENGTH_SHORT).show();
            return;
        }

        Small.openUri("main", MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.gotoNext:
                gotoNext();
                break;
            default:
                break;
        }
    }
}
