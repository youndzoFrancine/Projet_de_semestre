package heigvd.ch.segfaultapi.api;

import heigvd.ch.segfaultapi.model.Discussion;
import heigvd.ch.segfaultapi.repositories.DiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("discussions")
public class DiscussionController {
    //private List<Discussion> discussions;

    private DiscussionRepository discussionRepository;

    @Autowired
    public DiscussionController (DiscussionRepository discussionRepository) {
        this.discussionRepository = discussionRepository;
//        discussions = new ArrayList<>();
//
//        discussions.add(new Discussion("Comment on installe Docker ?"));
//        discussions.add(new Discussion("Quelqu'un a compris le labo de RES?"));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Discussion> getAll () {
        return discussionRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Discussion> create (@RequestBody Discussion discussion) {

        discussionRepository.save(discussion);

        return discussionRepository.findAll();
    }
}
