package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Utilisateur;
import heigvd.ch.segfaultapi.model.Vote;
import heigvd.ch.segfaultapi.projection.VoteDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * The interface Vote repository.
 */
public interface VoteRepository extends JpaRepository<Vote, Integer> {
    List<VoteDto> findAllByUtilisateur(Utilisateur utilisateur);

    List<VoteDto> findAllProjectedBy();

}

