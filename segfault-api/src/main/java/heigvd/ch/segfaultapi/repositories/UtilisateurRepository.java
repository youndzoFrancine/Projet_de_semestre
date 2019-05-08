package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    List<Utilisateur> findBynomUtilisateurStartingWith(String nomUtilisateur);
}
