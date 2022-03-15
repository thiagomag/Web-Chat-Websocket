package br.com.thiago.webchatwebsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //annotation is used to enable our WebSocket server.
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer //interface is used to provide implementation for some of its methods to configure the websocket connection.
{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //method is used to register a websocket endpoint that the clients will use to connect to the server.
        registry.addEndpoint("/websocket").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //method is used to configure our message broker which will be used to route messages from one client to another.
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
