package com.soft2run.grpc.server;

import com.soft2run.grpc.contacts.PingPongServiceGrpc;
import com.soft2run.grpc.contacts.PingRequest;
import com.soft2run.grpc.contacts.PongResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class PingPongImpl extends PingPongServiceGrpc.PingPongServiceImplBase {

    @Override
    public void ping(PingRequest request, StreamObserver<PongResponse> responseObserver) {
        String greeting = String.format("Hello, %s %s", request.getFirstName(), request.getLastName());
        PongResponse response = PongResponse.newBuilder().setGreeting(greeting).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
