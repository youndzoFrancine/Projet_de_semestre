package heigvd.ch.segfaultapi.projection;

import heigvd.ch.segfaultapi.model.Message;
import heigvd.ch.segfaultapi.model.Role;
import heigvd.ch.segfaultapi.model.Tag;
import heigvd.ch.segfaultapi.model.Utilisateur;
import jdk.jshell.execution.Util;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
public class DiscussionDto {

    @Setter
    private Message msgracine;

    @Getter
    @Setter
    private String sujet;


    public Integer getMessageID () {
        return this.msgracine.getMessageId();
    }

    public LocalDateTime getMessageDate () {
        return this.msgracine.getDateCreation();
    }

    public Integer getScore () {
        return this.msgracine.getScore();
    }

    public Utilisateur getAuteur () {
        return this.msgracine.getAuteur();
    }

    // TODO: 2019-05-15 Pas encore fonctionnel ça, sais pas pourquoi
    
    /*
    

    public Integer getAuteurID () {
        return this.msgracine.getAuteur().getUtilisateurID();
    }

    public String getAuteurNom () {
        return this.msgracine.getAuteur().getNomUtilisateur();
    }

    public Role getAuteurRole () {
        return this.msgracine.getAuteur().getRole();
    }


*/
}
