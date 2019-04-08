package heigvd.ch.segfaultapi.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long roleId;

    @Getter
    private String nomRole;

    @ManyToMany(mappedBy = "role")
    private Utilisateur utilisateur;

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
