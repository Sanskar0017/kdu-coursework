package org.backend1.que1;

/**
 * representing a checked exception for the missing grade for a particular class
 */
public class MissingGradeException extends Exception {

    private int StudentId;

    public MissingGradeException(int StudentId){
        this.StudentId = StudentId;
    }

    public int getStudentId(){
        return StudentId;
    }
}
