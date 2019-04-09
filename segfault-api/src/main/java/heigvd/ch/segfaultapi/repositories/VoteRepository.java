package heigvd.ch.segfaultapi.repositories;


import heigvd.ch.segfaultapi.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VoteRepository extends JpaRepository<Vote, Long> {
    //User findById(Integer utilisateurID);
}