package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
}
*/
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Utilisateur findByMailUtilisateur(String mailUtilisateur);
    Optional<Utilisateur> findByNomUtilisateur(String nomUtilisateur);
    Boolean existsByNomUtilisateur(String nomUtilisateur);
    Boolean existsByMailUtilisateur(String email);
}