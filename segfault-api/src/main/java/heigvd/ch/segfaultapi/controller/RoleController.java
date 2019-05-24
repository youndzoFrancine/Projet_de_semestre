package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Role;
import heigvd.ch.segfaultapi.repositories.RoleRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Role controller.
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleRepoitory roleRepoitory;

    /**
     * Gets all.
     *
     * @return the all
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Role> getAll() {

        return roleRepoitory.findAll();
    }
}
