package com.poc.ibmmq.gateway.http;

import com.poc.ibmmq.usecase.SendNewMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MessageController {

    private final SendNewMessage sendNewMessage;

    @PostMapping(value = "message")
    public ResponseEntity<String> createNewMessage(@RequestBody String newMessage) {
        log.info("Received message {}", newMessage);
        sendNewMessage.sendMessage(newMessage);
        return ResponseEntity.ok(newMessage);
    }
}
