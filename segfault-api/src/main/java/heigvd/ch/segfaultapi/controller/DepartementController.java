package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Departement;
import heigvd.ch.segfaultapi.repositories.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departements")
public class DepartementController {

    private DepartementRepository departementRepository;

    @Autowired
    DepartementController(DepartementRepository departementRepository){
        this.departementRepository = departementRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Departement> getAll() {
        return departementRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Departement> create (@RequestBody Departement departement) {
        departementRepository.save(departement);
        return departementRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public List<Departement> delete (@PathVariable("id") Integer id) {
        departementRepository.deleteById(id);
        return departementRepository.findAll();
    }

}
