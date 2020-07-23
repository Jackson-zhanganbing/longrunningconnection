package com.longrunningconnection.demo.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class IndexController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("/")
    public String index(){
        return "index";
    }
    //发送指定用户
    @GetMapping("/user")
    public String user(Long id, ModelMap model){
        model.addAttribute("id",id);
        return "user";
    }
    //发送指定用户
    @GetMapping("/send")
    @ResponseBody
    public void sendMessage(){
        System.out.println("来自服务端的消息");
        simpMessagingTemplate.convertAndSend("/server/sendMessageByServer",System.currentTimeMillis());
    }
}
