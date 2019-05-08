package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Message;
import heigvd.ch.segfaultapi.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
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

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public Optional<Message> getById (@PathVariable("id") Integer id) {
        return messageRepository.findById(id);
    }

    // todo il faut pouvoir chercher par nom
/*
    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public Optional<Message> getByName (@PathVariable("id") Integer id) {
        return messageRepository.findById(id);
    }

 */
}

