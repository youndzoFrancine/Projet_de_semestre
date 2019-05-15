package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Vote;
import heigvd.ch.segfaultapi.projection.VoteDto;
import heigvd.ch.segfaultapi.repositories.UtilisateurRepository;
import heigvd.ch.segfaultapi.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("votes")
public class VoteController {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Vote> getAll() {
        return voteRepository.findAll();
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

}
