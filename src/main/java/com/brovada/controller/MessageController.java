package com.brovada.controller;

import com.brovada.document.Message;
import com.brovada.repository.MessageRepository;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;


@RestController
@RequestMapping(value = "/message")
public class MessageController {

    @Inject
    private MessageRepository messageRepository;

    @MessageMapping("/chat/{to}")
    @SendTo("/topic/messages/{to}")
    public Message chat(@DestinationVariable String to, Message message) throws Exception {
        // hook to alter the message or return another object type that will be posted to /topic/....
        messageRepository.save(message.sentTo(to));
        return message;
    }

    @RequestMapping(value = "/all")
    public List<Message> all() {
        return messageRepository.findAll();
    }

}