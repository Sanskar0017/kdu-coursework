package org.backend1.que1;

import java.util.*;
import java.util.logging.Logger;

public class StudentUtil {
    private static final Logger LOGGER = Logger.getLogger(StudentUtil.class.getName());

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException {

        if (studentIdList != null && studentsGrades != null && studentIdList.length == studentsGrades.length) {
            double[] stuList = new double[studentIdList.length];

            for(int i = 0; i < studentIdList.length; ++i) {
                int scored = 0;
                int totalcourses = studentsGrades[i].length;
                char[] var6 = studentsGrades[i];
                int var7 = var6.length;

                for(int var8 = 0; var8 < var7; ++var8) {
                    char grades = var6[var8];
                    switch (grades) {
                        case 'A':
                            scored += 4;
                            break;
                        case 'B':
                            scored += 3;
                            break;
                        case 'C':
                            scored += 2;
                            break;
                        case ' ':
                            // exception task 2
                            throw new MissingGradeException(studentIdList[var8]);
                        default: break;

                    }
                }

                stuList[i] = (double)scored / (double)totalcourses;
            }

            return stuList;
        } else {
            return new double[0];
        }
    }

    public static int[] getStudentsbyGPA(double lower, double higher, int[] studentIdList, char[][] studentGrades) throws InvalidDataException {

        // Task 2 checked exception avoiding compilation errors by catching it
        try {

            //        Task 1
            if(studentIdList.length != studentGrades.length){
                throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length: "
                        + studentIdList.length + ", studentsGrades.length: " + studentGrades.length);
            }

            if (!(lower <= higher) && !(lower >= 0.0) && !(higher >= 0.0) && studentGrades.length == studentIdList.length) {
                double[] gpaavg = calculateGPA(studentIdList, studentGrades);
                int cnt = 0;
                double[] var8 = gpaavg;
                int idx = gpaavg.length;

                int i;
                for (i = 0; i < idx; ++i) {
                    double val = var8[i];
                    if (val >= lower && val <= higher) {
                        ++cnt;
                    }
                }

                int[] list = new int[cnt];
                idx = 0;

                for (i = 0; i < gpaavg.length; ++i) {
                    if (gpaavg[i] >= lower && gpaavg[i] <= higher) {
                        list[idx++] = studentIdList[i];
                    }
                }

                return list;
            } else{
                return null;
            }
        }catch (MissingGradeException e) {
            // Exception Chaining
            // calculate Gpa will throw the error MissingGradeException
            // chaining awareness message plus cause
            throw new InvalidDataException("Missing Grade of Student", e.getStudentId());
        }
    }

    public static void main(String[] args) throws MissingGradeException {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Enter the number of students (n): ");
        int n = scanner.nextInt();
        int[] studentIdList = new int[n];
        LOGGER.info("Enter student IDs:");

        for(int i = 0; i < n; ++i) {
            studentIdList[i] = scanner.nextInt();
        }

        char[][] studentsGrades = new char[n][];
        LOGGER.info("Enter students' grades:");

        for(int i = 0; i < n; ++i) {
            LOGGER.info(String.format("Student %d: ", studentIdList[i]));
            // using another nextLine to avoid issues when reading along with spaces
            LOGGER.info("Enter total subject of grading");
            int m = scanner.nextInt();
            studentsGrades[i] = new char[m];
            for(int j = 0; j < m; j++){
                studentsGrades[i][j] = scanner.next().charAt(0);
            }

        }

        calculateGPA(studentIdList, studentsGrades);
    }
}
