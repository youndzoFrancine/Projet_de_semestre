package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * The type Departement.
 */
@NoArgsConstructor
@Entity
@Table(name = "Departement")
public class Departement {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departement_id")
    private Integer departementId;

    @Getter
    @Column(name = "nom_departement")
    private String nomDepartement;

    /*
    @ManyToMany(mappedBy = "departementSet")
    private Set<Utilisateur> utilisateurSet;
    */

    /**
     * Equals boolean.
     *
     * @param obj the obj
     * @return the boolean
     */
    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass() && nomDepartement.equals(((Departement) obj).nomDepartement);
    }

    /**
     * Instantiates a new Departement.
     *
     * @param nom_Departement the nom departement
     */
    public Departement(String nom_Departement){
        this.nomDepartement = nom_Departement;
    }
}


