package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * The type Discussion.
 */
 // Obligatoire pour JPA
@NoArgsConstructor // Obligatoire pour JPA
@Entity
@Table(name = "Discussion")
public class Discussion {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discussion_id")
    @NonNull
    private Integer id;

    @Setter
    @Getter
    private String sujet;

    /*
    Plus besoin de ça, on récupère l'auteur dans le message racine.
    @Setter
    @Getter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "utilisateur_id")
    private Utilisateur utilisateur;*/

    @Setter
    @Getter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "msgracine_id", referencedColumnName = "message_id")
    private Message msgracine;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(
            name = "Est_lier",
            joinColumns = @JoinColumn(name ="discussion_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tagList = new ArrayList<>();

    /**
     * Instantiates a new Discussion.
     *
     * @param sujet the sujet
     */
    public Discussion (String sujet) {
        this.sujet = sujet;
    }

}
