package repository;

import domain.srk.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentResultRepository implements Repository {
    //data file path
    private static String studentResultDataPath = "src/data/studentResult.csv";

    //student result map  <StudentNumber,result list>
    public Map<String, List<StudentResult>> studentResultMap = new HashMap<>();

    //initialize function
    public void initialize() {
        //get student result data from file
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(studentResultDataPath))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                StudentResult studentResult = new StudentResult();
                studentResult.fromCSV(line);

                //create student result object
                //check student result map contains student number
                if (studentResultMap.containsKey(studentResult.getStudentNumber())) {
                    //add student result to student result list
                    studentResultMap.get(studentResult.getStudentNumber()).add(studentResult);
                } else {
                    //create student result list
                    List<StudentResult> studentResultList = new ArrayList<>();
                    //add student result to student result list
                    studentResultList.add(studentResult);
                    //add student result list to student result map
                    studentResultMap.put(studentResult.getStudentNumber(), studentResultList);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //save function
    public void save() {
        try{
            //save student result data to file
            File file = new File(studentResultDataPath);
            BufferedWriter writeText = new BufferedWriter(new FileWriter(file));
            // studentNumber+","+year+","+semester+","+subjectName+","+subjectCode+","+marks+","+grade;
            //write header
            writeText.write("studentNumber,year,semester,subjectName,subjectCode,marks,grade");

            //loop student result map
            for (List<StudentResult> studentResultList : studentResultMap.values()) {
                //loop student result list
                for (StudentResult studentResult : studentResultList) {
                    writeText.newLine();
                    writeText.write(studentResult.toCSV());
                }
            }
            writeText.close();
        }catch (IOException e) {
            e.printStackTrace();
        }


    }

}
