package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "Utilisateur")
public class Utilisateur {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer utilisateurId;

   // @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    @Column(name = "nom_utilisateur")
    private String nom_utilisateur;

    @Getter
    @Column(name = "mail_utilisateur")
    private String mail_utilisateur;


    @Column(name = "mot_de_passe")
   // @Size(min = 8, message="Minimum password lenght: 6 characters")
    private String mot_de_passe;

    @Getter
    private Integer  roleUtilisateur;

   // @OneToMany(cascade = CascadeType.ALL, mappedBy = "Role"
  // )
   // @JoinColumn(name="role_id")
   // private Set<Role> roles;

    /**
     *
     * @param nom_utilisateur
     * @param mail_utilisateur
     * @param mot_de_passe
     */
    public Utilisateur ( String nom_utilisateur, String mail_utilisateur, String mot_de_passe,Integer role_utilisateur){
        this.nom_utilisateur=nom_utilisateur;
        this.mail_utilisateur=mail_utilisateur;
        this.mot_de_passe=mot_de_passe;
        this.roleUtilisateur=role_utilisateur;


    }

    public Integer getUtilisateurId() {
        return utilisateurId;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public Integer getRoleUtilisateur() {
        return roleUtilisateur;
    }

    public String getMail_utilisateur() {
        return mail_utilisateur;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setRoleUtilisateur(Integer roleUtilisateur) {
        this.roleUtilisateur = roleUtilisateur;
    }

    public void setUtilisateurId(Integer utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public void setMail_utilisateur(String mail_utilisateur) {
        this.mail_utilisateur = mail_utilisateur;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }
}