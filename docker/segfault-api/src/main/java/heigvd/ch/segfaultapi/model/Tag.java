package heigvd.ch.segfaultapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;

@AllArgsConstructor
/**
 * The type Tag.
 */
@NoArgsConstructor
@Entity
@Table(name = "tag")
public class Tag {

    @Getter
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "tag_id" )
    private Integer id;

    @Getter
    @Column(name = "nom")
    private String nom;

    @Getter
    @Column(name = "prioritaire")
    private boolean prio;

    @Getter
    @Column(name = "rang")
    private int rank;


/*    @ManyToMany
    @JoinTable( name = "JoinDiscussionTag",
            joinColumns        = @JoinColumn( name = "valeur_join" ),
            inverseJoinColumns = @JoinColumn( name = "discussionid_FK" )
    )
    private List<Discussion> listeDiscussion = new HashSet<>();*/


/*
    public Tag(String nom, boolean prioritaire,  int rang){
        this.nom = nom;
        this.prio = prioritaire;
        this.rank = rang;
    }
*/


/*
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
*/

/*    public List<Discussion> getAllDiscussion() {
        return listeDiscussion;
    }*/
}

