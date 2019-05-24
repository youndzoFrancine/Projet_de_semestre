package heigvd.ch.segfaultapi.repositories;

import heigvd.ch.segfaultapi.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Message repository.
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {
}
