package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // Obligatoire pour JPA
@Entity
@Table(name = "Discussion")
public class Discussion {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long discussionid;

    @Getter
    private String sujet;

    // TODO: 2019-03-18 référence vers message racine
    //private Message& racine;




    public Discussion (String sujet) {
        this.sujet = sujet;
    }

}
