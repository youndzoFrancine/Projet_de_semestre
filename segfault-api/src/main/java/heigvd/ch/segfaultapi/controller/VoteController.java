package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Vote;
import heigvd.ch.segfaultapi.repositories.RoleRepoitory;
import heigvd.ch.segfaultapi.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Vote> getAll() {
        return voteRepository.findAll();
    }
}
