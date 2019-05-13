package heigvd.ch.segfaultapi.security.jwt;

/**
 * The type Jwt response.
 */
public class JwtResponse {
    private String token;
    private String type = "Bearer";

    /**
     * Instantiates a new Jwt response.
     *
     * @param accessToken the access token
     */
    public JwtResponse(String accessToken) {
        this.token = accessToken;
    }

    /**
     * Gets access token.
     *
     * @return the access token
     */
    public String getAccessToken() {
        return token;
    }

    /**
     * Sets access token.
     *
     * @param accessToken the access token
     */
    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    /**
     * Gets token type.
     *
     * @return the token type
     */
    public String getTokenType() {
        return type;
    }

    /**
     * Sets token type.
     *
     * @param tokenType the token type
     */
    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }
}