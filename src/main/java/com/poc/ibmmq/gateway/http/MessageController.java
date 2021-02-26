package com.poc.ibmmq.gateway.http;

import com.poc.ibmmq.usecase.SendNewMessage;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.http.MediaType.TEXT_XML_VALUE;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MessageController {

    private final SendNewMessage sendNewMessage;

    @ApiOperation(value = "create a new message for IBMMq", consumes = TEXT_PLAIN_VALUE)
    @PostMapping(value = "message", consumes = {TEXT_PLAIN_VALUE, TEXT_XML_VALUE})
    public ResponseEntity<String> createNewMessage(@RequestBody String newMessage) {
        log.info("Received message {}", newMessage);
        sendNewMessage.sendMessage(newMessage);
        return ResponseEntity.ok(newMessage);
    }
}
