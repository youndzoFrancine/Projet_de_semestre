package com.pro.forum.controller;


import com.pro.forum.model.Message;
import com.pro.forum.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class MessageController {

    private MessageRepository messageRepository;

    @Autowired
    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/message")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Message> getAllMessage () {
        return messageRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Message> newMessage (@RequestBody Message message) {

        messageRepository.save(message);
        return messageRepository.findAll();
    }
}