package heigvd.ch.segfaultapi.model;

import lombok.Getter;

import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "Roles")
public class Role {
    /*@Getter
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
    }*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "role_id")
    private Integer roleID;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    @Column(name = "nom_role")
    private RoleName nomRole;

    public Role() {}

    public Role(RoleName name) {
        this.nomRole = name;
    }




}
