package service;

import repository.BookSportFacilitiesRepository;
import repository.SportFacilitiesRepository;
import repository.StudentRepository;
import repository.StudentResultRepository;

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

    public void process(){}

    //search
    public void searchSportFacilities(){}

    //search book sport facilities by student number
    public void searchBookSportFacilities(){}


    //show all
    public void showAllSportFacilities(){}

    //add
    public void addSportFacilities(){}

    //update
    public void updateSportFacilities(){}

    //delete
    public void deleteSportFacilities(){}


    public void showAllBookSportFacilities(){}

    public void bookSportFacilities(){}

    public void cancelBookSportFacilities(){}



    //save function
    public void save(){}
}
