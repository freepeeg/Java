package iitc.query;

/**
 * InsufficientDriverException
 *
 * @author Ian
 * @version 1.0
 */
public class InsufficientDriverException extends Exception {
    public InsufficientDriverException() {
        super("SQL Driver not found. Please verify the existence of the proper driver to perform database queries.");
    }
}
