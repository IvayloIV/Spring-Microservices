package com.soft2run.grpc.client;

import com.soft2run.grpc.contacts.PingPongServiceGrpc;
import com.soft2run.grpc.contacts.PingRequest;
import com.soft2run.grpc.contacts.PongResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @GrpcClient("ping-pong-service")
    private PingPongServiceGrpc.PingPongServiceBlockingStub pingPongService;

    @GetMapping("/call")
    public String callServer() {
        PingRequest pingRequest = PingRequest.newBuilder()
                .setFirstName("Ivan")
                .setLastName("Petrov")
                .build();

        PongResponse pongResponse = pingPongService.ping(pingRequest);
        return pongResponse.getGreeting();
    }
}
