package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscussionRepository extends JpaRepository<Discussion, Integer> {
    //List<DiscussionProjection> findAllProjectedBy();

    List<Discussion> findAllBySujet(String sujet);
}
