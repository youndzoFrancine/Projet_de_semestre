package heigvd.ch.segfaultapi.projection;

import heigvd.ch.segfaultapi.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

/**
 * Cette classe est le modèle à deserialize pour créer une discussion
 */
@AllArgsConstructor
public class DiscussionCreate {

    @Getter
    private String sujet;

    @Getter
    private String contenu;

    @Getter
    private Integer utilisateurID;

    // TODO: 2019-05-15 Ajouter le tagSet 

}
