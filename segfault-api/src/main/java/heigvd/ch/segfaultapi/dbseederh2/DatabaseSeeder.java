package heigvd.ch.segfaultapi.dbseederh2;

import heigvd.ch.segfaultapi.model.Discussion;
import heigvd.ch.segfaultapi.repositories.DiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//
/*

@Component
public class DatabaseSeeder implements CommandLineRunner {

    DiscussionRepository discussionRepository;

    @Autowired
    DatabaseSeeder(DiscussionRepository discussionRepository) {
        this.discussionRepository = discussionRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        List<Discussion> discussions  = new ArrayList<>();

        discussions.add(new Discussion("Pourquoi ça marche pas :(?"));
        discussions.add(new Discussion("help avec java de merde"));

        discussionRepository.saveAll(discussions);
    }
}
*/