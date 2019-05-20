package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
/**
 * The type Vote.
 */
@Entity
public class Vote {

    /**
     * The Id.
     */
    @Getter
    @Setter
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
     * Cette méthode retourne l'id du message du vote.
     * @return
     */
    public Integer getMessageID() {
        return this.message.getId();
    }
}
