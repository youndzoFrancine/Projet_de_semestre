package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
}
