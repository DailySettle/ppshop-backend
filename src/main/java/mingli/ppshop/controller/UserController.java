package mingli.ppshop.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import mingli.ppshop.PPUserDetailsService;
import mingli.ppshop.Exception.UserEmailExistException;
import mingli.ppshop.models.AuthRequest;
import mingli.ppshop.models.AuthResponse;
import mingli.ppshop.service.UserService;
import mingli.ppshop.util.JwtUtil;
import mingli.ppshop.util.Result;
import mingli.ppshop.util.StatusCode;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin()
@AllArgsConstructor
@Log
public class UserController {

    private final AuthenticationManager authenticationManager;

    private final PPUserDetailsService ppUserDetailsService;

    private final UserService userService;

    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public Result login(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.warning(authRequest.getUsername() + "has met error: " + e.getMessage());
            return new Result(false, StatusCode.LOGIN_FAILED_PASSWORD_INVALID.getCode(), e.getMessage());
        }
        final UserDetails userDetails = ppUserDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return new Result(true, StatusCode.COMMON_REQUEST_SUCCESS.getCode(), "User Login Successful", new AuthResponse(userDetails.getUsername(), jwt));
    }

    @PostMapping("/signup")
    public Result signup(@RequestBody AuthRequest authRequest) {
        try {
            userService.signup(authRequest);
        } catch (UserEmailExistException e) {
            log.warning(authRequest.getUsername() + "has tried to signup with existed email. Error: " + e.getMessage());
            return new Result(false, StatusCode.SIGNUP_FAILED_EMAIL_EXIST.getCode(), e.getMessage());
        }

        return new Result(true, StatusCode.COMMON_REQUEST_SUCCESS.getCode(), "User Signup Successful");
    }

}
