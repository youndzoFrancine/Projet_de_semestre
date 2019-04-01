package com.pro.forum.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "utilisateur ")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilisateurid")
    private Long utilisateurID;

    @Column(name = "nomutilisateur")
    private String nomUtilisateur;

    @Column(name = "mailutilisateur")
    private String mailUtilisateur;

    @Column(name = "motdepasse")
    private String motDePasse;

    @Column(name = "roleutilisateur")
    private int roleUtilisateur;

    @Transient
    private String passwordConfirm;

    @ManyToMany
    @JoinTable( name = "JoinUserDepartement",
            joinColumns        = @JoinColumn( name = "valeur_join" ),
            inverseJoinColumns = @JoinColumn( name = "discussionid_FK" )
    )
    private Set<Departement> listeDepartement = new HashSet<>();

    @OneToMany
    @JoinColumn( name = "user_ID_FK")
    private List< Discussion > listeDiscussion;


    public User(User users){ }

    public User(String mailUtilisateur, String motDePasse){
        this.mailUtilisateur = mailUtilisateur;
        this.motDePasse = motDePasse;
    }
    public User(String nomUtilisateur, String mailUtilisateur, String motDePasse, String confirmMotdepasse){
        this(mailUtilisateur, motDePasse);
        this.nomUtilisateur = nomUtilisateur;
    }

    public User() {

    }

    public Long getUtilisateurID() {
        return utilisateurID;
    }

    public void setUtilisateurID(Long utilisateurID) {
        this.utilisateurID = utilisateurID;
    }

    public String getUserEmail() {
        return mailUtilisateur;
    }

    public void setUserEmail(String mailUtilisateur) {
        this.mailUtilisateur = mailUtilisateur;
    }

    public String getUsername() {
        return nomUtilisateur;
    }

    public void setUsername(String username) {
        this.nomUtilisateur = username;
    }

    public String getPassword() {
        return motDePasse;
    }

    public void setPassword(String password) {
        this.motDePasse = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }


    @Override
    public String toString() {
        return "Customer [id=" + utilisateurID + ", name=" + nomUtilisateur + ", mailUtilisateur=" + mailUtilisateur + ", role=" + roleUtilisateur + "]";
    }

}