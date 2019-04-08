package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Discussion;
import heigvd.ch.segfaultapi.model.Utilisateur;
import heigvd.ch.segfaultapi.repositories.DiscussionRepository;
import heigvd.ch.segfaultapi.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("utilisateur")
public class UtilisateurController {

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurController (UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Utilisateur> getAll () {
        return utilisateurRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Utilisateur> create (@RequestBody Utilisateur utilisateur) {

        utilisateurRepository.save(utilisateur);

        return utilisateurRepository.findAll();
    }
}