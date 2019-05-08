package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Utilisateur;
import heigvd.ch.segfaultapi.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("utilisateurs")
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

    /**
     * Cette méthode retourne une liste de tous les Utilisateurs qui
     * commencent par un nom donné
     * @param nom
     * @return
     */
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public List<Utilisateur> getStartingWith (@RequestParam("nom") String nom) {
        System.out.print(nom);

        return utilisateurRepository.findBynomUtilisateurStartingWith(nom);
    }
}
