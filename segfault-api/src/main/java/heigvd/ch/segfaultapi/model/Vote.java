package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import heigvd.ch.segfaultapi.model.Utilisateur;
import heigvd.ch.segfaultapi.model.Message;

/**
 * The type Vote.
 */
@Entity
public class Vote {

    /**
     * The Id.
     */
    @EmbeddedId
    VoteKey id;

    /**
     * The Message.
     */
    @Getter
    @Setter
    @ManyToOne
    @MapsId("message_id")
    @JoinColumn(name = "message_id")
    Message message;

    /**
     * The Utilisateur.
     */
    @Getter
    @Setter
    @ManyToOne
    @MapsId("utilisateur_id")
    @JoinColumn(name = "utilisateur_id")
    Utilisateur utilisateur;

    /**
     * The Up vote.
     */
    @Getter
    @Setter
    Boolean upVote;

    /**
     * Instantiates a new Vote.
     */
    Vote() {}

}
