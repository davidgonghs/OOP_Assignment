package service;

import domain.srk.StudentResult;
import repository.StudentRepository;
import repository.StudentResultRepository;
import repository.StudentResultRepositoryImpl;
import tool.CommonTool;

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
                    break;
                default:
                    System.out.println("Please choose menu from 1 to 6");
                    break;
            }
        }
    }

    @Override
    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input student number: ");
        String studentNumber = scanner.nextLine();
        studentResultRepository.search(studentNumber);

    }

    @Override
    public void showAll() {
        studentResultRepository.showAll();
    }

    @Override
    public void add() {
        //get user input then ceate new StudentResult object
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input student number: ");
        String studentNumber = scanner.nextLine();
        //check student number is exist
        if (studentRepository.search(studentNumber) == null){
            System.out.println("Can not find student with Student Number: " + studentNumber);
            return;
        }

        System.out.println("Please input subject code: ");
        String subjectCode = scanner.nextLine();

        System.out.println("Please input subject name: ");
        String subjectName = scanner.nextLine();

        System.out.println("Please input year: ");
        String year = scanner.nextLine();

        System.out.println("Please input semester: ");
        String semester = scanner.nextLine();

        System.out.println("Please input marks: ");
        String marks = scanner.nextLine();

        String grade = CommonTool.getGrade(Double.parseDouble(marks));

        StudentResult studentResult = new StudentResult(studentNumber,subjectCode,subjectName,year,semester,marks,grade);
        studentResultRepository.add(studentResult);
    }

    @Override
    public void update() {
        //get user input then ceate new StudentResult object
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input student number: ");
        String studentNumber = scanner.nextLine();
        //check student number is exist
        if (studentRepository.search(studentNumber) == null){
            System.out.println("Can not find student with Student Number: " + studentNumber);
            return;
        }

        System.out.println("Please input subject code: ");
        String subjectCode = scanner.nextLine();

        System.out.println("Please input subject name: ");
        String subjectName = scanner.nextLine();

        System.out.println("Please input year: ");
        String year = scanner.nextLine();

        System.out.println("Please input semester: ");
        String semester = scanner.nextLine();

        System.out.println("Please input marks: ");
        String marks = scanner.nextLine();

        String grade = CommonTool.getGrade(Double.parseDouble(marks));

        StudentResult studentResult = new StudentResult(studentNumber,subjectCode,subjectName,year,semester,marks,grade);
        studentResultRepository.update(studentResult);

    }

    @Override
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input student number: ");
        String studentNumber = scanner.nextLine();
        //get subject code
        System.out.println("Please input subject code: ");
        String subjectCode = scanner.nextLine();
        studentResultRepository.delete(studentNumber,subjectCode);

    }

    @Override
    public void save() {
        studentResultRepository.save();
    }
}
