package com.pro.forum.model;

import javax.persistence.*;


// https://www.developpez.net/forums/d899963/java/general-java/persistance/hibernate/annotations-manytomany-1-classe-2-tables-infos-table-jointure/


@Entity
@Table( name = "VOTE" )
public class Vote {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column( name = "VOTE_UP" )
    private boolean up;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "USERID", referencedColumnName = "ID")
    private User user_vote;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "MESSAGEID", referencedColumnName = "ID")
    private Message vote_message;

}
