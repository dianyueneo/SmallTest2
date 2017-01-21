package com.wangpos.by.cashier3.lib.push;

import java.io.Serializable;

/**
 * Created by Arrow on 2016/11/11.
 */

public class NotifyInfo implements Serializable {

    private Notify notify;
    private Notice notice;
    private Ext ext;


    public Notify getNotify() {
        return notify;
    }

    public void setNotify(Notify notify) {
        this.notify = notify;
    }

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public Ext getExt() {
        return ext;
    }

    public void setExt(Ext ext) {
        this.ext = ext;
    }

    public class Ext {

        private long noticeId;
        private String msgType;
        private long now;

        public long getNow() {
            return now;
        }

        public void setNow(long now) {
            this.now = now;
        }

        public long getNoticeId() {
            return noticeId;
        }

        public void setNoticeId(long noticeId) {
            this.noticeId = noticeId;
        }

        public String getMsgType() {
            return msgType;
        }

        public void setMsgType(String msgType) {
            this.msgType = msgType;
        }
    }
}
