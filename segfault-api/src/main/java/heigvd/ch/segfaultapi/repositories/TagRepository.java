package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
/**
 * The interface Tag repository.
 */
public interface TagRepository extends JpaRepository<Tag, Integer> {
    List<Tag> findAllByNom(String nom);

    Optional<Tag> findByNom(String nom);

    List<Tag> findAllByNomIsIn(List<String> nom);
}
