package by.ibragimov.heap.security;

import com.google.common.collect.ImmutableSet;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Objects;

/**
 * TODO: CommentMe!
 *
 * @author Ibragimov Ruslan
 */
public class JwtAuthenticationToken implements Authentication {

    private final HeapUserDetails heapUserDetails;

    private final Object credentials;

    private boolean isAuthenticated;

    private final Collection<? extends GrantedAuthority> grantedAuthorities;

    /**
     * Constructor for creating authentication request.
     *
     * @param token
     */
    public JwtAuthenticationToken(final String token) {
        this.credentials = token;
        this.heapUserDetails = null;
        this.grantedAuthorities = null;
    }

    /**
     * Constructor for creating authenticated user.
     *
     * @param heapUserDetails
     */
    public JwtAuthenticationToken(final HeapUserDetails heapUserDetails) {
        this.credentials = null;
        this.heapUserDetails = heapUserDetails;
        this.grantedAuthorities = ImmutableSet.copyOf(heapUserDetails.getAuthorities());
        this.isAuthenticated = true;
    }

    @Override
    public String getName() {
        return Objects.isNull(this.heapUserDetails) ? null : this.heapUserDetails.getUsername();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getDetails() {
        return this.heapUserDetails;
    }

    @Override
    public Object getPrincipal() {
        return this.heapUserDetails;
    }

    @Override
    public boolean isAuthenticated() {
        return this.isAuthenticated;
    }

    @Override
    public void setAuthenticated(final boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException("Once created you cannot set this token to authenticated.");
        }
        this.isAuthenticated = false;
    }
}
