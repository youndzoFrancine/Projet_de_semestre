package com.pro.forum.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

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

    public Message() {
    }

    public Message(String message, Long utilisateurId, Long discussionId) {
        this.utilisateurId = utilisateurId;
        this.discussionId = discussionId;
        this.message = message;
    }

    /*public Message(Long utilisateurId, Long discussionId, String message, Long messageParentId){
        this( utilisateurId, discussionId, message);
        this.superMessageId = messageParentId;
    }*/

}