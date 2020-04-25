package com.poc.ibmmq.usecase;

import com.poc.ibmmq.gateway.queue.ibmmq.IBMMqGatewayImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendNewMessage {

    private final IBMMqGatewayImpl ibmMqGateway;

    public void sendMessage(final String newMessage) {
        ibmMqGateway.sendMessage(newMessage);
    }
}
