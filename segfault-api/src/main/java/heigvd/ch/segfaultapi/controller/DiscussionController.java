package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Discussion;
import heigvd.ch.segfaultapi.model.Message;
import heigvd.ch.segfaultapi.model.Utilisateur;
import heigvd.ch.segfaultapi.repositories.DiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("discussions")
public class DiscussionController {

    private DiscussionRepository discussionRepository;

    @Autowired
    public DiscussionController(DiscussionRepository discussionRepository) {
        this.discussionRepository = discussionRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        List<Discussion> discussions = discussionRepository.findAll();
        if (discussions.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Discussion>>(discussions, HttpStatus.OK);

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Discussion> create(@RequestBody Discussion discussion) {

        discussionRepository.save(discussion);

        return discussionRepository.findAll();
    }
}
