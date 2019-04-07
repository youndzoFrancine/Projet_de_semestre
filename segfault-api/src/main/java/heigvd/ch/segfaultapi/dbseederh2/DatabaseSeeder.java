package heigvd.ch.segfaultapi.dbseederh2;

import heigvd.ch.segfaultapi.model.Discussion;
import heigvd.ch.segfaultapi.model.Tag;
import heigvd.ch.segfaultapi.model.Utilisateur;
import heigvd.ch.segfaultapi.repositories.DiscussionRepository;
import heigvd.ch.segfaultapi.repositories.TagRepository;
import heigvd.ch.segfaultapi.repositories.UtilisateurRepository;
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
    UtilisateurRepository utilisateurRepository;

    @Autowired
    TagRepository tagRepository;
    DatabaseSeeder(DiscussionRepository discussionRepository, UtilisateurRepository utilisateurRepository) {
        this.discussionRepository = discussionRepository;
        this.utilisateurRepository=utilisateurRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Discussion> discussions  = new ArrayList<>();
        List<Utilisateur> utilisateurs = new ArrayList<>();

        discussions.add(new Discussion("Pourquoi ça marche pas :(?"));
        discussions.add(new Discussion("Pourquoi PSQL c'est si compliqué?"));

        List<Tag> tags  = new ArrayList<>();

        tags.add(new Tag("cpp", true,1000));
        tags.add(new Tag("netbeans", false,1));

        tagRepository.saveAll(tags);


        /*utilisateurs.add(new Utilisateur("Francine youndzo", "vanglamhair@heig-vd.ch","12345" ));
        utilisateurs.add(new Utilisateur("Crescence Yimnaing", "yimnaingcres@heig-vd.ch","abcd"));
        utilisateurs.add(new Utilisateur("Tiago", "tiago@heig-vd.ch","happy"));
        utilisateurs.add(new Utilisateur("Cedric Lankeu","cedric.lank@heig-vd.ch","5678"));
        utilisateurs.add(new Utilisateur("ALexandre", "alex.andre@heig-vd.ch","sorry1"));
        utilisateurs.add(new Utilisateur("Maxouille", "max.ouille@heig-vd.ch","lol007"));*/

        discussionRepository.saveAll(discussions);
        //utilisateurRepository.saveAll(utilisateurs);
    }
}
