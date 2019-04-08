package heigvd.ch.segfaultapi.model;

import heigvd.ch.segfaultapi.model.Utilisateur;
import lombok.Getter;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "Roles")
public class Role {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleID;

    @Column(name = "nomRole")
    @NonNull
    private String nomRole;

    @ManyToMany(mappedBy = "roles")
    private Set<Utilisateur> utilisateurs;

    public Role(String nomRole){
        this.nomRole=nomRole;
    }

    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }

    public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
