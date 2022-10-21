package service;

import domain.srk.Student;
import domain.srk.StudentResult;
import repository.StudentRepository;
import repository.StudentResultRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements Service {

    public StudentRepository studentRepository=new StudentRepository();
    public StudentResultRepository studentResultRepository=new StudentResultRepository();

    //show menu function
    public void showMenu() {
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Update Student");
        System.out.println("4. View Student");
        System.out.println("5. Exit");
    }

    //add student function
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        //get student number
        System.out.println("Please enter student number:");
        String studentNumber = scanner.nextLine();
        //check student number is exist
        if (studentRepository.studentMap.containsKey(studentNumber)) {
            System.out.println("Student number is exist!");
        } else {
            //get student name
            System.out.println("Please enter student name:");
            String studentName = scanner.nextLine();
            //create student object
            Student student = new Student(studentNumber, studentName);
            //add student to student map
            studentRepository.studentMap.put(studentNumber, student);
            System.out.println("Add student success!");
        }
    }

    //update student function
    public void updateStudent() {
        Scanner scanner = new Scanner(System.in);
        //get student number
        System.out.println("Please enter student number:");
        String studentNumber = scanner.nextLine();
        //check student number is exist
        if (studentRepository.studentMap.containsKey(studentNumber)) {
            //get student name
            System.out.println("Please enter student name:");
            String studentName = scanner.nextLine();
            //create student object
            Student student = new Student(studentNumber, studentName);
            //update student to student map
            studentRepository.studentMap.put(studentNumber, student);
            System.out.println("Update student success!");
        } else {
            System.out.println("Student number is not exist!");
        }
    }

    //delete student function
    public void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        //get student number
        System.out.println("Please enter student number:");
        String studentNumber = scanner.nextLine();
        //check student number is exist
        if (studentRepository.studentMap.containsKey(studentNumber)) {
            //delete student from student map
            studentRepository.studentMap.remove(studentNumber);
            //delete student result from student result map
            studentResultRepository.studentResultMap.remove(studentNumber);
            System.out.println("Delete student success!");
        } else {
            System.out.println("Student number is not exist!");
        }
    }

    //view student function
    public void viewStudent() {
        //loop student map
        for (Student student : studentRepository.studentMap.values()) {
            System.out.println(student.toString());
        }
    }

    //add student result function
    public void addStudentResult() {
        Scanner scanner = new Scanner(System.in);
        //get student number
        System.out.println("Please enter student number:");
        String studentNumber = scanner.nextLine();
        //check student number is exist
        if (studentRepository.studentMap.containsKey(studentNumber)) {
            //get subject code
            StudentResult studentResult = new StudentResult();
            System.out.println("Please enter subject code:");
            String subjectCode = scanner.nextLine();
            studentResult.setSubjectCode(subjectCode);
            //get subject name
            System.out.println("Please enter subject name:");
            String subjectName = scanner.nextLine();
            studentResult.setSubjectName(subjectName);
            //get subject score
            System.out.println("Please enter subject mark:");
            Double subjectMark = scanner.nextDouble();
            studentResult.setMarks(subjectMark);
            //get subject grade
            System.out.println("Please enter subject grade:");
            String subjectGrade = scanner.nextLine();
            studentResult.setGrade(subjectGrade);
            //create student result object
           // StudentResult studentResult = new StudentResult(studentNumber,subjectName, subjectCode, subjectScore, subjectGrade);
            //check student result map contains student number
            if (studentResultRepository.studentResultMap.containsKey(studentNumber)) {
                //add student result to student result list
                studentResultRepository.studentResultMap.get(studentNumber).add(studentResult);
            } else {
                //create student result list
                List<StudentResult> studentResultList = new ArrayList<>();
                //add student result to student result list
                studentResultList.add(studentResult);
                //add student result list to student result map
                studentResultRepository.studentResultMap.put(studentNumber, studentResultList);
            }
            System.out.println("Add student result success!");
        } else {
            System.out.println("Student number is not exist!");
        }
    }

    //update student result function
    public void updateStudentResult() {
        Scanner scanner = new Scanner(System.in);
        //get student number
        System.out.println("Please enter student number:");
        String studentNumber = scanner.nextLine();
        //check student number is exist
        if (studentRepository.studentMap.containsKey(studentNumber)) {
            //get subject code
            System.out.println("Please enter subject code:");
            String subjectCode = scanner.nextLine();
            //check student result map contains student number
            if (studentResultRepository.studentResultMap.containsKey(studentNumber)) {
                //loop student result list
                for (StudentResult studentResult : studentResultRepository.studentResultMap.get(studentNumber)) {
                    //check subject code is exist
                    if (studentResult.getSubjectCode().equals(subjectCode)) {
                        //get subject name
                        System.out.println("Please enter subject name:");
                        String subjectName = scanner.nextLine();
                        studentResult.setSubjectName(subjectName);
                        //get subject score
                        System.out.println("Please enter subject mark:");
                        Double subjectMark = scanner.nextDouble();
                        studentResult.setMarks(subjectMark);
                        //get subject grade
                        System.out.println("Please enter subject grade:");
                        String subjectGrade = scanner.nextLine();
                        studentResult.setGrade(subjectGrade);
                        System.out.println("Update student result success!");
                        return;
                    }
                }
                System.out.println("Subject code is not exist!");
            } else {
                System.out.println("Student number is not exist!");
            }
        } else {
            System.out.println("Student number is not exist!");
        }
    }

    //delete student result function
    public void deleteStudentResult() {
        Scanner scanner = new Scanner(System.in);
        //get student number
        System.out.println("Please enter student number:");
        String studentNumber = scanner.nextLine();
        //check student number is exist
        if (studentRepository.studentMap.containsKey(studentNumber)) {
            //get subject code
            System.out.println("Please enter subject code:");
            String subjectCode = scanner.nextLine();
            //check student result map contains student number
            if (studentResultRepository.studentResultMap.containsKey(studentNumber)) {
                //loop student result list
                for (StudentResult studentResult : studentResultRepository.studentResultMap.get(studentNumber)) {
                    //check subject code is exist
                    if (studentResult.getSubjectCode().equals(subjectCode)) {
                        //delete student result from student result list
                        studentResultRepository.studentResultMap.get(studentNumber).remove(studentResult);
                        System.out.println("Delete student result success!");
                        return;
                    }
                }
                System.out.println("Subject code is not exist!");
            } else {
                System.out.println("Student number is not exist!");
            }
        } else {
            System.out.println("Student number is not exist!");
        }
    }

    //view student result function
    public void viewStudentResult() {
        Scanner scanner = new Scanner(System.in);
        //get student number
        System.out.println("Please enter student number:");
        String studentNumber = scanner.nextLine();
        //check student number is exist
        if (studentRepository.studentMap.containsKey(studentNumber)) {
            //check student result map contains student number
            if (studentResultRepository.studentResultMap.containsKey(studentNumber)) {
                //loop student result list
                for (StudentResult studentResult : studentResultRepository.studentResultMap.get(studentNumber)) {
                    System.out.println(studentResult.toString());
                }
            } else {
                System.out.println("Student number is not exist!");
            }
        } else {
            System.out.println("Student number is not exist!");
        }
    }


    //initialize function
    public void initialize() {

        studentRepository.initialize();
        studentResultRepository.initialize();
    }

    //save function
    public void save() {
        studentRepository.save();
        studentResultRepository.save();
    }




}
