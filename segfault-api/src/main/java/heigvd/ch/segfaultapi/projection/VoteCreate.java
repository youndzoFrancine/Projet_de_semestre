package heigvd.ch.segfaultapi.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class VoteCreate {

    @Getter
    private Integer utilisateurID;

    @Getter
    private Integer messageID;

    @Getter
    private Boolean upVote;

}
