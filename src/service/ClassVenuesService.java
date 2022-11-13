//<editor-fold desc="File Description">
// DESCRIPTION :
//       This file serves as a place to store functions
//
//  PUBLIC FUNCTIONS :
//       None
//
//  NOTES :
//       None
//
//  AUTHOR :    B1499 JEREMY PUN
//
//  CHANGES :
//       None
//</editor-fold>

package service;

import repository.ClassVenuesRepository;
import repository.StudentRepository;

public class ClassVenuesService implements Service{

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
