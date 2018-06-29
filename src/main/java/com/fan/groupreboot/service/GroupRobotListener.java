package com.fan.groupreboot.service;

import me.xuxiaoxiao.chatapi.wechat.WeChatClient;

/**
 * Created by Administrator on 2018/6/29.
 */
public class GroupRobotListener extends WeChatClient.WeChatListener {

    private String qrCode;

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    @Override
    public void onQRCode(String s) {
        this.qrCode = s;
    }
}
