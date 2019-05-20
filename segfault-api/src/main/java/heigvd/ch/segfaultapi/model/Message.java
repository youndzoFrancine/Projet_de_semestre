package heigvd.ch.segfaultapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.xml.bind.v2.TODO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
/**
 * The type Message.
 */
@NoArgsConstructor
@Entity
@Table (name = "Message")
public class Message {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Integer id;

    @Setter
    @Getter
    @Column(name = "contenu")
    @NonNull
    private String text;

    @Getter
    @Setter
    @Column(name = "score")
    //@NonNull //Il mettait un warning :o ?
    private int score = 0;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="Europe/Paris")
    @Getter
    @Setter
    @Column(name = "date_creation")
    private LocalDateTime date;

    @Getter
    @Setter
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "super_message_id", referencedColumnName = "message_id")
    private Message superMessageId; // Todo, is it worth using?

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(
            name = "Message_Family",
            joinColumns = @JoinColumn(name ="message_parent"),
            inverseJoinColumns = @JoinColumn(name = "message_fils")
    )
    private Set<Message> childMsg;

    @Getter
    @Setter
    @JsonIgnore
    @OneToMany(mappedBy = "message")
    private Set<Vote> voteSet;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "utilisateur_id")
    private Utilisateur author;

    // TODO: 2019-04-04 Corriger les attributs qui sont des relations 


}
