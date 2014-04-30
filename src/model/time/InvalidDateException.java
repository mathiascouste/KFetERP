package model.time;

/**
 * Exception which reports an invalid date
 * @author Loïc GAILLARD
 *
 */
public class InvalidDateException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidDateException(int year, int month, int day) {
        super("The date "+year+"-"+month+"-"+day+" is not valid.");
    }
    
    public InvalidDateException(String message) {
        super(message);
    }
}
