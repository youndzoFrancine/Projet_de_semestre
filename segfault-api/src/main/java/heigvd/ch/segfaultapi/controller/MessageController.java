package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Message;
import heigvd.ch.segfaultapi.projection.MessageReponse;
import heigvd.ch.segfaultapi.repositories.MessageRepository;
import heigvd.ch.segfaultapi.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("messages")
public class MessageController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

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
    public ResponseEntity<?> create (@RequestBody MessageReponse payload) {

        Message message = new Message();

        message.setText(payload.getContenu());

        message.setAuthor(utilisateurRepository.findById(payload.getUtilisateurID()).get());

        message.setDate(LocalDateTime.now());

        messageRepository.getOne(payload.getMessageID()).getChildMsg().add(message);
        messageRepository.save(message);

        return new ResponseEntity<>(HttpStatus.CREATED);
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

