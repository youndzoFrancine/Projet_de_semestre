package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Vote;
import heigvd.ch.segfaultapi.repositories.RoleRepoitory;
import heigvd.ch.segfaultapi.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class VoteController {

    @Autowired
    private VoteRepository voteRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Vote> getAll() {
        System.out.println("Get all tags...");

        return voteRepository.findAll();
    }
}
