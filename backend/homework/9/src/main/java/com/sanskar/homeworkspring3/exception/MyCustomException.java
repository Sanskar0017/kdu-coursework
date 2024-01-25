package com.sanskar.homeworkspring3.exception;

/**
 * Custom Exception class extending IndexoutofBoundsException
 * Representing a specific exception scenario in the application
 * @author Sanskar
 */
public class MyCustomException extends IndexOutOfBoundsException{
    public MyCustomException(String s) {
        super(s);
    }
}
