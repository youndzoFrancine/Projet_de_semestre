package heigvd.ch.segfaultapi.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignUpForm {

    @NotBlank
    @Size(min=3, max = 50)
    @Getter
    @Setter
    private String nomUtilisateur;

    @NotBlank
    @Size(max = 50)
    @Getter
    @Setter
    @Email
    private String mailUtilisateur;

    @NotBlank
    @Size(min=6, max = 100)
    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private Set<String> role;

}