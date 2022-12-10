package service;

import repository.ClassVenuesRepository;
import repository.StudentRepository;

public class ClassVenuesService extends Service{

    private StudentRepository studentRepository;

    private ClassVenuesRepository classVenuesRepository;

    //constructor
    public ClassVenuesService(StudentRepository studentRepository, ClassVenuesRepository classVenuesRepository) {
        this.studentRepository = studentRepository;
        this.classVenuesRepository = classVenuesRepository;
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

    }

    @Override
    public void search() {

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

    }
}
