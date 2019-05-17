package heigvd.ch.segfaultapi.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class MessageReponse {

    @Getter
    private String contenu;

    @Getter
    private Integer utilisateurID;

    @Getter
    private Integer messageID;
}
