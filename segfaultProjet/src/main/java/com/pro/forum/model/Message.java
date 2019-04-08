package com.pro.forum.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Message")
public class Message {


    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "messageId")
    @NonNull
    private Long messageId;

    @Getter
    @Column(name = "message")
    @NonNull
    private String message;

    @Getter
    @Setter
    @Column(name = "score")
    @NonNull
    private int score = 0;

    @Getter
    @Column(name = "discussionId")
    @NonNull
    private Long discussionId;

    @Getter
    @Column(name = "superMessageId")
    @NonNull
    private Long superMessageId;

    @Getter
    @Column(name = "utilisateurId")
    @NonNull
    private Long utilisateurId;


    @OneToOne( mappedBy = "messageDeDiscussion" )  // mappage entre discussion et message
    private Discussion discussionMessage;

    @OneToOne  // mappage de , un messgae repond a "0..1" message
    @JoinColumn( name = "MESSAGE_ID_FK" )
    private Message messageOwnMessage;

    @ManyToOne
    @JoinColumn( name = "user_ID_FK" )
    private User user_message;

    // lien entre message et vote de l'association user-vote-message
    @OneToMany(mappedBy = "vote_message")
    private List<Vote> message_lien_user;


    public Message() {
    }

    public Message(String message, Long utilisateurId, Long discussionId) {
        this.utilisateurId = utilisateurId;
        this.discussionId = discussionId;
        this.message = message;
    }




}