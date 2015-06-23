package by.ibragimov.heap.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @see org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer
 *
 * @author Ibragimov Ruslan
 */
public class WebSecurityAppInitializer extends AbstractSecurityWebApplicationInitializer {

    public WebSecurityAppInitializer() {
        super(WebSecurityConfig.class);
    }
}