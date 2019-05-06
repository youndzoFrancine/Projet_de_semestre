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


    public Utilisateur () {
    }

    public Utilisateur ( String nomUtilisateur, String mailUtilisateur, String motDePasse){
        this.nomUtilisateur=nomUtilisateur;
        this.mailUtilisateur=mailUtilisateur;
        this.motDePasse=motDePasse;
    }

}
