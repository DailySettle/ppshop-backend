package mingli.ppshop.endpoint;

import mingli.ppshop.models.AuthRequest;
import mingli.ppshop.models.AuthResponse;
import mingli.ppshop.PPUserDetailsService;
import mingli.ppshop.models.User;
import mingli.ppshop.repository.UserRepository;
import mingli.ppshop.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductEndpoint {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PPUserDetailsService ppUserDetailsService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Incorrect username or password", HttpStatus.NOT_FOUND);
        }
        final UserDetails userDetails = ppUserDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return new ResponseEntity<>(new AuthResponse(userDetails.getUsername(), jwt), HttpStatus.OK);
    }

    @PostMapping("/signup")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<?> signup(@RequestBody AuthRequest authRequest) {

        User created = userRepository.save(new User(authRequest.getUsername(), authRequest.getPassword(), true, "ROLE_USER"));

        if (userRepository.existsById(created.getId())) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
