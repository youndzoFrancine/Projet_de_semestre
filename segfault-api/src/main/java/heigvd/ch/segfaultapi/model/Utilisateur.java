package heigvd.ch.segfaultapi.model;

import heigvd.ch.segfaultapi.model.Role;
import lombok.Getter;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "Utilisateur")
public class Utilisateur {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "utilisateurid")
    @NonNull
    private Long utilisateurId;

    @Column(name = "nomutilisateur")
    @NonNull
    private String nomUtilisateur;

    @Column(name = "mailutilisateur")
    @NonNull
    private String mailUtilisateur;

    @Column(name = "motdepasse")
    @NonNull
    private String motDePasse;

    @ManyToMany
    private Role roleUtilisateur;


    /**
     *
     * @param nomUtilisateur
     * @param mailUtilisateur
     * @param motDePasse
     */
    public Utilisateur ( String nomUtilisateur, String mailUtilisateur, String motDePasse,Role roleUtilsateur){
        this.nomUtilisateur=nomUtilisateur;
        this.mailUtilisateur=mailUtilisateur;
        this.motDePasse=motDePasse;
        this.nomUtilisateur = nomUtilisateur;


    }

    /**
     *
     * @param roleUtilisateur
     */
    public void setRoleUtilisateur(Role roleUtilisateur) {
        this.roleUtilisateur = roleUtilisateur;
    }


    /**
     *
     * @param utilisateurId
     */
    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }



    /**
     *
     * @param nomUtilisateur
     */
    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }


    /**
     *
     * @param motDePasse
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }


    /**
     *
     * @param mailUtilisateur
     */
    public void setMailUtilisateur(String mailUtilisateur) {
        this.mailUtilisateur = mailUtilisateur;
    }
}