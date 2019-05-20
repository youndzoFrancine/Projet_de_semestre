package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Vote {

    @Setter
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

    /**
     * Cette méthode retourne l'id du message du vote.
     * @return
     */
    public Integer getMessageID() {
        return this.message.getId();
    }
}
