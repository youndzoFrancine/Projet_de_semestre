package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RoleRepoitory extends JpaRepository<Role, Long>{
}
