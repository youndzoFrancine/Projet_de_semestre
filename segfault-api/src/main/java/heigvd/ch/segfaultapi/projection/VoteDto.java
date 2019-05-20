package heigvd.ch.segfaultapi.projection;

import heigvd.ch.segfaultapi.model.Message;
import heigvd.ch.segfaultapi.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe est une DTO (Data Transfer Object)
 * On l'expose dans le controller de Vote à la place de
 * la vraie classe vote pour limiter les champs montrés.
 */
@AllArgsConstructor
public class VoteDto {

    @Setter
    private Utilisateur utilisateur;

    @Setter
    private Message message;

    @Setter
    @Getter
    Boolean upVote;

    public Integer getUtilisateurID() {return this.utilisateur.getUtilisateurID();}

    public Integer getMessageID() {
        return this.message.getId();
    }

    /*
    public Integer getMessageScore() {
        return this.message.getScore();
    }

     */
}
