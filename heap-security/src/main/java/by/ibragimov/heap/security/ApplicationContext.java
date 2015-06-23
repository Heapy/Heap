package by.ibragimov.heap.security;

import by.ibragimov.heap.utils.exceptions.ExceptionCode;
import by.ibragimov.heap.utils.exceptions.Preconditions;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

/**
 * TODO: CommentMe!
 *
 * @author Ibragimov Ruslan
 */
@Component
public class ApplicationContext {

    @Nonnull
    public Long getClientId() {
        return getUserDetails().getUserId();
    }

    private static HeapUserDetails getUserDetails() {
        return (HeapUserDetails) getAuthentication().getPrincipal();
    }

    @Nonnull
    private static Authentication getAuthentication() {
        return Preconditions.notNull(SecurityContextHolder.getContext().getAuthentication(), ExceptionCode.AUTHENTICATION, "Authentication not found.");
    }



}
