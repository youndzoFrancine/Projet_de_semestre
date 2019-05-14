package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.*;
import java.util.Set;

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

    @Getter
    private String sujet;

    @Setter
    @Getter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "utilisateur_id")
    private Utilisateur utilisateur;

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
            joinColumns = @JoinColumn(name ="tag_id"),
            inverseJoinColumns = @JoinColumn(name = "discussion_id")
    )
    private Set<Tag> tagSet;


    public Discussion (String sujet) {
        this.sujet = sujet;
    }



}
