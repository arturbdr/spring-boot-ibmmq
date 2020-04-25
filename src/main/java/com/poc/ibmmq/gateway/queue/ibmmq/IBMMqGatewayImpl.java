package com.poc.ibmmq.gateway.queue.ibmmq;

import com.poc.ibmmq.properties.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IBMMqGatewayImpl {

    private final JmsTemplate jmsTemplate;
    private final AppProperties appProperties;

    public void sendMessage(final String message) {
        jmsTemplate.convertAndSend(appProperties.getQueuename(), message.getBytes());
    }


}
