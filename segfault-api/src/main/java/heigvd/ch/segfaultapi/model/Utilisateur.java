package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Entity

@Table(name = "Utilisateur")
public class Utilisateur {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

     private Long utilisateurId;

     private String nomUtilisateur;

     private String mailUtilisateur;

     private String motDePasse;




    private Long  roleUtilisateur;

    // Obligatoire pour JPA
    public Utilisateur () {
    }

    /**
     *
     * @param nomUtilisateur
     * @param mailUtilisateur
     * @param motDePasse
     */
    public Utilisateur ( String nomUtilisateur, String mailUtilisateur, String motDePasse){
        this.nomUtilisateur=nomUtilisateur;
        this.mailUtilisateur=mailUtilisateur;
        this.motDePasse=motDePasse;


    }

    /**
     *
     * @param roleUtilisateur
     */
    public void setRoleUtilisateur(Long roleUtilisateur) {
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
