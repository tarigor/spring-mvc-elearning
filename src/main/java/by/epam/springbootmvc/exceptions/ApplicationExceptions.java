package by.epam.springbootmvc.exceptions;

public class ApplicationExceptions extends RuntimeException {
    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public ApplicationExceptions(String message) {
        super(message);
    }
}
