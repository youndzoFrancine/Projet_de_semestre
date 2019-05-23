package heigvd.ch.segfaultapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import heigvd.ch.segfaultapi.model.Departement;

/**
 * The interface Departement repository.
 */
public interface DepartementRepository extends JpaRepository<Departement, Integer> {

}
