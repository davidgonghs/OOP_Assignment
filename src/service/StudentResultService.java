package service;

import domain.srk.StudentResult;
import repository.StudentRepository;
import repository.StudentResultRepository;
import repository.StudentResultRepositoryImpl;
import tool.CommonTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentResultService implements Service{

    private StudentResultRepository studentResultRepository;

    private StudentRepository studentRepository;

    //constructor
    public StudentResultService(StudentResultRepository studentResultRepository, StudentRepository studentRepository) {
        this.studentResultRepository = studentResultRepository;
        this.studentRepository = studentRepository;
    }


    @Override
    public void showMenu() {
        String[] menu = {"1.Search Student Result", "2.Show All Student Result", "3.Add Student Result", "4.Update Student Result", "5.Delete Student Result","6.Exit"};


        for (String s : menu) {
            System.out.println(s);
        }
    }


    @Override
    public void process() {
        //show menu
        while (true){
            System.out.println("=================Manage Student Result==================");
            showMenu();
            //choose menu
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please choose menu: ");
            int choose = scanner.nextInt();
            System.out.println();

            switch (choose){
                case 1:
                    //search
                    search();
                    System.out.println();
                    break;
                case 2:
                    //show all
                    showAll();
                    System.out.println();
                    break;
                case 3:
                    //add
                    add();
                    System.out.println();
                    break;
                case 4:
                    //update
                    update();
                    System.out.println();
                    break;
                case 5:
                    //delete
                    delete();
                    System.out.println();
                    break;
                case 6:
                    //exit
                    System.exit(0);
                    System.out.println();
                    break;
                default:
                    System.out.println("Please choose correct menu");
                    System.out.println();
                    break;
            }


        }
    }


    @Override
    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input student number: ");
        String studentNumber = scanner.nextLine();
        ArrayList<StudentResult> studentResults = studentResultRepository.search(studentNumber);
        if (studentResults.size() == 0){
            System.out.println("No result found");
        }else {
            //show student result and calculate cgpa and semester gpa
            double totalCredit = 0;
            double totalGpaPoint = 0;
            Map<Integer, Double> semesterGpaMap = new HashMap<>();
            Map<Integer, Double> semesterCreditMap = new HashMap<>();
            for (StudentResult studentResult : studentResults) {
                System.out.println(studentResult);
                totalCredit += studentResult.getCredit();
                totalGpaPoint += studentResult.getGpaPoint();

                if (semesterGpaMap.containsKey(studentResult.getSemester())){
                    double gpaPoint = semesterGpaMap.get(studentResult.getSemester());
                    semesterGpaMap.put(studentResult.getSemester(), gpaPoint + studentResult.getGpaPoint());

                    double credit = semesterCreditMap.get(studentResult.getSemester());
                    semesterCreditMap.put(studentResult.getSemester(), credit + studentResult.getCredit());
                }else {
                    semesterGpaMap.put(studentResult.getSemester(), studentResult.getGpaPoint());
                    semesterCreditMap.put(studentResult.getSemester(), studentResult.getCredit());
                }
            }
            double cgpa = totalGpaPoint / totalCredit;
            System.out.println("CGPA: " + cgpa);
            //get semester gpa
            for (Map.Entry<Integer, Double> entry : semesterGpaMap.entrySet()) {
                double semesterGpa = entry.getValue() / semesterCreditMap.get(entry.getKey());
                System.out.println("Semester " + entry.getKey() + " GPA: " + semesterGpa);
            }
        }
    }

    @Override
    public void showAll() {
        studentResultRepository.showAll();
    }

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input student number: ");
        String studentNumber = scanner.nextLine();
        //check student number
        while (studentRepository.search(studentNumber) == null){
            System.out.println("Student number not found!");
            System.out.println("Please input student number: ");
            studentNumber = scanner.nextLine();
        }


        System.out.println("Please input semester: ");
        int semester = scanner.nextInt();

        System.out.println("Please input code: ");
        String code = scanner.nextLine();

        System.out.println("Please input module: ");
        String module = scanner.nextLine();

        System.out.println("Please input marks: ");
        double marks = scanner.nextDouble();
        //check marks is valid
        while (!CommonTool.isMarksValid(marks)){
            System.out.println("Please input valid marks: ");
            marks = scanner.nextDouble();
        }

        String grade = CommonTool.getGrade(marks);

        System.out.println("Please input credit: ");
        double credit = scanner.nextDouble();

        double gradePoints = CommonTool.getGradePoints(grade);
        double gpaPoint = credit * gradePoints;

        StudentResult studentResult = new StudentResult(studentNumber,semester,code,module,marks,grade,credit,gpaPoint);
        studentResultRepository.add(studentResult);
    }

    @Override
    public void update() {
        //update student result
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input student number: ");
        String studentNumber = scanner.nextLine();
        //check student number
        while (studentRepository.search(studentNumber) == null){
            System.out.println("Student number not found!");
            System.out.println("Please input student number: ");
            studentNumber = scanner.nextLine();
        }

        System.out.println("Please input semester: ");
        int semester = scanner.nextInt();

        System.out.println("Please input code: ");
        String code = scanner.nextLine();

        System.out.println("Please input module: ");
        String module = scanner.nextLine();


        System.out.println("Please input marks: ");
        double marks = scanner.nextDouble();

        String grade = CommonTool.getGrade(marks);

        System.out.println("Please input credit: ");
        double credit = scanner.nextDouble();

        double gradePoints = CommonTool.getGradePoints(grade);
        double gpaPoint = credit * gradePoints;

        StudentResult studentResult = new StudentResult(studentNumber,semester,code,module,marks,grade,credit,gpaPoint);

        studentResultRepository.update(studentResult);
    }

    @Override
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input student number: ");
        String studentNumber = scanner.nextLine();
        //get subject code
        System.out.println("Please input subject code: ");
        String code = scanner.nextLine();
        studentResultRepository.delete(studentNumber,code);

    }

    @Override
    public void save() {
        studentResultRepository.save();
    }
}
