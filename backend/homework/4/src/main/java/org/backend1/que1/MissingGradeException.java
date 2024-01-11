package org.backend1.que1;

/**
 * representing a checked exception for the missing grade for a particular class
 */
public class MissingGradeException extends Exception {
    private final int studentId;

    public MissingGradeException(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }
}
