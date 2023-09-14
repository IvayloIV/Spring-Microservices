package com.soft2run.stomp.controller;

import com.soft2run.stomp.dto.CustomerState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/socket")
public class SocketController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public SocketController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @GetMapping(value = "/send")
    public ResponseEntity<String> sendSocketNotification() {
        CustomerState customerState = new CustomerState();
        customerState.setId(4L);
        customerState.setName("Test name");
        simpMessagingTemplate.convertAndSend("/gateway/topic/crash-event/", customerState);
        return ResponseEntity.ok("OK");
    }

    @MessageMapping("/receive")
    public void handleMessageWithoutResponse(String message) {
        System.out.println(message);
    }

    @MessageMapping("/name")
    @SendTo("/gateway/topic/crash-event/")
    public String handleNameMessage(String name) {
        return "Hello, " + name;
    }
}
