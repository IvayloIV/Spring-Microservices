package com.soft2run.stomp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.List;

@Configuration
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer {

    @Value("#{'${ride.allowed.origin}'.split(',')}")
    List<String> allowedOrigin;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry
                                               registry) {
        registry.addEndpoint("/gateway").setAllowedOrigins(allowedOrigin.toArray(new String[0]));
        registry.addEndpoint("/gateway").setAllowedOrigins(allowedOrigin.toArray(new String[0])).withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/gateway/topic/", "/gateway/queue/");
        config.setApplicationDestinationPrefixes("/gateway");
    }
}
