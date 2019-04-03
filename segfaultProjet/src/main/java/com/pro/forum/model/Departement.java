package com.pro.forum.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "departement" )
public class Departement {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "departementid" )
    private Long departementID;

    @Column( name = "nomdepartement" )
    private String nomDepartement;


    @ManyToMany( mappedBy = "listeDepartement" )
    private Set<User> listeUser = new HashSet<>();

    public Departement(){

    }
    public Departement(String nomDepartement){
        this.nomDepartement = nomDepartement;
    }
    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }
}
