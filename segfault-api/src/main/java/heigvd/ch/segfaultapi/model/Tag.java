package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "tagid" )
    private Long tagId;

    @Column(name = "valeur")
    private String valeur;

    @Column(name = "prioritaire")
    private boolean prioritaire;

    @Column(name = "rang")
    private int rang;

/*    @ManyToMany
    @JoinTable( name = "JoinDiscussionTag",
            joinColumns        = @JoinColumn( name = "valeur_join" ),
            inverseJoinColumns = @JoinColumn( name = "discussionid_FK" )
    )
    private List<Discussion> listeDiscussion = new HashSet<>();*/


    public Tag(String valeur, boolean prioritaire,  int rang){
        this.valeur= valeur;
        this.prioritaire = prioritaire;
        this.rang = rang;
    }


    public String getValeur() {
        return valeur;
    }

    public boolean isPrioritaire() {
        return prioritaire;
    }

    public int getRang() {
        return rang;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public void setPrioritaire(boolean prioritaire) {
        this.prioritaire = prioritaire;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

/*    public List<Discussion> getAllDiscussion() {
        return listeDiscussion;
    }*/
}

