package com.soft2run.rabbit.integration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Channels {

    @Input(value = "station-topic")
    SubscribableChannel stations();
}
