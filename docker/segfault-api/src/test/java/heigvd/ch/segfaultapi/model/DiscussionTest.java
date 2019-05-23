package heigvd.ch.segfaultapi.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiscussionTest {

    @Test
    public void getSujet() {

        assertEquals(new Discussion("Question").getSujet(), "Question");
    }
}