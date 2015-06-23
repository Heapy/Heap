package by.ibragimov.heap.security;

import by.ibragimov.heap.utils.exceptions.ExceptionCode;
import by.ibragimov.heap.utils.exceptions.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO: CommentMe!
 *
 * @author Ibragimov Ruslan
 */
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    public JwtAuthenticationFilter(final AuthenticationManager authenticationManager) {
        // Filter all requests
        super(request -> true);
        setAuthenticationManager(authenticationManager);
        setAuthenticationFailureHandler(new RestAuthenticationFailureHandler());
    }

    /**
     * Used for user authentication via JWT token.
     */
    @Override
    public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        try {
            // Getting JWT token from request
            String token = Preconditions.notNull(request.getHeader(AuthenticationHelper.AUTHENTICATION_HEADER),
                    ExceptionCode.AUTHENTICATION, "Token not found in request's header.");

            // Create token for authentication provider
            JwtAuthenticationToken authRequest = new JwtAuthenticationToken(token);

            // Return a fully authenticated object
            return this.getAuthenticationManager().authenticate(authRequest);
        } catch (AuthenticationException e) {
            // Go to 401 error page if exception thrown
            unsuccessfulAuthentication(request, response, e);
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(final HttpServletRequest request, final HttpServletResponse response,
                                            final FilterChain chain, final Authentication authResult) throws IOException, ServletException {

        LOGGER.debug("Authentication success. Updating SecurityContextHolder to contain: {}", authResult);

        // Set authentication to context
        SecurityContextHolder.getContext().setAuthentication(authResult);

        // Fire event
        if (this.eventPublisher != null) {
            this.eventPublisher.publishEvent(new InteractiveAuthenticationSuccessEvent(authResult, this.getClass()));
        }

        // Proceed request
        chain.doFilter(request, response);
    }
}
