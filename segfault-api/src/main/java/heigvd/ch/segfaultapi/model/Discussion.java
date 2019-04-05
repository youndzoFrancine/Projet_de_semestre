package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    // TODO: 2019-03-18 référence vers message racine
    //private Message& racine;

    public Discussion (String sujet) {
        this.sujet = sujet;
    }

}
