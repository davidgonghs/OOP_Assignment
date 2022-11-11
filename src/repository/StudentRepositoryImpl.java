package repository;



import java.io.*;
import java.util.HashMap;
import java.util.Map;
import domain.Student;

public class StudentRepositoryImpl implements StudentRepository {
    private static String studentDataPath = "src/data/student.csv";
  //  private static String studentResultDataPath = "src/data/studentResult.csv";

    private Map<String,Student> studentMap = new HashMap<>();

    public StudentRepositoryImpl() {
    }

    @Override
    public void initialize() {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(studentDataPath))) {
            int i = 0;
            while ((line = br.readLine()) != null) {
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
    public Student search(String keyword) {
        if (studentMap.containsKey(keyword)) {
            return studentMap.get(keyword);
        } else {
            return null;
        }
    }

    @Override
    public void showAll() {
        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
            System.out.println(entry.getValue().toString());
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

    @Override
    public void add(Student student) {
        studentMap.put(student.getStudentNumber(),student);
    }

    @Override
    public void update(Student student) {
        studentMap.put(student.getStudentNumber(),student);
    }

    @Override
    public void delete(String studentNumber) {
        studentMap.remove(studentNumber);
    }
}
