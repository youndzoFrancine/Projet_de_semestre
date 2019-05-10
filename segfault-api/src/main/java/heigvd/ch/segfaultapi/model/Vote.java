package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import heigvd.ch.segfaultapi.model.Utilisateur;
import heigvd.ch.segfaultapi.model.Message;

@Entity
public class Vote {

    @EmbeddedId
    VoteKey id;

    @Getter
    @Setter
    @ManyToOne
    @MapsId("message_id")
    @JoinColumn(name = "message_id")
    Message message;

    @Getter
    @Setter
    @ManyToOne
    @MapsId("utilisateur_id")
    @JoinColumn(name = "utilisateur_id")
    Utilisateur utilisateur;

    @Getter
    @Setter
    Boolean upVote;

    Vote() {}

}
