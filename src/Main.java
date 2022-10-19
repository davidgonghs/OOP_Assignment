import domain.srk.Student;
import repository.*;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Student> studentMap = new HashMap<>();
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.initialize();
       // System.out.println("Hello world!");
    }
}