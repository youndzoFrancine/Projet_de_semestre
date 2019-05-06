package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
   // public Utilisateur findOne(Integer id);
   /* boolean existsByUsername(String nom_utilisateur);
    Utilisateur findByNom_utilisateur(String nom_utilisateur);

    @Transactional
    void deleteByNom_utilisateur(String nom_utilisateur);*///
}
