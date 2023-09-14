package com.soft2run.websocket.controller;

import com.soft2run.websocket.handlers.ServerWebSocketHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@RestController
@RequestMapping(path = "/socket")
public class SocketController {

    @GetMapping(value = "/send")
    public ResponseEntity<String> sendSocketNotification() throws IOException {
        for (WebSocketSession session : ServerWebSocketHandler.sessions) {
            session.sendMessage(new TextMessage("Hello, AI message"));
        }

        return ResponseEntity.ok("OK");
    }
}
