package heigvd.ch.segfaultapi.dbseederh2;

import heigvd.ch.segfaultapi.model.Discussion;
import heigvd.ch.segfaultapi.model.Message;
import heigvd.ch.segfaultapi.repositories.DiscussionRepository;
import heigvd.ch.segfaultapi.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//
/**
 * Retirer cet autorun si ce n'est pas utilisé
 */
@Component
public class DatabaseSeeder implements CommandLineRunner {

    DiscussionRepository discussionRepository;
    MessageRepository messageRepository;

    @Autowired
    DatabaseSeeder(DiscussionRepository discussionRepository, MessageRepository messageRepository) {
        this.discussionRepository = discussionRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Discussion> discussions  = new ArrayList<>();
        List<Message> messages = new ArrayList<>();

        discussions.add(new Discussion("Pourquoi ça marche pas :(?"));
        discussions.add(new Discussion("Pourquoi PSQL c'est si compliqué?"));

        //============================ Messages ========================================================================

        Discussion d1 = new Discussion("Questions Labo4 PCO");
        Discussion d2 = new Discussion("Projet de semestre");
        discussions.add(d1);
        discussions.add(d2);
        Message m1 = new Message((long)1, d1.getId(), "Quel delai pour le rendu");
        Message m2 = new Message((long) 2, d2.getId(), "Faut-il normaliser la BD ? ");

        messages.add(m1);
        messages.add(m2);

        discussionRepository.saveAll(discussions);
        messageRepository.saveAll(messages);
    }
}
