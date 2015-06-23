package by.ibragimov.heap.security;

/**
 * TODO: CommentMe!
 *
 * @author Ibragimov Ruslan
 */
public class TokenPayload {

    public TokenPayload() {
    }

    public TokenPayload(final long userId, final long expirationTime) {
        this.userId = userId;
        this.expirationTime = expirationTime;
    }

    public long userId;

    public long expirationTime;
}
