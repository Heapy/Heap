package by.ibragimov.heap.utils.exceptions;

/**
 * TODO: CommentMe!
 *
 * @author Ibragimov Ruslan
 */
public final class Preconditions {

    private Preconditions() {
        // Utility
    }

    public static <T> T notNull(T ref, String message) {
        if (ref == null) {
            HeapException.throwNew(ExceptionCode.NULL, message);
        }
        return ref;
    }

    public static <T> T notNull(T ref, ExceptionCode code, String message) {
        if (ref == null) {
            HeapException.throwNew(code, message);
        }
        return ref;
    }

    public static void is(boolean expression, String message) {
        if (!expression) {
            HeapException.throwNew(ExceptionCode.STATE, message);
        }
    }

    public static void is(boolean expression, ExceptionCode code, String message) {
        if (!expression) {
            HeapException.throwNew(code, message);
        }
    }
}
