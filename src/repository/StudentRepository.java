package repository;



import java.io.*;
import java.util.HashMap;
import java.util.Map;
import domain.srk.Student;

public class StudentRepository implements Repository {
    private static String studentDataPath = "src/data/student.csv";
  //  private static String studentResultDataPath = "src/data/studentResult.csv";

    public Map<String,Student> studentMap = new HashMap<>();

    public StudentRepository() {
    }

    @Override
    public void initialize() {
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

    @Override
    public void save() {
        try {
            File file = new File(studentDataPath);
            BufferedWriter writeText = new BufferedWriter(new FileWriter(file));
            for (Student student : studentMap.values()) {
                writeText.newLine();
                writeText.write(student.toCsvString());
            }
            writeText.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
