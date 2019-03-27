package heigvd.ch.segfaultapi.model;

import lombok.Getter;

import javax.persistence.*;

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

    // Obligatoire pour JPA
    public Utilisateur () {}

    /**
     *
     * @param utilisateurId
     * @param nomUtilisateur
     * @param mailUtilisateur
     * @param motDePasse
     */
    public Utilisateur (String nomUtilisateur, String mailUtilisateur,String motDePasse) {
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
