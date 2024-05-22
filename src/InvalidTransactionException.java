public class InvalidTransactionException extends Exception {
    // Constructor that accepts a message
    public InvalidTransactionException(String message) {
        super(message);
    }
    // Constructor that accepts a message and a cause
    public InvalidTransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}