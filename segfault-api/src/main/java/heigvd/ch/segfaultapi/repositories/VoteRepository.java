package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Vote repository.
 */
public interface VoteRepository extends JpaRepository<Vote, Integer> {

}

