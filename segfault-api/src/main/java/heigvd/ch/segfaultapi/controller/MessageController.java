package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Message;

import heigvd.ch.segfaultapi.model.Utilisateur;
import heigvd.ch.segfaultapi.repositories.MessageRepository;
import heigvd.ch.segfaultapi.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("messages")
public class MessageController {


    private MessageRepository messageRepository;



    @Autowired
    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Message> getAll () {
        return messageRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Message> create (@RequestBody Message message) {

        messageRepository.save(message);
        return messageRepository.findAll();
    }
}

