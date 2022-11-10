package service;

import repository.StudentResultRepositoryImpl;

import java.util.Scanner;

public class StudentResultService implements Service{

    public StudentResultRepositoryImpl studentResultRepository=new StudentResultRepositoryImpl();


    @Override
    public void showMenu() {
        String[] menu = {"1.Search Student Result", "2.Show All Student Result", "3.Add Student Result", "4.Update Student Result", "5.Delete Student Result","6.Exit"};
        for (String s : menu) {
            System.out.println(s);
        }
    }

    @Override
    public void initialize() {
        studentResultRepository.initialize();
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

    }

    @Override
    public void add() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void save() {
        studentResultRepository.save();
    }
}
