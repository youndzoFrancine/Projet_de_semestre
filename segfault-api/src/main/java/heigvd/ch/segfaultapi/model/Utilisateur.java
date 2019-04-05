package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;

@Entity

@Table(name = "Utilisateur")
public class Utilisateur {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    //@Column(name = "utilisateurId")
    //@NonNull
     private Long utilisateurId;

    //@Column(name = "nomUtilisateur")
    //@NonNull
     private String nomUtilisateur;

    //@Column(name = "mailUtilisateur")
    //@NonNull
     private String mailUtilisateur;

    //@Column(name = "motDePasse")
    //@NonNull
     private String motDePasse;

    //@Column(name = "roleUtilisateur")
    //@NonNull
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
     * @return
     */
   public Long getUtilisateurId(){
        return utilisateurId;
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
     * @return
     */
    public String getNomUtilisateur(){
        return nomUtilisateur;
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
     * @return
     */
   public String getMotDePasse(){
        return motDePasse;
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
     * @return
     */
    public String getMailUtilisateur(){
        return mailUtilisateur;
    }

    /**
     *
     * @param mailUtilisateur
     */
    public void setMailUtilisateur(String mailUtilisateur) {
        this.mailUtilisateur = mailUtilisateur;
    }
}
