package heigvd.ch.segfaultapi.projection;

import lombok.Getter;
import lombok.Setter;
/**
 * Created on 22.05.19.
 *
 * @author Max
 */
public class UserUpdate {

    @Getter
    @Setter
    private String newUsername;

    @Getter
    @Setter
    private String newPass;

    @Getter
    @Setter
    private Integer newRoleId;
}
