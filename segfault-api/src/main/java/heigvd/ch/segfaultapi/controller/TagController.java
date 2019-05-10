package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Tag;
import heigvd.ch.segfaultapi.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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



    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Tag> create (@RequestBody Tag discussion) {

        tagRepository.save(discussion);

        return tagRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public List<Tag> delete (@PathVariable("id") Long id) {
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
