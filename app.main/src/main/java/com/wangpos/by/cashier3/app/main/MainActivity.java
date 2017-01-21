package com.wangpos.by.cashier3.app.main;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.by.autolayout.AutoLayoutActivity;
import com.wangpos.by.cashier3.lib.ga.AnalyticsManager;

import net.wequick.small.Small;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AutoLayoutActivity implements View.OnClickListener {


    @BindView(R.id.kill)
    Button kill;

    @BindView(R.id.update)
    Button update;

    @BindView(R.id.show)
    TextView show;

    @BindView(R.id.getjpushid)
    Button getjpushid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        JSONObject jsonObject = JSON.parseObject("{'aa':'bbb'}");
        show.setText("main插件" + jsonObject.toString());

        JPushInterface.setDebugMode(true);
        JPushInterface.init(this.getApplication());

    }


    @OnClick({R.id.kill, R.id.update, R.id.getjpushid})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.kill:
                Small.openUri("mine", MainActivity.this);
                AnalyticsManager.getInstance().addClickEventToGA(MainActivity.this, "跳转到mine");
                break;
            case R.id.getjpushid:
                getJpushId();
                break;
            default:
                break;
        }
    }

    private void getJpushId(){
        String registrationID = JPushInterface.getRegistrationID(this.getApplication());
        if (TextUtils.isEmpty(registrationID)) {
            System.out.println("---获取极光ID失败---");
        } else {
            System.out.println("---获取极光ID成功：" + registrationID);
        }
    }

}
