package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Discussion;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;

public interface DiscussionRepository extends JpaRepository<Discussion, Integer> , PagingAndSortingRepository<Discussion,Integer> {
   // Page<Discussion> findAll(Pageable pageable);
}
