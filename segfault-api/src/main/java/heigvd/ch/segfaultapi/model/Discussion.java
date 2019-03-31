package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "Discussion")
public class Discussion {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "discussionId")
    @NonNull
    private Long id;

    @Getter
    private String sujet;

    // TODO: 2019-03-18 référence vers message racine
    //private Message& racine;

    // Obligatoire pour JPA
    public Discussion () {}

    public Discussion (String sujet) {
        this.sujet = sujet;
    }

}
