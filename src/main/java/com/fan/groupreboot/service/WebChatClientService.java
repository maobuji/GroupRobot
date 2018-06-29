package com.fan.groupreboot.service;

import me.xuxiaoxiao.chatapi.wechat.WeChatClient;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2018/6/27.
 */
@Service
public class WebChatClientService {

    WeChatClient client = null;

    GroupRobotListener listener = null;

    public WeChatClient getClient() {
        return client;
    }

    public void setClient(WeChatClient client) {
        this.client = client;
    }

    public String createClient() {
        if (client != null) {
            client.shutdown();
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        listener = new GroupRobotListener();
        client = new WeChatClient(listener);
        client.startup();
        for (int i = 0; i < 10; i++) {
            if (listener.getQrCode() != null) {
                return listener.getQrCode();
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

}
