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
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "super_message_id", referencedColumnName = "message_id")
    private Message superMessageId;

    // TODO: 2019-04-04 Corriger les attributs qui sont des relations 


}
