package com.example.mqspring.controller;

import com.example.mqspring.entity.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final JmsTemplate jmsTemplate;

    @GetMapping("/send")
    String send() {
        try {
//            jmsTemplate.convertAndSend("DEV.QUEUE.1", "Hello World!");
            jmsTemplate.convertAndSend("DEV.QUEUE.1",
                    new Message("staal@ya.ru", "test", "test-text")
            );
            return "OK";
        } catch (JmsException ex) {
            ex.printStackTrace();
            return "FAIL";
        }
    }

    @GetMapping("/recv")
    String recv() {
        try {
//            return jmsTemplate.receiveAndConvert("DEV.QUEUE.1").toString();
            var response = (Message) jmsTemplate.receiveAndConvert("DEV.QUEUE.1");
            return response.toString();
        } catch (JmsException ex) {
            ex.printStackTrace();
            return "FAIL";
        }
    }

}
