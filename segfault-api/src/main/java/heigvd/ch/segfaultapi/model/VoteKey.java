package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

import heigvd.ch.segfaultapi.model.*;

@Embeddable
public class VoteKey implements Serializable {
    @Getter
    @Setter
    @Column(name = "message_id")
    Integer messageId;

    @Getter
    @Setter
    @Column(name = "utilisateur_id")
    Integer utilisateurId;

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass();
    }

   /* @Override
    public int hashCode(){
        return this;
    }*/


}
