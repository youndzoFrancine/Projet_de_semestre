package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Departement;
import heigvd.ch.segfaultapi.repositories.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("departements")
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

        // todo verify it doesn't exist already
        for (Departement departement1 : getAll()) {
            if (departement.equals(departement1)) {
                return departementRepository.findAll();
            }
        }


            departementRepository.save(departement);
            return departementRepository.findAll();

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public List<Departement> delete (@PathVariable("id") Integer id) {
        departementRepository.deleteById(id);
        return departementRepository.findAll();
    }

}
