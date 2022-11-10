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
            int i = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                if (i == 0) {
                    i++;
                    continue;
                }
                String[] student = line.split(cvsSplitBy);
                Student student1 = new Student(student[0], student[1], Integer.parseInt(student[2]), student[3], student[4], student[5]);
                studentMap.put(student[0], student1);
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
                writeText.write(student.toCSVString());
            }
            writeText.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
