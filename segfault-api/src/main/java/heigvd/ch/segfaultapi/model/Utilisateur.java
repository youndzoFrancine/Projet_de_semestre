package heigvd.ch.segfaultapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

/**
 * The type Utilisateur.
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "utilisateur_id")
    private Integer utilisateurID;

    @Column(name = "nom_utilisateur")
    @Getter
    @Setter
    private String nomUtilisateur;

    @Column(name = "mail_utilisateur")
    @Getter
    @Setter
    private String mailUtilisateur;

    @Column(name = "mot_de_passe")
    @Getter
    @Setter
    @JsonIgnore // Cacher mot de passe
    private String motDePasse;

/*    @Column(name = "role_utilisateur")
    @Getter
    @Setter
    private int roleUtilisateur;*/

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(
            name = "Appartient",
            joinColumns = @JoinColumn(name ="departement_id"),
            inverseJoinColumns = @JoinColumn(name = "utilisateur_id")
    )
    private Set<Departement> departementSet;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "role_utilisateur", referencedColumnName = "role_id")
    private Role role;

    @Getter
    @Setter
    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnore
    private Set<Vote> voteSet;
/*
    @Getter
    @Setter
    @ManyToMany
    @JoinTable(
            name = "Vote",
            joinColumns = @JoinColumn(name ="utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "message_id")
    )
    private Set<Message> messageSet;
*/


}
