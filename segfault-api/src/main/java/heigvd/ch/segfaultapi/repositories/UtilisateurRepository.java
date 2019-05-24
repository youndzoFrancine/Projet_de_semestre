package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Utilisateur repository.
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    /**
     * Find bynom utilisateur starting with list.
     *
     * @param nomUtilisateur the nom utilisateur
     * @return the list
     */
    List<Utilisateur> findBynomUtilisateurStartingWith(String nomUtilisateur);

    /**
     * Find by mail utilisateur utilisateur.
     *
     * @param mailUtilisateur the mail utilisateur
     * @return the utilisateur
     */
    Utilisateur findByMailUtilisateur(String mailUtilisateur);

    /**
     * Find by nom utilisateur optional.
     *
     * @param nomUtilisateur the nom utilisateur
     * @return the optional
     */
    Optional<Utilisateur> findByNomUtilisateur(String nomUtilisateur);

    /**
     * Find by id, returns optional.
     *
     * @param id l'id utilisateur
     * @return the optional
     */
    Optional<Utilisateur> findByUtilisateurID(Integer id);

    /**
     * Exists by nom utilisateur boolean.
     *
     * @param nomUtilisateur the nom utilisateur
     * @return the boolean
     */
    Boolean existsByNomUtilisateur(String nomUtilisateur);

    /**
     * Exists by mail utilisateur boolean.
     *
     * @param email the email
     * @return the boolean
     */
    Boolean existsByMailUtilisateur(String email);
}
