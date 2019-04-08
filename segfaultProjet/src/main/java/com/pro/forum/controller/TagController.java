package com.pro.forum.controller;

import com.pro.forum.model.Tag;
import com.pro.forum.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TagController {


    @Autowired
    TagRepository repository;

    @GetMapping("/tag")
    public List<Tag> showAllTag() {
        System.out.println("Get all tags...");

        List<Tag> tags = new ArrayList<>();
        repository.findAll().forEach(tags::add);

        return tags;
    }

/*    @GetMapping("/tag")
    public Tag showBestRatedTag(@PathVariable("id") long id) {
        System.out.println("Get all tags...");

        Tag _tag = repository.findBestRatedTag(id);

        return _tag;
    }*/

    @PostMapping("/tag")
    public Tag addTag(@RequestBody Tag tag) {

        Tag _tag = repository.save( new Tag( tag.getValeur(),tag.isPrioritaire(),tag.getRang()) );
        return _tag;
    }

    @DeleteMapping("/tag/{id}")
    public ResponseEntity<String> deleteTag(@PathVariable("id") long id) {
        System.out.println("Delete user with ID = " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<>("user has been deleted!", HttpStatus.OK);
    }


}
