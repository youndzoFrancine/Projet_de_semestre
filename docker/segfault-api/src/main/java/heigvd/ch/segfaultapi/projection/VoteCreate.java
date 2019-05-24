package heigvd.ch.segfaultapi.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor
public class VoteCreate {

    @Getter
    @Setter
    private Integer utilisateurID;

    @Getter
    @Setter
    private Integer messageID;

    @Getter
    @Setter
    private Boolean upVote;

}
