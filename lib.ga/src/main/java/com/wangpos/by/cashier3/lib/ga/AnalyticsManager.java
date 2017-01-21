package com.wangpos.by.cashier3.lib.ga;

import android.content.Context;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by Administrator on 2017/1/16.
 */

public class AnalyticsManager {

    private static AnalyticsManager instance;

    private AnalyticsManager() {

    }

    public static AnalyticsManager getInstance() {
        if (instance == null) {
            instance = new AnalyticsManager();
        }
        return instance;
    }

    public void addClickEventToGA(Context context, String action) {
        getDefaultTracker(context)
                .send(new HitBuilders.EventBuilder()
                        .setCategory("用户点击事件")
                        .setAction(action)
                        .build());
        System.out.println("用户点击事件：" + action);
    }

    private Tracker mTracker;

    synchronized private Tracker getDefaultTracker(Context context) {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(context.getApplicationContext());
            mTracker = analytics.newTracker(R.xml.app_tracker);
        }
        return mTracker;
    }

}
