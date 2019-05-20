package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * The type Role.
 */
@NoArgsConstructor
@Entity
@Table(name = "Roles")
public class Role {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleID;

    @Getter
    @NonNull
    @Column(name = "nom_role")
    private String nomRole;

    //@ManyToMany(mappedBy = "roles")
    //private Set<Utilisateur> utilisateurs;

    /**
     * Instantiates a new Role.
     *
     * @param nomRole the nom role
     */
    public Role(String nomRole){
        this.nomRole=nomRole;
    }

    /**
     * Sets nom role.
     *
     * @param nomRole the nom role
     */
    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }


}
