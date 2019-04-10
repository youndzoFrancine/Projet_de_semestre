package heigvd.ch.segfaultapi.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Utilisateur ")
public class Utilisateur {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilisateur_id")
    private Integer utilisateurID;

    @Column(name = "nom_utilisateur")
    private String nomUtilisateur;

    @Column(name = "mail_utilisateur")
    private String mailUtilisateur;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    @Column(name = "role_utilisateur")
    private int roleUtilisateur;

    @Transient
    private String passwordConfirm;

    /*@ManyToMany
    @JoinTable( name = "JoinUserDepartement",
            joinColumns        = @JoinColumn( name = "valeur_join" ),
            inverseJoinColumns = @JoinColumn( name = "discussionid_FK" )
    )
    private Set<Departement> listeDepartement = new HashSet<>();


    @OneToMany( mappedBy = "user_discussion")   //  join de cardinalité "1..*" entre User et Discussion
    private List< Discussion > listeDiscussion;

    @OneToMany( mappedBy = "user_message")  //  join de cardinalité "1..*" entre User et Message
    private List< Message > listeMessage;*/

/*    @OneToMany(mappedBy = "user_vote")
    private List<Vote> user_lien_message;*/

    public Utilisateur(Utilisateur users){ }

    public Utilisateur(String mailUtilisateur, String motDePasse){
        this.mailUtilisateur = mailUtilisateur;
        this.motDePasse = motDePasse;
    }
    public Utilisateur(String nomUtilisateur, String mailUtilisateur, String motDePasse, String confirmMotdepasse){
        this(mailUtilisateur, motDePasse);
        this.nomUtilisateur = nomUtilisateur;
    }

    public Utilisateur() {

    }

    public Integer getUtilisateurID() {
        return utilisateurID;
    }

    public void setUtilisateurID(Integer utilisateurID) {
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