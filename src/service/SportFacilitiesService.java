package service;

import repository.BookSportFacilitiesRepository;
import repository.SportFacilitiesRepository;
import repository.StudentRepository;
import repository.StudentResultRepository;

import java.util.Scanner;

public class SportFacilitiesService extends Service{


    private SportFacilitiesRepository sportFacilitiesRepository;

    private BookSportFacilitiesRepository bookSportFacilitiesRepository;

    //constructor
    public SportFacilitiesService(SportFacilitiesRepository sportFacilitiesRepository, BookSportFacilitiesRepository bookSportFacilitiesRepository) {
        this.sportFacilitiesRepository = sportFacilitiesRepository;
        this.bookSportFacilitiesRepository = bookSportFacilitiesRepository;
    }

    //show menu function
    public void showMenu(){
        String[] menu = {"1.Search Sport Facilities", "2.Show All Sport Facilities",
                "3.Add Sport Facilities", "4.Update Sport Facilities",
                "5.Delete Sport Facilities","6.Book Sport Facilities","7.Cancel Book Sport Facilities","8.Exit"};

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
                    //book
                    bookSportFacilities();
                    System.out.println();
                    break;
                case 7:
                    //cancel book
                    cancelBookSportFacilities();
                    System.out.println();
                    break;
                case 8:
                    //exit
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
        String code = "";
        String name = "";

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






    }

    //search book sport facilities by student number
    public void searchBookSportFacilities(){}


    //show all
    public void showAllSportFacilities(){
        sportFacilitiesRepository.showAll();
    }

    //add
    public void addSportFacilities(){}

    //update
    public void updateSportFacilities(){}

    //delete
    public void deleteSportFacilities(){}


    public void showAllBookSportFacilities(){
        bookSportFacilitiesRepository.showAll();
    }

    public void bookSportFacilities(){}

    public void cancelBookSportFacilities(){}



    //save function
    public void save(){
        sportFacilitiesRepository.save();
        bookSportFacilitiesRepository.save();
    }
}
