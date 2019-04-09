package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


// https://www.developpez.net/forums/d899963/java/general-java/persistance/hibernate/annotations-manytomany-1-classe-2-tables-infos-table-jointure/


@Entity
@Table( name = "vote" )
@IdClass( Vote.class )  // TODO car Idclass est sencé etre une classe defissant les methode equal et hashcode
public class Vote implements Serializable {

    @Id
    @Column( name = "utilisateur_id", nullable = false )
    private Integer idUser;

    @Id
    @Column( name = "message_id", nullable = false )
    private Integer idMessage;

    @Getter
    @Setter
    @Column( name = "up" )
    private boolean up;

    public Vote(){

    }
    public Vote(Vote vote){
        this.setUp(vote.isUp());
    }

    /*@ManyToOne( cascade = CascadeType.PERSIST )
    @JoinColumn( name = "vote_id_user_fk", insertable = false, updatable = false )
    private Utilisateur user_vote;

    @ManyToOne( cascade = CascadeType.PERSIST )
    @JoinColumn( name = "vote_id_message_fk", insertable = false, updatable = false )
    private Message vote_message;*/

}
