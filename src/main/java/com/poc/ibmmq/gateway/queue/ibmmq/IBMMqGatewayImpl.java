package com.poc.ibmmq.gateway.queue.ibmmq;

import com.poc.ibmmq.properties.AppProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class IBMMqGatewayImpl {

    private final JmsTemplate jmsTemplate;
    private final AppProperties appProperties;

    public void sendMessage(final String message) {
        try {
            jmsTemplate.convertAndSend(appProperties.getQueuename(), message.getBytes());
        } catch (final Exception e) {
            log.error("Failed to send message", e);
        }

    }


}
