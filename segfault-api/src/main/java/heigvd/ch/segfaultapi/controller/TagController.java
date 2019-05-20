package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Tag;
import heigvd.ch.segfaultapi.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("tags")
public class TagController {

    private TagRepository tagRepository;

    @Autowired
    TagController (TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Tag> getAll() {
    /*    List<Tag> tags = new ArrayList<>();
        tagRepository.findAll().forEach(tags::add);*/

        return tagRepository.findAll();
    }

/*    @GetMapping("/tag")
    public Tag showBestRatedTag(@PathVariable("id") long id) {
        System.out.println("Get all tags...");

        Tag _tag = repository.findBestRatedTag(id);

        return _tag;
    }*/



    @PostMapping(value = "create")
    public ResponseEntity<?> create (@RequestBody Tag tag) {

        if (!tagRepository.findAllByNom(tag.getNom()).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }

        tagRepository.save(tag);

        return new ResponseEntity<>(tag.getId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public List<Tag> delete (@PathVariable("id") Integer id) {
        tagRepository.deleteById(id);

        return tagRepository.findAll();
    }

/*    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTag(@PathVariable("id") long id) {
        System.out.println("Delete user with ID = " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<>("user has been deleted!", HttpStatus.OK);
    }*/

}
