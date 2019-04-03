package com.pro.forum.controller;


import com.pro.forum.model.Departement;
import com.pro.forum.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartementController {

    @Autowired
    DepartementRepository repository;

    @GetMapping("/departement")
    public List<Departement> showAllDepartement() {
        System.out.println("Get all tags...");

        List<Departement> departements = new ArrayList<>();
        repository.findAll().forEach(departements::add);

        return departements;
    }

/*    @GetMapping("/tag")
    public Tag showBestRatedTag(@PathVariable("id") long id) {
        System.out.println("Get all tags...");

        Tag _tag = repository.findBestRatedTag(id);

        return _tag;
    }*/

    @PostMapping("/departement")
    public Departement addDepartement(@RequestBody Departement dep) {

        Departement _tag = repository.save( new Departement(dep.getNomDepartement()) );
        return _tag;
    }

    @DeleteMapping("/departement/{id}")
    public ResponseEntity<String> deleteDepartement(@PathVariable("id") long id) {
        System.out.println("Delete departement with ID = " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<>("departement has been deleted!", HttpStatus.OK);
    }
}
