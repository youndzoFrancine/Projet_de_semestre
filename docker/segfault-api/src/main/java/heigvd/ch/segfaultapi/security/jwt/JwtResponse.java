package heigvd.ch.segfaultapi.security.jwt;

import heigvd.ch.segfaultapi.model.Utilisateur;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Jwt response.
 */
public class JwtResponse {

    @Getter
    @Setter
    private String token;

    @Getter
    @Setter
    private Utilisateur user;

    /**
     * Instantiates a new Jwt response.
     *
     * @param accessToken the access token
     */
    public JwtResponse(String accessToken, Utilisateur user) {
        this.token = accessToken;
        this.user = user;
    }

}