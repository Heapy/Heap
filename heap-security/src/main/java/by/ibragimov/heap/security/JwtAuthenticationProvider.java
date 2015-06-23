package by.ibragimov.heap.security;

import by.ibragimov.heap.domain.common.HeapUser;
import by.ibragimov.heap.domain.common.HeapUserRepository;
import by.ibragimov.heap.utils.exceptions.ExceptionCode;
import by.ibragimov.heap.utils.exceptions.HeapException;
import by.ibragimov.heap.utils.exceptions.Preconditions;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.stereotype.Component;

/**
 * TODO: CommentMe!
 *
 * @author Ibragimov Ruslan
 */
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private Gson gson;

    @Autowired
    private HeapUserRepository heapUserRepository;

    @Override
    public Authentication authenticate(final Authentication authRequest) throws AuthenticationException {

        // Getting string token from authentication request object
        String token = Preconditions.notNull(StringUtils.trimToNull((String) authRequest.getCredentials()), ExceptionCode.AUTHENTICATION, "No jwt token present.");

        // Getting JWT object from string token
        Jwt jwt = JwtHelper.decode(token);

        // Getting payload of token
        String claims = jwt.getClaims();
        TokenPayload tokenPayload = this.gson.fromJson(claims, TokenPayload.class);

        // Checking if token already expired and throwing an AuthenticationException in this case
        checkIsExpired(tokenPayload.expirationTime);

        // Getting user id from token

        Long userId = Preconditions.notNull(tokenPayload.userId, ExceptionCode.AUTHENTICATION, "Token doesn't contains user id.");

        // Getting user from database
        HeapUser user = this.heapUserRepository.findOne(userId);

        // Validate token signature (to be sure that token doesn't change on client side)
        try {
            jwt.verifySignature(new MacSigner(user.getSecret()));
        } catch (Exception cause) {
            HeapException.throwNew(ExceptionCode.AUTHENTICATION, "Token verification failed.", cause);
        }

        // Return authenticated Authentication
        HeapUserDetails userDetails = new HeapUserDetails(user);
        userDetails.eraseCredentials();
        return new JwtAuthenticationToken(userDetails);
    }

    private void checkIsExpired(final Long tokenExpirationTime) {
        Preconditions.is((System.currentTimeMillis() / 1000L) > tokenExpirationTime, ExceptionCode.AUTHENTICATION, "Token expired.");
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }
}