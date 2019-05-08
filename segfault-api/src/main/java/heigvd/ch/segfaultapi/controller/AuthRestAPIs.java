package heigvd.ch.segfaultapi.controller;


import heigvd.ch.segfaultapi.model.Role;
import heigvd.ch.segfaultapi.model.RoleName;
import heigvd.ch.segfaultapi.model.Utilisateur;
import heigvd.ch.segfaultapi.model.request.LoginForm;
import heigvd.ch.segfaultapi.model.request.SignUpForm;
import heigvd.ch.segfaultapi.model.response.JwtResponse;
import heigvd.ch.segfaultapi.repositories.RoleRepository;
import heigvd.ch.segfaultapi.repositories.UtilisateurRepository;
import heigvd.ch.segfaultapi.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UtilisateurRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Utilisateur username = null;
        if(userRepository.existsByMailUtilisateur(loginRequest.getMailUtilisateur())) {
            username = userRepository.findByMailUtilisateur(loginRequest.getMailUtilisateur());
        }
        else
            return new ResponseEntity<String>("Fail -> this email don't exist!",
                    HttpStatus.BAD_REQUEST);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username.getNomUtilisateur(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {

        if(userRepository.existsByNomUtilisateur(signUpRequest.getNomUtilisateur())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByMailUtilisateur(signUpRequest.getMailUtilisateur())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        Utilisateur user = new Utilisateur(signUpRequest.getNomUtilisateur(),
                signUpRequest.getMailUtilisateur(), encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
        	switch(role) {
	    		case "ADMIN":
	    			Role adminRole = roleRepository.findByNomRole(RoleName.ADMIN)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	    			roles.add(adminRole);
	    			
	    			break;
	    		case "ETUDIANT":
	            	Role etudiantRole = roleRepository.findByNomRole(RoleName.ETUDIANT)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(etudiantRole);
	            	
	    			break;

                case "ASSISTANT":
                    Role assistantRole = roleRepository.findByNomRole(RoleName.ASSISTANT)
                        .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(assistantRole);

                case "PROFESSEUR":
                    Role pmRole = roleRepository.findByNomRole(RoleName.PROFESSEUR)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(pmRole);

                break;
	    		default:
	        		Role userRole = roleRepository.findByNomRole(RoleName.ETUDIANT)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(userRole);
        	}
        });
        
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok().body("User registered successfully!");
    }
}