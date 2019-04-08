package heigvd.ch.segfaultapi.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    public Role(String nomRole){
        this.nomRole=nomRole;
    }

    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }


}
