package com.soft2run.socketio.controller;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.soft2run.socketio.dto.CustomerState;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class SocketIOController {

    private final String eventName = "car_crash";

    @Autowired
    private SocketIOServer socketServer;

    public SocketIOController(SocketIOServer socketServer){
        this.socketServer = socketServer;

        this.socketServer.addConnectListener(c -> log.info("Perform operation on user connect in controller"));
        this.socketServer.addDisconnectListener(c -> log.info("Perform operation on user disconnect in controller"));

        this.socketServer.addEventListener("userMessage", CustomerState.class, onSendMessage);
    }

    public DataListener<CustomerState> onSendMessage = new DataListener<>() {
        @Override
        public void onData(SocketIOClient client, CustomerState customerState, AckRequest acknowledge) {
            socketServer.getBroadcastOperations().sendEvent(eventName, customerState);

            acknowledge.sendAckData("Message send to target user successfully");
        }
    };

    @GetMapping(value = "/send")
    public ResponseEntity<String> sendSocketNotification() {
        CustomerState customerState = new CustomerState();
        customerState.setId(4L);
        customerState.setName("Test name");

        socketServer.getBroadcastOperations().sendEvent(eventName, customerState);
        return ResponseEntity.ok("OK");
    }
}
