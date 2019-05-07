package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class Vote implements Serializable {



    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "message_id")
    Message message;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    Utilisateur utilisateur;

    @Getter
    @Setter
    @Column(name = "up_vote")
    Boolean upVote;

    Vote() {}


}
