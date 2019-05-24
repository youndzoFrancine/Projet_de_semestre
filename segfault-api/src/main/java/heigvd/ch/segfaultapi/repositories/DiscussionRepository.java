package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Discussion;
<<<<<<< HEAD
import org.springframework.data.domain.Page;
import java.awt.print.Pageable;
=======
import heigvd.ch.segfaultapi.model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
>>>>>>> e18e06b90b6fc4f2c658da4b7bf6095f1599a902
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;


import java.util.List;

<<<<<<< HEAD
public interface DiscussionRepository extends JpaRepository<Discussion, Integer> , PagingAndSortingRepository<Discussion,Integer> {
    //List<DiscussionProjection> findAllProjectedBy();

    List<Discussion> findAllBySujet(String sujet);

=======
/**
 * The interface Discussion repository.
 */
public interface DiscussionRepository extends JpaRepository<Discussion, Integer> {
    //List<DiscussionProjection> findAllProjectedBy();

    List<Discussion> findAllBySujet(String sujet);
    Page<Discussion> findAll(Pageable p);
    List<Discussion> findAllBySujetContaining(String sujet);
    List<Discussion> findAllByTagListContaining(Tag tag);
>>>>>>> e18e06b90b6fc4f2c658da4b7bf6095f1599a902
}


