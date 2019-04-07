package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
