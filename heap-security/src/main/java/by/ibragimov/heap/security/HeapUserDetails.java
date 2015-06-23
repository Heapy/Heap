package by.ibragimov.heap.security;

import by.ibragimov.heap.domain.common.HeapUser;
import by.ibragimov.heap.utils.exceptions.Preconditions;
import com.google.common.collect.ImmutableSet;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * Represents Client for Spring Security.
 *
 * @author Ibragimov Ruslan
 */
public class HeapUserDetails implements UserDetails {

    private String password;

    private String secret;

    private final Long userId;

    private final String username;

    private final Set<GrantedAuthority> authorities;

    /**
     * Creates an instance of spring security user class which implements UserDetails interface.
     */
    public HeapUserDetails(final HeapUser heapUser) {
        this.authorities = ImmutableSet.of(new SimpleGrantedAuthority("USER"));
        this.userId = Preconditions.notNull(heapUser.getId(), "User Id should be set.");
        this.password = heapUser.getPassword();
        this.secret = heapUser.getSecret();
        this.username = Preconditions.notNull(heapUser.getEmail(), "User email should be set.");
    }

    public Long getUserId() {
        return this.userId;
    }

    public String getSecret() {
        return secret;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void eraseCredentials() {
        this.password = null;
        this.secret = null;
    }
}
