package by.ibragimov.heap.security;

/**
 * TODO: CommentMe!
 *
 * @author Ibragimov Ruslan
 */

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class AuthenticationHelper {

    public static final String AUTHENTICATION_HEADER = "Authorization";

    /**
     * TTL for tokens in seconds.
     */
//    @Value("${jwt.security.token.expiration.duration:900}")
    private Long tokenExpirationTime = 86000L;

    @Autowired
    private Gson gson;

    /**
     * Generate JWT from UserDetails.
     *
     * @return JWT converted to string
     */
    public String generateToken(final HeapUserDetails heapUserDetails) {
        TokenPayload payload = getPayload(heapUserDetails);
        String token = this.gson.toJson(payload);
        return JwtHelper.encode(token, new MacSigner(heapUserDetails.getSecret())).getEncoded();
    }

    private TokenPayload getPayload(final HeapUserDetails heapUserDetails) {
        return new TokenPayload(heapUserDetails.getUserId(), Instant.now().getEpochSecond() + this.tokenExpirationTime);
    }
}
