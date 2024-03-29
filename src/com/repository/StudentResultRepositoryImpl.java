package com.repository;

import com.domain.StudentResult;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentResultRepositoryImpl implements StudentResultRepository {
    //com.data file path
    private static String studentResultDataPath = "src/com/data/studentResult.csv";

    //student result map  <StudentNumber,result list>
    private Map<String, List<StudentResult>> studentResultMap = new HashMap<>();


    //initialize function
    public void initialize() {
        //get student result com.data from file
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(studentResultDataPath))) {
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }

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

    @Override
    public void showAll() {
        for (Map.Entry<String, List<StudentResult>> entry : studentResultMap.entrySet()) {
            for (StudentResult studentResult : entry.getValue()) {
                System.out.println(studentResult.toString());
            }
        }
    }

    //save function
    public void save() {
        try{
            //save student result com.data to file
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

    @Override
    public ArrayList<StudentResult> search(String keyword) {
        //search student result by student number
        if (studentResultMap.containsKey(keyword)) {
            return (ArrayList<StudentResult>) studentResultMap.get(keyword);
        } else {
            return null;
        }
    }

    @Override
    public void add(StudentResult csvClass) {
        //add student result to student result map
        if (studentResultMap.containsKey(csvClass.getStudentNumber())) {
            studentResultMap.get(csvClass.getStudentNumber()).add(csvClass);
        } else {
            List<StudentResult> studentResultList = new ArrayList<>();
            studentResultList.add(csvClass);
            studentResultMap.put(csvClass.getStudentNumber(), studentResultList);
        }
    }

    @Override
    public void update(StudentResult csvClass) {

        //update student result to student result map
        if (studentResultMap.containsKey(csvClass.getStudentNumber())) {
            List<StudentResult> studentResultList = studentResultMap.get(csvClass.getStudentNumber());
            for (int i = 0; i < studentResultList.size(); i++) {
                if (studentResultList.get(i).getCode().equals(csvClass.getCode()) && studentResultList.get(i).getSemester() == csvClass.getSemester()) {
                    studentResultList.set(i, csvClass);
                    System.out.println("Student result updated successfully");
                }
            }
            studentResultMap.put(csvClass.getStudentNumber(), studentResultList);
        }
    }

    @Override
    public void delete(String studentNumber,String subjectCode) {
        //delete student result from student result map
        if (studentResultMap.containsKey(studentNumber)) {
            List<StudentResult> studentResultList = studentResultMap.get(studentNumber);
            for (int i = 0; i < studentResultList.size(); i++) {
                if (studentResultList.get(i).getCode().equals(subjectCode)) {
                    studentResultList.remove(i);
                }
            }
        }
    }
}
