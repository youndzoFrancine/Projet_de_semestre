package heigvd.ch.segfaultapi.api;

import heigvd.ch.segfaultapi.model.Discussion;

import java.util.ArrayList;
import java.util.List;

public class DiscussionController {
    private List<Discussion> discussions;

    public DiscussionController () {
        discussions = new ArrayList<>();

        discussions.add(new Discussion("Comment on installe Docker ?"));
        discussions.add(new Discussion("Quelqu'un a compris le labo de RES?"));
    }
}
