package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Role;
import heigvd.ch.segfaultapi.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer>{
    Optional<Role> findByNomRole(RoleName roleName);
}
