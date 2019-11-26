package filesprocessing;

/**
 * Handles exceptions at the input args or major problems at the command file. This exception stops the
 * program from running.
 */
public class ExceptionTypeTwo extends Exception {
    private static final String DEFAULT_ERROR_MESSAGE = "ERROR: ";

    private String errMsg; // Informative message.

    /**
     * Creates exception. Received message to present.
     * @param errMsg: error message.
     */
    public ExceptionTypeTwo(String errMsg){
        this.errMsg = DEFAULT_ERROR_MESSAGE + errMsg;
    }

    /**
     * String representation of the object
     * @return String.
     */
    public String toString(){
        return errMsg;
    }
}
