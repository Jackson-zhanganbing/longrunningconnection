package com.longrunningconnection.demo.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyJob {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(cron = "0/5 * * * * *")
    public void sendMessage() {
        System.out.println("来自服务端的消息");
        simpMessagingTemplate.convertAndSend("/server/sendMessageByServer", System.currentTimeMillis());
    }

    @Scheduled(fixedRate = 10000)
    public void sendMessageToUser() {
        System.out.println("来自服务端的消息,推送给指定用户");
        simpMessagingTemplate.convertAndSendToUser("1", "/server/sendMessageByServer", System.currentTimeMillis());
    }
}
