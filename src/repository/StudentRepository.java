package repository;

import domain.srk.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class StudentRepository {
    private static String studentDataPath = "src/data/student.csv";
    public void initialize(Map<String,Student> studentMap) {
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(studentDataPath))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] student = line.split(cvsSplitBy);
                Student s = new Student(student[0],student[1]);
                System.out.println(s.getStudentNumber() + " " + s.getName());
                studentMap.put(s.getStudentNumber(),s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student) {
        //write student to csv file
        
    }
}
