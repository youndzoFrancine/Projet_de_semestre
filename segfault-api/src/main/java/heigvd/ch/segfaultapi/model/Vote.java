package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "vote")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "update_score_msg",
                procedureName = "UPDATE_SCORE_MESSAGE",
                resultClasses = { vote.class },
                parameters = {
                        @StoredProcedureParameter(
                                name = "message_id",
                                type = Integer.class,
                                mode = ParameterMode.IN),
                        @StoredProcedureParameter(
                                name = "up_vote",
                                type = Boolean.class,
                                mode = ParameterMode.IN), })
})
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
        return this.message.getMessageId();
    }
}
