package heigvd.ch.segfaultapi.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor
public class MessageReponse {

    @Getter
    @Setter
    private String contenu;

    @Getter
    @Setter
    private Integer utilisateurID;

    @Getter
    @Setter
    private Integer messageID;
}
