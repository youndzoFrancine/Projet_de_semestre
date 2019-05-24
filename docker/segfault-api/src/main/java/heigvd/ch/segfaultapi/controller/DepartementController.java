package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Departement;
import heigvd.ch.segfaultapi.model.Utilisateur;
import heigvd.ch.segfaultapi.repositories.DepartementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * The type Departement controller.
 */
@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("departements")
public class DepartementController {

    /**
     * The constant logger.
     */
    public static final Logger logger = LoggerFactory.getLogger(DepartementController.class);

    //@Autowired
    //UserService userService; //Service which will do all data retrieval/manipulation work


    private DepartementRepository departementRepository;

    /**
     * Instantiates a new Departement controller.
     *
     * @param departementRepository the departement repository
     */
    @Autowired
    DepartementController(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Departement>> getAll() {
        List<Departement> departements = departementRepository.findAll();
        if (departements.isEmpty()) {
            /*no content return status 204*/
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        /*no content return status 200*/
        return new ResponseEntity<List<Departement>>(departements, HttpStatus.OK);
    }


    /**
     * Create list.
     *
     * @param departement the departement
     * @return the list
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Departement> create(@RequestBody Departement departement) {

        // todo verify it doesn't exist already
        for (Departement departement1 : departementRepository.findAll()) {
            if (departement.equals(departement1)) {
                return departementRepository.findAll();
            }
        }


        departementRepository.save(departement);
        return departementRepository.findAll();

    }

    /**
     * Delete list.
     *
     * @param id the id
     * @return the list
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public List<Departement> delete(@PathVariable("id") Integer id) {
        departementRepository.deleteById(id);
        return departementRepository.findAll();
    }

}
