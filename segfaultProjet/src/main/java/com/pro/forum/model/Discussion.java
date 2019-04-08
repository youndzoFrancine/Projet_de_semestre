package com.pro.forum.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table( name = "discussion" )
public class Discussion {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "discussionid" )
    private Long discussionID;

    @Column(name = "sujet")
    private String sujet;

    @Column(name = "msgracineid")
    private int msgRacineID;

    @OneToOne  // Pour representer la relation de composition entre discussion et message
    @JoinColumn(name = "MESSAGE_ID_FK")
    Message messageDeDiscussion ;

    @ManyToMany( mappedBy = "listeDiscussion" )   // nous précision dans l’annotation que le lien est mappé avec l’attribut listeDiscussion qui sera définie dans la classe Tag
    private Set<Tag> listeTag = new HashSet<>();


    @ManyToOne
    @JoinColumn( name = "user_ID_FK" )
    private User user_discussion;

    public Discussion(){

    }

    public Discussion(String sujet, int msgRacineID){
        this.sujet = sujet;
        this.msgRacineID = msgRacineID;
    }

    public String getSujet() {
        return sujet;
    }

    public int getMsgRacineID() {
        return msgRacineID;
    }

    public Set<Tag> getListeTag() {
        return listeTag;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setMsgRacineID(int msgRacineID) {
        this.msgRacineID = msgRacineID;
    }

    public void setListeTag(Set<Tag> listeTag) {
        this.listeTag = listeTag;
    }

}
