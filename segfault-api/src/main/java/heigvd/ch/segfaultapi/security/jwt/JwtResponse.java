package heigvd.ch.segfaultapi.security.jwt;

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
    private String type = "Bearer";

    /**
     * Instantiates a new Jwt response.
     *
     * @param accessToken the access token
     */
    public JwtResponse(String accessToken) {
        this.token = accessToken;
    }

}