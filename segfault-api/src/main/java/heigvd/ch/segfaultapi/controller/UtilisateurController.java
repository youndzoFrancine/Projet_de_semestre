package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Role;
import heigvd.ch.segfaultapi.model.Utilisateur;
import heigvd.ch.segfaultapi.model.request.LoginForm;
import heigvd.ch.segfaultapi.model.request.SignUpForm;
import heigvd.ch.segfaultapi.projection.UserUpdate;
import heigvd.ch.segfaultapi.repositories.RoleRepoitory;
import heigvd.ch.segfaultapi.repositories.UtilisateurRepository;
import heigvd.ch.segfaultapi.security.jwt.JwtProvider;
import heigvd.ch.segfaultapi.security.jwt.JwtResponse;
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
import java.util.List;
import java.util.Optional;

/**
 * The type Utilisateur controller.
 */
@RestController
@RequestMapping("utilisateurs")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UtilisateurController {

    /**
     * The Authentication manager.
     */
    @Autowired
    AuthenticationManager authenticationManager;
    /**
     * The User repository.
     */
    @Autowired
    UtilisateurRepository userRepository;
    /**
     * The Role repository.
     */
    @Autowired
    RoleRepoitory roleRepository;
    /**
     * The Encoder.
     */
    @Autowired
    PasswordEncoder encoder;
    /**
     * The Jwt provider.
     */
    @Autowired
    JwtProvider jwtProvider;
    private UtilisateurRepository utilisateurRepository;

    /**
     * Instantiates a new Utilisateur controller.
     *
     * @param utilisateurRepository the utilisateur repository
     */
    @Autowired
    public UtilisateurController (UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    /**
     * Authenticate user response entity.
     *
     * @param loginRequest the login request
     * @return the response entity
     */
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Utilisateur utilisateur = null;
        if(userRepository.existsByMailUtilisateur(loginRequest.getMailUtilisateur())) {
            utilisateur = userRepository.findByMailUtilisateur(loginRequest.getMailUtilisateur());
        }
        else
            return new ResponseEntity<String>("Fail -> this email don't exist!",
                    HttpStatus.BAD_REQUEST);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        utilisateur.getNomUtilisateur(),
                        loginRequest.getMotDePasse()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);

        return new ResponseEntity<>(new JwtResponse(jwt, utilisateur), HttpStatus.ACCEPTED);
    }

    /**
     * Register user response entity.
     *
     * @param signUpRequest the sign up request
     * @return the response entity
     */
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {

        // verifie si un nom d'utilisateur n'existe pas deja dans la base des donnees
        if(userRepository.existsByNomUtilisateur(signUpRequest.getNomUtilisateur())) {

            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }

        // verifie si un mail utilisateur n'existe pas deja dans la base des donnees
        if(userRepository.existsByMailUtilisateur(signUpRequest.getMailUtilisateur())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }
        // verifie si le format email utilisateur est correct
        String adr = signUpRequest.getMailUtilisateur();
        String str[] = adr.split("@");

        if(!str[1].matches("heig-vd.ch")) {
            return new ResponseEntity<String>("Fail -> Email extension must be heig-vd.ch!",
                    HttpStatus.BAD_REQUEST);
        }

        // creation d'un user
        Utilisateur user = new Utilisateur();
/*
        signUpRequest.getNomUtilisateur(),
                signUpRequest.getMailUtilisateur(), encoder.encode(signUpRequest.getMotDePasse())
*/
        user.setNomUtilisateur(signUpRequest.getNomUtilisateur());
        user.setMailUtilisateur(signUpRequest.getMailUtilisateur());
        user.setMotDePasse( encoder.encode(signUpRequest.getMotDePasse()));

        Role role = roleRepository.findByNomRole("Etudiant").get();

        user.setRole(role);
        userRepository.save(user);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getNomUtilisateur(),
                        signUpRequest.getMotDePasse()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);

        return new ResponseEntity<>(new JwtResponse(jwt, user), HttpStatus.CREATED);
    }


    /**
     * Gets all users.
     *
     * @return the all
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Utilisateur> getAll () {
        return utilisateurRepository.findAll();
    }

    /**
     * Create list.
     *
     * @param utilisateur the utilisateur
     * @return the list
     */
    // todo plus utile
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Utilisateur> create (@RequestBody Utilisateur utilisateur) {

        utilisateurRepository.save(utilisateur);

        return utilisateurRepository.findAll();
    }

    /**
     * Cette méthode retourne une liste de tous les Utilisateurs qui
     * commencent par un nom donné
     *
     * @param nom the nom
     * @return starting with
     */
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public List<Utilisateur> getStartingWith (@RequestParam("nom") String nom) {
        System.out.print(nom);

        return utilisateurRepository.findBynomUtilisateurStartingWith(nom);
    }

    /**
     * Update user response entity.
     *
     * @param id          the id
     * @param utilisateur the utilisateur
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Integer id, @RequestBody UserUpdate utilisateur) {
        System.out.println("Update user with ID = " + id + "...");

        Optional<Utilisateur> users;
        users = utilisateurRepository.findByUtilisateurID(id);
        Utilisateur userUpdate = users.get();

        if(users == null){
            return new ResponseEntity("user id: "+ id +" doesn't exist", HttpStatus.BAD_REQUEST);
        }
        if(userRepository.existsByNomUtilisateur(utilisateur.getNewUsername())) {
            return new ResponseEntity("username already exists", HttpStatus.BAD_REQUEST);
        }

        if( !utilisateur.getNewUsername().equals(""))
            userUpdate.setNomUtilisateur(utilisateur.getNewUsername());

        if(!utilisateur.getNewPass().equals(""))
            userUpdate.setMotDePasse(utilisateur.getNewPass());

        Role role = roleRepository.findByRoleID(utilisateur.getNewRoleId()).get();

        userUpdate.setRole(role);

        utilisateurRepository.save(userUpdate);

        return new ResponseEntity<>("user has been updated!", HttpStatus.OK);
    }

    /**
     * Delete user response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("utilisateur_id") Integer id) {
        System.out.println("Delete user with ID = " + id + "...");

        utilisateurRepository.deleteById(id);

        return new ResponseEntity<>("user has been deleted!", HttpStatus.OK);
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public Optional<Utilisateur> getById (@PathVariable("id") Integer id) {
        return utilisateurRepository.findById(id);
    }
}
