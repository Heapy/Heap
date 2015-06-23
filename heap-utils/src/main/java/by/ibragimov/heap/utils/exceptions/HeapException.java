package by.ibragimov.heap.utils.exceptions;

/**
 * Only these exception should be used in application, and all other exceptions should be wrappers in it.
 *
 * @author Ibragimov Ruslan
 */
public final class HeapException extends RuntimeException {

    private final ExceptionCode code;

    private HeapException(String message, ExceptionCode code) {
        super(message);
        this.code = code;
    }

    private HeapException(ExceptionCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public static HeapException of(ExceptionCode code, String message) {
        return new HeapException(message, code);
    }

    public static HeapException of(ExceptionCode code, String message, Throwable cause) {
        return new HeapException(code, message, cause);
    }

    public static void throwNew(ExceptionCode code, String message) throws HeapException {
        throw of(code, message);
    }

    public static void throwNew(ExceptionCode code, String message, Throwable cause) throws HeapException {
        throw of(code, message, cause);
    }
}
