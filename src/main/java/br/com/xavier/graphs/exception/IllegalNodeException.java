package br.com.xavier.graphs.exception;

/**
 * 
 * Signals that a Node is not part of the Graph.
 * 
 * @author Matheus Xavier
 *
 */
public class IllegalNodeException extends RuntimeException {

	private static final long serialVersionUID = -220465570739804127L;
	
	/**
     * Constructs an {@code IllegalNodeException} with {@code null}
     * as its error detail message.
     */
	public IllegalNodeException() {
		super();
	}
	
	/**
	 * Constructs an {@code IllegalNodeException} with the specified detail message.
	 *
	 * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method)
	 */
	public IllegalNodeException(String message) {
		super(message);
	}
	
	 /**
     * Constructs an {@code IllegalNodeException} with the specified detail message and cause.
     *
     * <p> Note that the detail message associated with {@code cause} is
     * <i>not</i> automatically incorporated into this exception's detail
     * message.
     *
     * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method). 
     * (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
     *
     */
	public IllegalNodeException(Throwable throwable) {
		super(throwable);
	}
	
	 /**
     * Constructs an {@code IllegalNodeException} with the specified cause and a
     * detail message of {@code (cause==null ? null : cause.toString())}
     * (which typically contains the class and detail message of {@code cause}).
     * This constructor is useful for IO exceptions that are little more
     * than wrappers for other throwables.
     *
     * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
     * (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
     *
     */
	public IllegalNodeException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
