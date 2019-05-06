package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import heigvd.ch.segfaultapi.model.Utilisateur;

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


   /* @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("utilisateur_id") Utilisateur utilisateur) {
        System.out.println("Update user with ID = " + utilisateur.getUtilisateurId() + "...");

        Utilisateur users;
        users= utilisateurRepository.findOne(utilisateur.getUtilisateurId());

        if(users == null){
            return new ResponseEntity("utilisateur n'existe pas", HttpStatus.BAD_REQUEST);
        }

        if(!(users.getNom_utilisateur().equals(" ")))
        users.setNom_utilisateur(utilisateur.getNom_utilisateur());

        if(!(users.getMail_utilisateur().equals(" ")))
        users.setMail_utilisateur(utilisateur.getMail_utilisateur());

        if(!(users.getMot_de_passe().equals(" ")))
        users.setMot_de_passe(utilisateur.getMot_de_passe());

        utilisateurRepository.save(users);


        return new ResponseEntity<>("user has been update!", HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("utilisateur_id") Integer id) {
        System.out.println("Delete user with ID = " + id + "...");

        utilisateurRepository.deleteById(id);

        return new ResponseEntity<>("user has been deleted!", HttpStatus.OK);
    }*/

}