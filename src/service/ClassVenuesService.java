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
