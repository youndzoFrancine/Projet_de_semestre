package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Vote;
import heigvd.ch.segfaultapi.model.VoteKey;
import heigvd.ch.segfaultapi.projection.VoteCreate;
import heigvd.ch.segfaultapi.projection.VoteDto;
import heigvd.ch.segfaultapi.repositories.MessageRepository;
import heigvd.ch.segfaultapi.repositories.UtilisateurRepository;
import heigvd.ch.segfaultapi.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Vote controller.
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("votes")
public class VoteController {

    @Autowired
    private VoteRepository voteRepository;

    /**
     * Gets all.
     *
     * @return the all
     */
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    MessageRepository messageRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<VoteDto> getAll() {
        return voteRepository.findAllProjectedBy();
    }

    /**
     * Trouve tous les votes pour l'id d'un utilisateur donné
     * @param id
     * @return
     */
    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public List<VoteDto> getById (@PathVariable("id") Integer id) {

        return voteRepository.findAllByUtilisateur(utilisateurRepository.findById(id).get());
    }

    /**
     * /create
     * @param payload
     * @return Status 201, la Key de Vote
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody VoteCreate payload) {


        Vote vote = new Vote();

        vote.setMessage(messageRepository.findById(payload.getMessageID()).get());

        vote.setUtilisateur(utilisateurRepository.findById(payload.getUtilisateurID()).get());

        vote.setUpVote(payload.getUpVote());

        vote.setId(new VoteKey(payload.getMessageID(), payload.getUtilisateurID()));

        voteRepository.save(vote);

        return new ResponseEntity<>(vote.getId(), HttpStatus.CREATED);
    }

}
