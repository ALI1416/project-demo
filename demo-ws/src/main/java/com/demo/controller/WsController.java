package com.demo.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * <h1>WsController</h1>
 *
 * <p>
 * createDate 2021/12/16 10:05:53
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 **/
@Controller
@AllArgsConstructor
@Slf4j
public class WsController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    /**
     * 广播模式
     */
    @MessageMapping("/broadcast")
    public String broadcast(String msg, Principal principal) {
        String data = "广播模式:用户[" + principal.getName() + "]发送广播消息[" + msg + "]";
        log.info(data);
        return data;
    }

    /**
     * 订阅模式
     */
    @SubscribeMapping("/subscribe/{path}")
    public String subscribe(@DestinationVariable String path, Principal principal) {
        String data = "订阅模式:用户[" + principal.getName() + "]订阅[/subscribe/" + path + "]";
        log.info(data);
        return data;
    }

    /**
     * 用户模式
     */
    @MessageMapping("/sendToUser/{user}")
    public void sendToUser(@DestinationVariable String user, String msg, Principal principal) {
        String data = "用户模式:用户[" + principal.getName() + "]发送给用户[" + user + "]消息[" + msg + "]";
        log.info(data);
        simpMessagingTemplate.convertAndSendToUser(user, "/queue/sendToUser", data);
    }

}
