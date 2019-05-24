package heigvd.ch.segfaultapi.projection;

import heigvd.ch.segfaultapi.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

/**
 * Cette classe est le modèle à deserialize pour créer une discussion
 */
//@AllArgsConstructor
public class DiscussionCreate {

    @Getter
    @Setter
    private String sujet;

    @Getter
    @Setter
    private String contenu;

    @Getter
    @Setter
    private Integer utilisateurID;

    @Getter
    @Setter
    private List<Integer> tags;

    // TODO: 2019-05-15 Ajouter le tagSet 

}
