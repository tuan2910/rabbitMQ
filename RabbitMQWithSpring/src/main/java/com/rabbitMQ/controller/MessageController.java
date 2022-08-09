package com.rabbitMQ.controller;

import com.rabbitMQ.config.ConfigReceive;
import com.rabbitMQ.dto.MessageDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/send")
    public void sendMessage(@RequestBody MessageDTO messageDTO) {
         rabbitTemplate.convertAndSend(ConfigReceive.EXCHANGE_NAME,ConfigReceive.ROUTING_KEY,messageDTO.getMessageText());
    }
}
