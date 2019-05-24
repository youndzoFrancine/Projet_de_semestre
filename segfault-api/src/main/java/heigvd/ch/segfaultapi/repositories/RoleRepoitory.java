package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Role repoitory.
 */
public interface RoleRepoitory extends JpaRepository<Role, Integer>{
    /**
     * Find by nom role optional.
     *
     * @param nomRole the nom role
     * @return the optional
     */
    Optional<Role> findByNomRole(String nomRole);
    Optional<Role> findByRoleID(Integer id);

}
