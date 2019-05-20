package heigvd.ch.segfaultapi.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import heigvd.ch.segfaultapi.model.Utilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type User principle.
 */
public class UserPrinciple implements UserDetails {
	private static final long serialVersionUID = 1L;

    @Getter
    @Setter
	private Integer id;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    /**
     * Instantiates a new User principle.
     *
     * @param id          the id
     * @param username    the username
     * @param email       the email
     * @param password    the password
     * @param authorities the authorities
     */
    public UserPrinciple(Integer id, String username, String email, String password,
			    		Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }


    /**
     * Build user principle.
     *
     * @param user the user
     * @return the user principle
     */
    public static UserPrinciple build(Utilisateur user) {

        List<GrantedAuthority> authorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(user.getRole().toString());

        return new UserPrinciple(
                user.getUtilisateurID(),
                user.getNomUtilisateur(),
                user.getMailUtilisateur(),
                user.getMotDePasse(),
                 authorities
        );
    }


    /**
     * Gets authorities.
     *
     * @return the authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * Is account non expired boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Is account non locked boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Is credentials non expired boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Is enabled boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Equals boolean.
     *
     * @param o the o
     * @return the boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}