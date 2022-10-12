package domain.srk;

import java.util.Arrays;

public class Student {
    private String studentNumber;
    private String name;
    private StudentResult[] studentResults;

    public Student() {
    }

    public Student(String studentNumber, String name) {
        this.studentNumber = studentNumber;
        this.name = name;
    }

    public Student(String studentNumber, String name, StudentResult[] studentResults) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.studentResults = studentResults;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNumber='" + studentNumber + '\'' +
                ", name='" + name + '\'' +
                ", studentResults=" + Arrays.toString(studentResults) +
                '}';
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentResult[] getStudentResults() {
        return studentResults;
    }

    public void setStudentResults(StudentResult[] studentResults) {
        this.studentResults = studentResults;
    }
}
