package by.ibragimov.heap.web.controllers;

import by.ibragimov.heap.security.AuthenticationHelper;
import by.ibragimov.heap.security.HeapUserDetails;
import by.ibragimov.heap.utils.exceptions.ExceptionCode;
import by.ibragimov.heap.utils.exceptions.HeapException;
import by.ibragimov.heap.utils.exceptions.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * TODO: CommentMe!
 *
 * @author Ibragimov Ruslan
 */
@RestController
@RequestMapping(value =  "/auth")
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticationHelper authenticationHelper;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResponseDto login(@RequestBody final LoginRequestDto request) {
        try {
            LOGGER.debug("Login request recieved.");

            String password = Preconditions.notNull(request.password, ExceptionCode.AUTHENTICATION, "Password should be passed.");
            String username = Preconditions.notNull(request.username, ExceptionCode.AUTHENTICATION, "Username should be passed.");

            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username,
                    password);

            // Try to authenticate with this token
            final Authentication authResult = this.authenticationManager.authenticate(authRequest);

            // Set generated JWT token to response header
            if (authResult.isAuthenticated()) {
                HeapUserDetails userDetails = (HeapUserDetails) authResult.getPrincipal();
                String token = this.authenticationHelper.generateToken(userDetails);
                userDetails.eraseCredentials();
                return new LoginResponseDto(token);
            } else {
                HeapException.throwNew(ExceptionCode.AUTHENTICATION,  "Some problem occurred during authentication.");
            }

        } catch (Exception e) {
            Optional.ofNullable(request.username).ifPresent(username -> {
                LOGGER.warn("Unsuccessful authentication attempt with username '{}'.", username);
            });
            HeapException.throwNew(ExceptionCode.AUTHENTICATION, "An exception during login.", e);
        }
        return null;
    }

    private static class LoginRequestDto {

        public LoginRequestDto() {
        }

        public LoginRequestDto(final String username, final String password) {
            this.username = username;
            this.password = password;
        }

        public String username;

        public String password;
    }

    public class LoginResponseDto {

        public LoginResponseDto(final String token) {
            this.token = token;
        }

        public final String token;
    }

}
