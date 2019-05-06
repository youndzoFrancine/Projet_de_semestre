package heigvd.ch.segfaultapi.model;

import com.sun.xml.bind.v2.TODO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table (name = "Message")
public class Message {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Integer messageId;

    @Getter
    @Column(name = "contenu")
    @NonNull
    private String contenu;

    @Getter
    @Setter
    @Column(name = "score")
    //@NonNull //Il mettait un warning :o ?
    private int score = 0;

    @Getter
    @JoinColumn(name ="utilisateur_id") // Nécessaire au lieu de Colum car lien
    @OneToOne(fetch = FetchType.LAZY,
            targetEntity = Discussion.class)
    private Integer discussionId;

    @Getter
    @JoinColumn(name = "super_message_id")
    @OneToOne(targetEntity = Message.class)
    private Integer superMessageId;

    // TODO: 2019-04-04 Corriger les attributs qui sont des relations 
    
/*    //@OneToOne
    @Getter
    @Column(name = "utilisateurId")
    //@NonNull
    private Long utilisateurId;*/

    public Message(String contenu, Integer discussionId) {
        this.contenu = contenu;
        this.discussionId = discussionId;
    }


/*public Message(Long utilisateurId, Long discussionId, String message, Long messageParentId){
        this( utilisateurId, discussionId, message);
        this.superMessageId = messageParentId;
    }*/

}
