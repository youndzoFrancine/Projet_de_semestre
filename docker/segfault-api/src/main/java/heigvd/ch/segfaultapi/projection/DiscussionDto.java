package heigvd.ch.segfaultapi.projection;

import heigvd.ch.segfaultapi.model.Message;
import heigvd.ch.segfaultapi.model.Tag;
import heigvd.ch.segfaultapi.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


public class DiscussionDto {

    DiscussionDto (Message msgracine, String sujet, Tag tag) {
        int i = 1;
        i = 2;

        this.msgracine = msgracine;

        this.sujet = sujet;
    }


        DiscussionDto (Message msgracine, String sujet, List<Tag> tagList) {
        this.msgracine = msgracine;

        this.sujet = sujet;

        this.tagList = List.copyOf(tagList);
    }


    @Setter
    private Message msgracine;

    @Getter
    @Setter
    private String sujet;


    public Integer getMessageID () {
        return this.msgracine.getId();
    }

    public LocalDateTime getMessageDate () {
        return this.msgracine.getDate();
    }

    public Integer getScore () {
        return this.msgracine.getScore();
    }

    public Utilisateur getAuteur () {
        return this.msgracine.getAuthor();
    }

    @Getter
    @Setter
    private List<Tag> tagList;


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
