package iitc.math;

/**
 * AssociationException
 *
 * @author Ian
 * @version 1.0
 */
public class AssociationException extends Exception {
    public AssociationException(Object error) {
        super("Variable '" + error + "' does not have a associated quantity.");
    }
}
