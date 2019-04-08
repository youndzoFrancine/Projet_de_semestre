package heigvd.ch.segfaultapi.repositories;


import heigvd.ch.segfaultapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

	//User findById(Integer utilisateurID);
}