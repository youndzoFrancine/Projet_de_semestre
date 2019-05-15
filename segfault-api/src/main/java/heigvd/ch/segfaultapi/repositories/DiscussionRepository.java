package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Discussion;
import heigvd.ch.segfaultapi.projection.DiscussionDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscussionRepository extends JpaRepository<Discussion, Integer> {
    List<DiscussionDto> findAllProjectedBy();

    List<Discussion> findAllBySujet(String sujet);
}
