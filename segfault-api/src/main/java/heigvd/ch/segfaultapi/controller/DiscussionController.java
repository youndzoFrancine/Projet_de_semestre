package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Discussion;
import heigvd.ch.segfaultapi.repositories.DiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("discussions")
public class DiscussionController {

    private DiscussionRepository discussionRepository;

    @Autowired
    public DiscussionController (DiscussionRepository discussionRepository) {
        this.discussionRepository = discussionRepository;
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
