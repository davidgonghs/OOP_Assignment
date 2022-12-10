package service;

import domain.BookSportFacility;
import domain.SportFacility;
import repository.BookSportFacilitiesRepository;
import repository.SportFacilitiesRepository;
import repository.StudentRepository;
import repository.StudentResultRepository;
import tool.CommonTool;

import java.util.Scanner;

public class SportFacilitiesService extends Service{


    private SportFacilitiesRepository sportFacilitiesRepository;

    private BookSportFacilitiesRepository bookSportFacilitiesRepository;

    private StudentRepository studentRepository;

    //constructor
    public SportFacilitiesService(SportFacilitiesRepository sportFacilitiesRepository, BookSportFacilitiesRepository bookSportFacilitiesRepository, StudentRepository studentRepository) {
        this.sportFacilitiesRepository = sportFacilitiesRepository;
        this.bookSportFacilitiesRepository = bookSportFacilitiesRepository;
        this.studentRepository = studentRepository;
    }

    //show menu function
    public void showMenu(){
        String[] menu = {"1.Search Sport Facilities", "2.Show All Sport Facilities",
                "3.Add Sport Facilities", "4.Update Sport Facilities",
                "5.Delete Sport Facilities",

                "6.Search Booked Sport Facilities",
                "7.Show All Booked Sport Facilities","8.Book Sport Facilities",
                "9.Cancel Book Sport Facilities",

                "0.Exit"};

        for (String s : menu) {
            System.out.println(s);
        }
    }

    public void process(){
        //show menu
        while (true) {
            System.out.println("=================Manage Sport Facilities==================");
            showMenu();
            //choose menu
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please choose menu: ");
            int choose = scanner.nextInt();

            System.out.println();

            switch (choose) {
                case 1:
                    //search
                    searchSportFacilities();
                    System.out.println();
                    break;
                case 2:
                    //show all
                    showAllSportFacilities();
                    System.out.println();
                    break;
                case 3:
                    //add
                    addSportFacilities();
                    System.out.println();
                    break;
                case 4:
                    //update
                    updateSportFacilities();
                    System.out.println();
                    break;
                case 5:
                    //delete
                    deleteSportFacilities();
                    System.out.println();
                    break;
                case 6:
                    //book
                    searchBookSportFacilities();
                    System.out.println();
                    break;
                case 7:
                    //cancel book
                    showAllBookSportFacilities();
                    System.out.println();
                    break;
                case 8:
                    bookSportFacilities();
                    break;
                case 9:
                    cancelBookSportFacilities();
                    break;
                case 0:
                    save();
                    return;
                default:
                    System.out.println("Please choose correct menu!");
                    System.out.println();
                    break;
            }

        }
    }

    //search
    public void searchSportFacilities(){
        //two type of search , code, or name
        System.out.println("Please choose search type: 1.Code 2.Name");
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


        SportFacility sportFacility =  sportFacilitiesRepository.search(code,name);
        if(sportFacility == null){
            System.out.println("Not found!");
        } else {
            System.out.println(sportFacility);
        }
    }

    //search book sport facilities by student number
    public void searchBookSportFacilities(){
        //two type of search, one facility code , or studnet ID
        System.out.println("Please choose search type: 1.Facility Code 2.Student ID");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        switch (choose){
            case 1:
                //search by code
                System.out.println("Please input code: ");
                String code = scanner.next();
                bookSportFacilitiesRepository.searchByFacilityCode(code);
                break;
            case 2:
                //search by student ID
                System.out.println("Please input student ID: ");
                String studentID = scanner.next();
                bookSportFacilitiesRepository.searchByStudentId(studentID);
                break;
            default:
                System.out.println("Please choose correct menu!");
                break;
        }
    }


    //show all
    public void showAllSportFacilities(){
        sportFacilitiesRepository.showAll();
    }

    //add
    public void addSportFacilities(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input code: ");
        String code = scanner.next();

        //check code is exist
        while (sportFacilitiesRepository.search(code,null) != null){
            System.out.println("Code is exist, please input again!");
            code = scanner.next();
        }


        System.out.println("Please input name: ");
        String name = scanner.next();
        System.out.println("Please input status(0.can not use, 1.can use): ");
        boolean status = scanner.nextInt()==1?true:false;

        SportFacility sportFacility = new SportFacility(code,name,status);
        sportFacilitiesRepository.add(sportFacility);
        System.out.println("Add success!");
    }

    //update
    public void updateSportFacilities(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input code: ");
        String code = scanner.next();

        //check code is exist
        while (sportFacilitiesRepository.search(code,null) == null){
            System.out.println("Code is not exist, please input again!");
            code = scanner.next();
        }

        System.out.println("Please input name: ");
        String name = scanner.next();
        System.out.println("Please input status(0.can not use, 1.can use): ");
        boolean status = scanner.nextInt()==1?true:false;

        SportFacility sportFacility = new SportFacility(code,name,status);
        sportFacilitiesRepository.update(sportFacility);
        System.out.println("Update success!");
    }

    //delete
    public void deleteSportFacilities(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input code: ");
        String code = scanner.next();

        //check code is exist
        while (sportFacilitiesRepository.search(code,null) == null){
            System.out.println("Code is not exist, please input again!");
            code = scanner.next();
        }

        sportFacilitiesRepository.delete(code);
        System.out.println("Delete success!");
    }


    public void showAllBookSportFacilities(){
        bookSportFacilitiesRepository.showAll();
    }

    public void bookSportFacilities(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input student ID: ");
        String studentID = scanner.next();

        //check student ID is exist
        while (studentRepository.search(studentID) == null){
            System.out.println("Student ID is not exist, please input again!");
            studentID = scanner.next();
        }

        System.out.println("Please input facility code: ");
        String facilityCode = scanner.next();

        //check facility code is exist
        while (sportFacilitiesRepository.search(facilityCode,null) == null){
            System.out.println("Facility code is not exist, please input again!");
            facilityCode = scanner.next();
        }

        System.out.println("Please input start time (yyyy-MM-dd HH:mm:ss): ");
        String start = scanner.next();

        System.out.println("Please input end time (yyyy-MM-dd HH:mm:ss): ");
        String end = scanner.next();

        BookSportFacility bookSportFacilities = new BookSportFacility(bookSportFacilitiesRepository.getLastId()+1,studentID,facilityCode, CommonTool.convertStringToDate(start),CommonTool.convertStringToDate(end));
        bookSportFacilitiesRepository.book(bookSportFacilities);
        System.out.println("Book success!");
    }

    public void cancelBookSportFacilities(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input book id: ");
        int id = scanner.nextInt();

        bookSportFacilitiesRepository.cancel(id);
        System.out.println("Cancel book success!");
    }


    //save function
    public void save(){
        sportFacilitiesRepository.save();
        bookSportFacilitiesRepository.save();
    }
}
