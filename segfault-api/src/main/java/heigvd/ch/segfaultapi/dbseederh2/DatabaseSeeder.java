package heigvd.ch.segfaultapi.dbseederh2;

import heigvd.ch.segfaultapi.model.Discussion;
import heigvd.ch.segfaultapi.model.Tag;
import heigvd.ch.segfaultapi.model.Message;
import heigvd.ch.segfaultapi.repositories.DiscussionRepository;
import heigvd.ch.segfaultapi.repositories.TagRepository;
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



    @Autowired
    DiscussionRepository discussionRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    TagRepository tagRepository;



    @Override
    public void run(String... args) throws Exception {
        List<Discussion> discussions  = new ArrayList<>();

        discussions.add(new Discussion("Pourquoi ça marche pas :(?"));
        discussions.add(new Discussion("Pourquoi PSQL c'est si compliqué?"));

        // Tags

        List<Tag> tags  = new ArrayList<>();

        tags.add(new Tag("cpp", true,1000));
        tags.add(new Tag("netbeans", false,1));



        // Messages
        List<Message> messages = new ArrayList<>();

        Discussion d1 = new Discussion("Questions Labo4 PCO");
        discussions.add(d1);
/*
        messages.add(new Message("Je sais pas comment faire et ça me rend triste",
                discussionRepository.getOne(1).getId()));
*/

        discussionRepository.saveAll(discussions);
        messageRepository.saveAll(messages);
        tagRepository.saveAll(tags);
    }
}
