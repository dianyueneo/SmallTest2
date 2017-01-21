package com.wangpos.by.cashier3.lib.push;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.alibaba.fastjson.JSON;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import cn.jpush.android.api.JPushInterface;


/**
 * Created by Arrow on 2016/10/12.
 */

public class JPushReceiver extends BroadcastReceiver {

    private final static String PARAM_TRANSACTION_NO = "PARAM_TRANSACTION_NO";

    private MediaPlayer mediaPlayer;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Log.d("TAG", "[MyReceiver] onReceive - " + intent.getAction() + ", extras: " + printBundle(bundle));
        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {

        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            processCustomMessage(context, bundle);
        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {

        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {

        } else {

        }
    }

    private void processCustomMessage(Context context, Bundle bundle) {
        NotifyInfo notifyInfo = JSON.parseObject(bundle.getString(JPushInterface.EXTRA_MESSAGE), NotifyInfo.class);
        if (notifyInfo != null && notifyInfo.getExt().getMsgType().equals("notify")) {
            String content = notifyInfo.getNotify().getHint().getContent();
            String voice = notifyInfo.getNotify().getHint().getVoice();
            String transactionid = notifyInfo.getNotify().getBiz().getTransactionid();
            String payway = notifyInfo.getNotify().getBiz().getPayway();
            String paytime = notifyInfo.getNotify().getBiz().getPaytime();
            String createtime = notifyInfo.getNotify().getBiz().getCreatetime();
            Long money = notifyInfo.getNotify().getBiz().getMoney();

            //通知栏推送
            sendNotification(context, content, voice, transactionid);
        }
    }

    private void sendNotification(Context context, String content, String voice, String transID) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(PARAM_TRANSACTION_NO, transID);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //创建 Notification.Builder 对象
        NotificationManager notifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.applabel)
                .setContentTitle(content)
                .setContentText(voice)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        notifyManager.notify((int) System.currentTimeMillis(), builder.build());
    }


    private static String printBundle(Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        for (String key : bundle.keySet()) {
            if (key.equals(JPushInterface.EXTRA_NOTIFICATION_ID)) {
                sb.append("\nkey:" + key + ", value:" + bundle.getInt(key));
            } else if (key.equals(JPushInterface.EXTRA_CONNECTION_CHANGE)) {
                sb.append("\nkey:" + key + ", value:" + bundle.getBoolean(key));
            } else if (key.equals(JPushInterface.EXTRA_EXTRA)) {
                if (bundle.getString(JPushInterface.EXTRA_EXTRA).isEmpty()) {
                    Log.i("TAG", "This message has no Extra data");
                    continue;
                }
                try {
                    JSONObject json = new JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA));
                    Iterator<String> it = json.keys();
                    while (it.hasNext()) {
                        String myKey = it.next().toString();
                        sb.append("\nkey:" + key + ", value: [" +
                                myKey + " - " + json.optString(myKey) + "]");
                    }
                } catch (JSONException e) {
                    Log.e("TAG", "Get message extra JSON error!");
                }
            } else {
                sb.append("\nkey:" + key + ", value:" + bundle.getString(key));
            }
        }
        return sb.toString();
    }
}
