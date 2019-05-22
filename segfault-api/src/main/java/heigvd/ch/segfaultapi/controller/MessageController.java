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


/**
 * The type Message controller.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("messages")
public class MessageController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    private MessageRepository messageRepository;

    /**
     * Instantiates a new Message controller.
     *
     * @param messageRepository the message repository
     */
    @Autowired
    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Message> getAll () {
        return messageRepository.findAll();
    }

    /**
     * Create list.
     *
     * @param message the message
     * @return the list
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create (@RequestBody MessageReponse payload) {

        Message message = new Message();

        message.setText(payload.getContenu());

        message.setAuthor(utilisateurRepository.findById(payload.getUtilisateurID()).get());

        message.setDate(LocalDateTime.now());

        messageRepository.getOne(payload.getMessageID()).getChildMsg().add(message);
        messageRepository.save(message);

        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> remove (@PathVariable("id") Integer id) {

        if (messageRepository.findById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        messageRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

