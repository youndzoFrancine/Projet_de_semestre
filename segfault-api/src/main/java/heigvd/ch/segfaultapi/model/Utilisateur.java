package heigvd.ch.segfaultapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

/**
 * The type Utilisateur.
 */
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
    @Setter
    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_utilisateur", referencedColumnName = "role_id", insertable= false, updatable=false)*/
    @Column(name = "role_utilisateur")
    private Integer role;

    @Getter
    @Setter
    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnore
    private Set<Vote> voteSet;

    /**
     * Instantiates a new Utilisateur.
     */
    public Utilisateur () {
    }

    /**
     * Instantiates a new Utilisateur.
     *
     * @param nomUtilisateur  the nom utilisateur
     * @param mailUtilisateur the mail utilisateur
     * @param motDePasse      the mot de passe
     */
    public Utilisateur ( String nomUtilisateur, String mailUtilisateur, String motDePasse){
        this.nomUtilisateur=nomUtilisateur;
        this.mailUtilisateur=mailUtilisateur;
        this.motDePasse=motDePasse;
    }

}
