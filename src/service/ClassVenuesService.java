package service;

import domain.BookClassVenue;
import domain.ClassVenue;
import repository.BookClassVenuesRepository;
import repository.ClassVenuesRepository;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassVenuesService extends Service{

    private StudentRepository studentRepository;

    private ClassVenuesRepository classVenuesRepository;

    private BookClassVenuesRepository bookClassVenuesRepository;

    //constructor
    public ClassVenuesService(StudentRepository studentRepository, ClassVenuesRepository classVenuesRepository, BookClassVenuesRepository bookClassVenuesRepository) {
        this.studentRepository = studentRepository;
        this.classVenuesRepository = classVenuesRepository;
        this.bookClassVenuesRepository = bookClassVenuesRepository;
    }


    @Override
    public void showMenu() {
        String[] menu = {"1.Search Class Venue", "2.Show All Class Venue",
                "3.Add Class Venue", "4.Update Class Venue",
                "5.Delete Class Venue",

                "6.Search Booked Class Venue",
                "7.Show All Booked Class Venue","8.Book Class Venue",
                "9.Cancel Book Class Venue",

                "0.Back to Main Menu"};



        for (String s : menu) {
            System.out.println(s);
        }
    }

    @Override
    public void process() {
        //show menu
        while (true){
            System.out.println("=================Manage Class Venue==================");
            showMenu();
            //choose menu
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please choose menu: ");
            int choose = scanner.nextInt();
            scanner.nextLine();
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
                    //search booked class venue
                    searchBookedClassVenue();
                    System.out.println();
                    break;
                case 7:
                    //show all booked class venue
                    showAllBookedClassVenue();
                    System.out.println();
                    break;
                case 8:
                    //book class venue
                    bookClassVenue();
                    System.out.println();
                    break;
                case 9:
                    //cancel book class venue
                    cancelBookClassVenue();
                    System.out.println();
                    break;
                case 0:
                    //back to main menu
                    save();
                    return;
                default:
                    System.out.println("Please choose correct menu!");
                    System.out.println();
            }
        }

    }

    @Override
    public void search() {
        // two type of search code or name
        System.out.println("Please choose search type for Class Venue : 1.Code 2.Name");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        String code = null;
        String name = null;

        switch (choose){
            case 1:
                //search by code
                System.out.println("Please input code: ");
                code = scanner.next();
                break;
            case 2:
                //search by name
                System.out.println("Please input name: ");
                name = scanner.next();
                break;
            default:
                System.out.println("Please choose correct menu!");
                break;
        }

        ClassVenue classVenue = classVenuesRepository.search(code, name);
        if(classVenue != null){
            System.out.println(classVenue);
        }else{
            System.out.println("No result found!");
        }
    }

    @Override
    public void showAll() {
        System.out.println("All Class Venue: ");
        classVenuesRepository.showAll();
    }

    @Override
    public void add() {
        System.out.println("Please input code: ");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.next();

        while(classVenuesRepository.search(code, null) != null){
            System.out.println("Code already exist!");
            System.out.println("Please input code: ");
            code = scanner.next();
        }

        System.out.println("Please input name: ");
        String name = scanner.next();

        System.out.println("Please input status(0.can not use, 1.can use): ");
        boolean status = scanner.nextInt()==1;

        ClassVenue classVenue = new ClassVenue(code, name, status);
        classVenuesRepository.add(classVenue);

        System.out.println("Add success!");

    }

    @Override
    public void update() {
        System.out.println("Please input code: ");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.next();

        ClassVenue classVenue = classVenuesRepository.search(code, null);
        if(classVenue != null){
            System.out.println("Please input new name: ");
            String name = scanner.next();

            System.out.println("Please input new status(0.can not use, 1.can use): ");
            boolean status = scanner.nextInt()==1;

            classVenue.setClassVenuesName(name);
            classVenue.setStatus(status);

            classVenuesRepository.update(classVenue);
            System.out.println("Update successfully!");

        }else{
            System.out.println("No result found!");
        }

    }

    @Override
    public void delete() {
        System.out.println("Please input code: ");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.next();

        ClassVenue classVenue = classVenuesRepository.search(code, null);
        if(classVenue != null){
            classVenuesRepository.delete(code);
            System.out.println("Delete successfully!");
        }else{
            System.out.println("No result found!");
        }

    }

    //searchBookedClassVenue
    public void searchBookedClassVenue(){
        // two type of search code or name
        System.out.println("Please choose search type for Booked Class Venue : 1.Code 2.StudentId");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        ArrayList<BookClassVenue> bookClassVenues = null;
        switch (choose){
            case 1:
                //search by code
                System.out.println("Please input code: ");
                String code = scanner.next();
                bookClassVenues = bookClassVenuesRepository.searchByCode(code);
                break;
            case 2:
                //search by name
                System.out.println("Please input StudentId: ");
                String StudentId = scanner.next();
                bookClassVenues = bookClassVenuesRepository.searchByStudentId(StudentId);
                break;
            default:
                System.out.println("Please choose correct menu!");
                break;
        }

        if(bookClassVenues != null && bookClassVenues.size() > 0){
            for (BookClassVenue bookClassVenue : bookClassVenues) {
                System.out.println(bookClassVenue);
            }
        }else{
            System.out.println("No result found!");
        }

    }

    //showAllBookedClassVenue
    public void showAllBookedClassVenue(){
        System.out.println("All Booked Class Venue: ");
        bookClassVenuesRepository.showAll();
    }

    //bookClassVenue
    public void bookClassVenue(){
        
    }


    @Override
    public void save() {
        classVenuesRepository.save();
        bookClassVenuesRepository.save();
    }
}
