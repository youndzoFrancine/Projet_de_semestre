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
    Page<Discussion> findAllByOrderByMsgracine_DateDesc(Pageable p);

    Page<Discussion> findAllByOrderByMsgracine_ScoreDesc(Pageable p);



    List<Discussion> findAllByTagListInOrderByMsgracine_DateDesc(List<Tag> tagList);
    List<Discussion> findAllByTagListInOrderByMsgracine_ScoreDesc(List<Tag> tagList);
    // List<Discussion> findDistinctByTagListIn(List<Tag> tagList);


    List<Discussion> findDistinctBySujetContainingOrMsgracine_TextContaining(String trouvertitre, String trouvertexte);


}
