package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Role;
import heigvd.ch.segfaultapi.repositories.RoleRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleRepoitory roleRepoitory;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Role> getAll() {

        return roleRepoitory.findAll();
    }
}
