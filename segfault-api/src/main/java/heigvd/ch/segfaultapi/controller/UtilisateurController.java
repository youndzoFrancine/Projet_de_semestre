package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Utilisateur;
import heigvd.ch.segfaultapi.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("utilisateur_id") Integer id, @RequestBody Utilisateur utilisateur) {
        System.out.println("Update user with ID = " + utilisateur.getUtilisateurID() + "...");

        Optional<Utilisateur> users;
        users= utilisateurRepository.findById(utilisateur.getUtilisateurID());
        Utilisateur userUpadate = users.get();

        if(users == null){
            return new ResponseEntity("users doesn't exist", HttpStatus.BAD_REQUEST);
        }

        if(!(userUpadate.getNomUtilisateur().equals(" ")))
            userUpadate.setNomUtilisateur(utilisateur.getNomUtilisateur());

        if(!(userUpadate.getMailUtilisateur().equals(" ")))
            userUpadate.setMailUtilisateur(utilisateur.getMailUtilisateur());

        if(!(userUpadate.getMotDePasse().equals(" ")))
            userUpadate.setMotDePasse(utilisateur.getMotDePasse());

        utilisateurRepository.save(userUpadate);


        return new ResponseEntity<>("user has been update!", HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("utilisateur_id") Integer id) {
        System.out.println("Delete user with ID = " + id + "...");

        utilisateurRepository.deleteById(id);

        return new ResponseEntity<>("user has been deleted!", HttpStatus.OK);
    }
}
