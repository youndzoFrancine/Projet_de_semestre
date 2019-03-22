package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
}
