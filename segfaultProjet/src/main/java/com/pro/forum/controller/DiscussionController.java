package com.pro.forum.controller;

import com.pro.forum.model.Discussion;
import com.pro.forum.repository.DiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class DiscussionController {

    @Autowired
    DiscussionRepository repository;

    @GetMapping("/discussion")
    public List<Discussion> showAllDiscussion() {
        System.out.println("Get all Discussion...");

        List<Discussion> disc = new ArrayList<>();
        repository.findAll().forEach(disc::add);

        return disc;
    }

/*    @GetMapping("/tag")
    public Tag showBestRatedTag(@PathVariable("id") long id) {
        System.out.println("Get all tags...");

        Tag _tag = repository.findBestRatedTag(id);

        return _tag;
    }*/

    @PostMapping("/discussion")
    public Discussion addTag(@RequestBody Discussion disc) {

        Discussion _disc = repository.save( new Discussion(disc.getSujet(), disc.getMsgRacineID()) );
        return _disc;

    }

    @DeleteMapping("/discussion/{id}")
    public ResponseEntity<String> deleteTag(@PathVariable("id") long id) {
        System.out.println("Delete user with ID = " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<>("user has been deleted!", HttpStatus.OK);
    }
}
