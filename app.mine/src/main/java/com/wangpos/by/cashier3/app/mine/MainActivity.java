package com.wangpos.by.cashier3.app.mine;

import android.os.Bundle;
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

public class MainActivity extends AutoLayoutActivity implements View.OnClickListener {

    @BindView(R.id.tv_show)
    TextView tv_show;

    @BindView(R.id.btn_cs)
    Button btn_cs;

    @BindView(R.id.btn_showll)
    Button btn_showll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        int versionCode = Small.getBundle("com.wangpos.by.cashier3.app.mine").getVersionCode();
        JSONObject jsonObject = JSON.parseObject("{'aa':'bbb'}");
        tv_show.setText("mine测试内容----versionCode:" + versionCode + " Json:" + jsonObject.toString());

        AnalyticsManager.getInstance().addClickEventToGA(MainActivity.this, "mine测试内容");
    }


    @OnClick({R.id.btn_cs, R.id.btn_showll})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cs:
                AnalyticsManager.getInstance().addClickEventToGA(MainActivity.this, "点击测试内容》》");
                break;
        }
    }

}
