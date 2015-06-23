package by.ibragimov.heap.security;

 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO: CommentMe!
 *
 * @author Ibragimov Ruslan
 */
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    private static final Logger log = LoggerFactory.getLogger(RestAccessDeniedHandler.class);

    @Override
    public void handle(final HttpServletRequest request, final HttpServletResponse response,
                       final AccessDeniedException exception) throws IOException {
        log.error("Autorization failed on url '{}'.", request.getRequestURI(), exception);
        response.sendError(HttpServletResponse.SC_FORBIDDEN, exception.getMessage());
    }
}
