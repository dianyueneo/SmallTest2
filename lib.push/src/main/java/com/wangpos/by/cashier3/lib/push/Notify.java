package com.wangpos.by.cashier3.lib.push;

import java.io.Serializable;

/**
 * Created by Arrow on 2016/10/21.
 */

public class Notify implements Serializable {

    private Hint hint;
    private Biz biz;

    public class Hint {

        private String content;
        private String voice;

        public void setContent(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setVoice(String voice) {
            this.voice = voice;
        }

        public String getVoice() {
            return voice;
        }
    }

    public class Biz {

        private String title;
        private String paytime;
        private String createtime;
        private String payway;
        private Long money;
        private String orderno;
        private String transactionid;

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setPaytime(String paytime) {
            this.paytime = paytime;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getPaytime() {
            return paytime;
        }

        public void setPayway(String payway) {
            this.payway = payway;
        }

        public String getPayway() {
            return payway;
        }

        public void setMoney(Long money) {
            this.money = money;
        }

        public Long getMoney() {
            return money;
        }

        public void setOrderno(String orderno) {
            this.orderno = orderno;
        }

        public String getOrderno() {
            return orderno;
        }

        public void setTransactionid(String transactionid) {
            this.transactionid = transactionid;
        }

        public String getTransactionid() {
            return transactionid;
        }

    }

    public void setHint(Hint hint) {
        this.hint = hint;
    }

    public Hint getHint() {
        return hint;
    }

    public void setBiz(Biz biz) {
        this.biz = biz;
    }

    public Biz getBiz() {
        return biz;
    }

}
