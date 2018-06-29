package com.fan.groupreboot.web;

import com.fan.groupreboot.vo.GroupVO;
import com.fan.groupreboot.vo.UserClientVO;
import com.fan.groupreboot.vo.UserVO;
import me.xuxiaoxiao.chatapi.wechat.WeChatClient;
import me.xuxiaoxiao.chatapi.wechat.entity.contact.WXGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.fan.groupreboot.service.WebChatClientService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2018/6/27.
 */
@Controller
public class GroupRecordController {

    @Autowired
    WebChatClientService webChatClientService;

    @GetMapping(value = "/")
    public String index(Model model) {

        WeChatClient client = webChatClientService.getClient();
        if (client != null && client.isWorking() && client.userMe() != null && client.userMe().name != null) {

            // 用户基本信息
            UserVO userVO = new UserVO();
            userVO.setName(client.userMe().name);
            model.addAttribute("user", userVO);

            // 群组信息
            List<GroupVO> groups=new ArrayList<GroupVO>;
            HashMap<String, WXGroup> groupMap = client.userGroups();
            Iterator<WXGroup> it = groupMap.values().iterator();
            while (it.hasNext()) {
                WXGroup WXGroup = it.next();
                GroupVO groupVO=new GroupVO();
                groupVO.setName(WXGroup.name);
                groups.add(groupVO);


            }

        }

        return "/view/index";
    }

    @GetMapping(value = "/login")
    public String login(Model model) {
        String qrCode = webChatClientService.createClient();
        model.addAttribute("qrCode", qrCode);
        return "/view/login.html";
    }
}
