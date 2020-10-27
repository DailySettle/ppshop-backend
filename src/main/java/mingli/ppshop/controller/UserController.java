package mingli.ppshop.controller;

import lombok.AllArgsConstructor;
import mingli.ppshop.PPUserDetailsService;
import mingli.ppshop.models.AuthRequest;
import mingli.ppshop.models.AuthResponse;
import mingli.ppshop.service.UserService;
import mingli.ppshop.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin()
@AllArgsConstructor
public class UserController {

    private final AuthenticationManager authenticationManager;

    private final PPUserDetailsService ppUserDetailsService;

    private final UserService userService;

    private final JwtUtil jwtUtil;

    @PostMapping("/login")
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
    public ResponseEntity<?> signup(@RequestBody AuthRequest authRequest) {
        userService.signup(authRequest);

        return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);
    }

}
