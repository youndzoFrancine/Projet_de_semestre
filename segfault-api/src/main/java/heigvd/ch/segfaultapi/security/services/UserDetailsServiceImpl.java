package heigvd.ch.segfaultapi.security.services;


import heigvd.ch.segfaultapi.model.Utilisateur;
import heigvd.ch.segfaultapi.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The type User details service.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * The User repository.
     */
    @Autowired
    UtilisateurRepository userRepository;

    /**
     * Load user by username user details.
     *
     * @param username the username
     * @return the user details
     * @throws UsernameNotFoundException the email not found exception
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Utilisateur user = userRepository.findByNomUtilisateur(username)
                	.orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with ->  email : " + username)
        );

        return UserPrinciple.build(user);
    }
}