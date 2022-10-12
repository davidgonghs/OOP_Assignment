package repository;

import domain.srk.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Initialization {
    private static String studentDataPath = "src/data/student.csv";
    private static String resultDataPath = "src/data/result.csv";


    public static void initialize() {
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(studentDataPath))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] student = line.split(cvsSplitBy);
                Student s = new Student(student[0],student[1]);
                System.out.println(s.getStudentNumber() + " " + s.getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void initializeStudent() {

    }

    private void initializeStudentResult() {

    }
}
