package org.backend1.que1;
import java.util.logging.Logger;

public class InvalidDataException extends Exception{

    private static final Logger LOGGER = Logger.getLogger(InvalidDataException.class.getName());

    /**
     * @param message declares the message for exception
     * @param cause the cause of exception occuring from MissingGradeException
     *
     * Chaining Awareness construtor
     */
    public InvalidDataException(String message, int cause){
        LOGGER.info("Student with Id" + cause + " has " + message);
    }


}
