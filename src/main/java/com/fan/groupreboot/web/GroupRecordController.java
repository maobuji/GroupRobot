package com.fan.groupreboot.web;

import com.fan.groupreboot.vo.UserClientVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.fan.groupreboot.service.WebChatClientService;

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
        List<UserClientVO> ls = webChatClientService.listUserClient();
        model.addAttribute("userClients", ls);
        return "/view/index";
    }
}
