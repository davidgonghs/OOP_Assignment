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
                String[] studentResult = line.split(cvsSplitBy);
                //create student result object
                StudentResult sr = new StudentResult(studentResult[0], studentResult[1], studentResult[2], Double.valueOf(studentResult[3]), studentResult[4]);
                //check student result map contains student number
                if (studentResultMap.containsKey(sr.getStudentNumber())) {
                    //add student result to student result list
                    studentResultMap.get(sr.getStudentNumber()).add(sr);
                } else {
                    //create student result list
                    List<StudentResult> studentResultList = new ArrayList<>();
                    //add student result to student result list
                    studentResultList.add(sr);
                    //add student result list to student result map
                    studentResultMap.put(sr.getStudentNumber(), studentResultList);
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
            //loop student result map
            for (List<StudentResult> studentResultList : studentResultMap.values()) {
                //loop student result list
                for (StudentResult studentResult : studentResultList) {
                    writeText.newLine();
                    writeText.write(studentResult.toCsvString());
                }
            }
            writeText.close();
        }catch (IOException e) {
            e.printStackTrace();
        }


    }

}
