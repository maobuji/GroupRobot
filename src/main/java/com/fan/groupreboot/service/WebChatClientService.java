package com.fan.groupreboot.service;

import com.fan.groupreboot.vo.UserClientVO;
import me.xuxiaoxiao.chatapi.wechat.WeChatClient;
import me.xuxiaoxiao.chatapi.wechat.entity.contact.WXUser;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2018/6/27.
 */
@Service
public class WebChatClientService {
    public static Map<String, WeChatClient> clients = new HashMap<String, WeChatClient>();


    public static List<UserClientVO> listUserClient() {
        List<UserClientVO> ls = new ArrayList<UserClientVO>();
        Iterator<WeChatClient> it = clients.values().iterator();
        while (it.hasNext()) {
            WeChatClient client = it.next();
            UserClientVO vo = new UserClientVO();
            ls.add(vo);
            vo.setName(client.userMe().name);
//            client.userMe().gender;
//            client.userMe().province
//            client.userMe().signature
//            client.userMe().avatarUrl
//            client.userMe().remark
//            client.userMe().remarkPY
//            client.userMe().remarkQP
//            client.userMe().verifyFlag
        }
        return ls;
    }
}
