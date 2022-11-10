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
        try (BufferedReader br = new BufferedReader(new FileReader(studentDataPath))) {
            int i = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                if (i == 0) {
                    i++;
                    continue;
                }

                Student student = new Student();
                student.fromCSV(line);
                studentMap.put(student.getStudentNumber(),student);
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
            //studentNumber + "," + name + "," + age + ","  + email + "," + phone + "," + programme;
            //write header
            writeText.write("studentNumber,name,age,email,phone,programme");
            for (Student student : studentMap.values()) {
                writeText.newLine();
                writeText.write(student.toCSV());
            }
            writeText.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
