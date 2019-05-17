package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Discussion;
import heigvd.ch.segfaultapi.model.Message;
import heigvd.ch.segfaultapi.projection.DiscussionCreate;
import heigvd.ch.segfaultapi.repositories.DiscussionRepository;
import heigvd.ch.segfaultapi.repositories.MessageRepository;
import heigvd.ch.segfaultapi.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("discussions")
public class DiscussionController {

    @Autowired
    private DiscussionRepository discussionRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private MessageRepository messageRepository;

/*
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        List<Discussion> discussions = discussionRepository.findAll();
        if (discussions.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Discussion>>(discussions, HttpStatus.OK);

    }
*/
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody DiscussionCreate payload) {

        if (!discussionRepository.findAllBySujet(payload.getSujet()).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }

        // On commence par créer le message

        Message message = new Message();

        message.setDateCreation(LocalDateTime.now());

        message.setAuteur(utilisateurRepository.findById(payload.getUtilisateurID()).get());

        message.setContenu(payload.getContenu());

        messageRepository.save(message);

        // Puis on l'ajoute à la discussion

        Discussion discussion = new Discussion();

        discussion.setSujet(payload.getSujet());

        discussion.setMsgracine(message);

        discussionRepository.save(discussion);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Page<Discussion> getAll (@RequestParam("page") int page) {

        Pageable tstPage = PageRequest.of(page, 7);
        return discussionRepository.findAll(tstPage);
    }
}
