package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Discussion repository.
 */
public interface DiscussionRepository extends JpaRepository<Discussion, Integer> {
}
