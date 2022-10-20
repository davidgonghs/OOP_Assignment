package service;

import repository.StudentRepository;
import repository.StudentResultRepository;

public class StudentService implements Service {

    public StudentRepository studentRepository=new StudentRepository();

    //show menu function
    public void showMenu() {
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Update Student");
        System.out.println("4. View Student");
        System.out.println("5. Exit");
    }

    //initialize function
    public void initialize() {
        studentRepository.initialize();
    }

    //save function
    public void save() {
        studentRepository.save();
    }
    



}
