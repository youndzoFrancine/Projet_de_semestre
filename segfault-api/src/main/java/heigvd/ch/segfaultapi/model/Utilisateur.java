package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
    private String motDePasse;

    @Column(name = "role_utilisateur")
    @Getter
    @Setter
    private int roleUtilisateur;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(
            name = "Appartient",
            joinColumns = @JoinColumn(name ="departement_id"),
            inverseJoinColumns = @JoinColumn(name = "utilisateur_id")
    )
    private Set<Departement> departementSet;

    @Getter
    @ManyToOne
    @JoinColumn(name = "role_utilisateur", referencedColumnName = "role_id", insertable= false, updatable=false)
    private Role role;

    public Utilisateur () {
    }
}
