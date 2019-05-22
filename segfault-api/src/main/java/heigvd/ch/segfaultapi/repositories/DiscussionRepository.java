package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Discussion;
import heigvd.ch.segfaultapi.model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Discussion repository.
 */
public interface DiscussionRepository extends JpaRepository<Discussion, Integer> {
    //List<DiscussionProjection> findAllProjectedBy();

    List<Discussion> findAllBySujet(String sujet);
    Page<Discussion> findAll(Pageable p);
    List<Discussion> findAllBySujetContaining(String sujet);
    //List<Discussion> findAllByTagListIn(Tag tag);

    List<Discussion> findAllByTagListIn(List<Tag> tagList);

    List<Discussion> findDistinctByTagListIn(List<Tag> tagList);

    Page<Discussion> findAllbyBySujetContaining(String atrouver, Pageable p);
    List<Discussion> findAllbyBySujetContaining(String atrouver);

}
