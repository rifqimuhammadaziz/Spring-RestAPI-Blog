package rifqimuhammadaziz.springrestapiblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rifqimuhammadaziz.springrestapiblog.model.Role;
import rifqimuhammadaziz.springrestapiblog.model.User;
import rifqimuhammadaziz.springrestapiblog.payload.JWTAuthResponse;
import rifqimuhammadaziz.springrestapiblog.payload.User.LoginDto;
import rifqimuhammadaziz.springrestapiblog.payload.User.SignUpDto;
import rifqimuhammadaziz.springrestapiblog.repository.RoleRepository;
import rifqimuhammadaziz.springrestapiblog.repository.UserRepository;
import rifqimuhammadaziz.springrestapiblog.security.JWT.JWTTokenProvider;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JWTTokenProvider tokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signIn")
    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // get token from tokenProvider
        String token = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTAuthResponse(token));
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) {
        // check if username is exists
        if (userRepository.existsByUsername(signUpDto.getUsername())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // check if email is exists
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email is already exists!", HttpStatus.BAD_REQUEST);
        }

        // create user
        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);
        return new ResponseEntity<>("User successfully registered", HttpStatus.OK);
    }
}
