package service;

import domain.Student;
import repository.StudentRepository;

import java.util.Scanner;

public class StudentService extends Service {

    private StudentRepository studentRepository;

    //constructor
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    //show menu function
    @Override
    public void showMenu() {
        String[] menu = {"1.Search Student", "2.Show All Student", "3.Add Student", "4.Update Student", "5.Delete Student","6.Exit"};
        for (String s : menu) {
            System.out.println(s);
        }
    }

    @Override
    public void process() {
        //show menu
        while (true){
            System.out.println("=================Manage Student==================");
            showMenu();
            //choose menu
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please choose menu: ");
            int choose;
            try{
                choose = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
            }catch (Exception e){
                choose = 0;
                continue;
            }


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
                    save();
                    break;
                case 4:
                    //update
                    update();
                    save();
                    break;
                case 5:
                    //delete
                    delete();
                    save();
                    break;
                case 6:
                    //exit
                    save();
                    return;
                default:
                    System.out.println("Please choose correct menu");
                    System.out.println();
                    break;
            }
        }
    }




    @Override
    public void search() {
        //search
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input student number: ");
        String studentNumber = scanner.nextLine();
        scanner.nextLine();
        Student student = studentRepository.search(studentNumber);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found");
        }
    }

    @Override
    public void showAll() {
        //loop student map
        studentRepository.showAll();
    }

    @Override
    public void add() {
        //add student
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Number (EX.A0000): ");
        //check student number  first character is letter   and  length is 5
        String studentNumber = scanner.nextLine();
        scanner.nextLine();
        while (!studentNumber.matches("[A-Z]{1}[0-9]{4}")){
            System.out.println("Please input correct student number(0 to exit): ");
            studentNumber = scanner.nextLine();
            if (studentNumber.equals("0")){
                return;
            }
            scanner.nextLine();
        }

        //check student number is exist
        while (studentRepository.search(studentNumber) != null){
            System.out.println("Student number is exist");
            System.out.println("Please input another student number(0 to exit): ");
            studentNumber = scanner.nextLine();
            if(studentNumber.equals("0")){
                return;
            }
            scanner.nextLine();
        }

        System.out.println("Enter Student Name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Student Phone: ");
        //check phone number is it format is malaysia phone number
        String phone = scanner.nextLine();
        while (!phone.matches("^(01)[0-46-9]-*[0-9]{7,8}$")){
            System.out.println("Please input correct phone number");
            phone = scanner.nextLine();
            scanner.nextLine();
        }

        System.out.println("Enter Student Programme: ");
        String programme = scanner.nextLine();
        scanner.nextLine();
        programme.toUpperCase();

        String email = studentNumber+"@student.firstcity.edu.my";

        Student student = new Student(studentNumber, name, age, email, phone, programme);
        studentRepository.add(student);
        System.out.println("Add successfully!");
    }

    @Override
    public void update() {
        //update student
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Number: ");
        String studentNumber = scanner.nextLine();
        scanner.nextLine();
        //check student number is it exist
        while (studentRepository.search(studentNumber) == null){
            scanner = new Scanner(System.in);
            System.out.println("Can't find student, please input correct student number(input 0 to exit): ");
            studentNumber = scanner.next();
            if(studentNumber.equals("0")){
                return;
            }
            System.out.println(studentNumber);
        }

        System.out.println("Enter Student Name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Student Phone: ");
        String phone = scanner.nextLine();
        scanner.nextLine();
        while (!phone.matches("^(01)[0-46-9]-*[0-9]{7,8}$")){
            System.out.println("Please input correct phone number");
            phone = scanner.nextLine();
            scanner.nextLine();
        }


        System.out.println("Enter Student Programme: ");
        String programme = scanner.nextLine();
        scanner.nextLine();
        programme.toUpperCase();

        String email = studentNumber+"@student.firstcity.edu.my";

        Student student = new Student(studentNumber, name, age, email, phone, programme);
        studentRepository.update(student);
        System.out.println("Update successfully!");
    }

    @Override
    public void delete() {
        //delete student
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Number: ");
        String studentNumber = scanner.nextLine();
        scanner.nextLine();
        studentRepository.delete(studentNumber);
        System.out.println("Delete successfully!");
    }

    //save function
    public void save() {
        studentRepository.save();
        System.out.println("Save successfully!");
    }


}
