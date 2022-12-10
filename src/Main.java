import repository.*;
import repository.impl.*;
import service.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //initialize
        StudentRepository studentRepository = new StudentRepositoryImpl();
        studentRepository.initialize();
        StudentResultRepository studentResultRepository = new StudentResultRepositoryImpl();
        studentResultRepository.initialize();
        ClassVenuesRepository classVenuesRepository = new ClassVenuesRepositoryImpl();
        classVenuesRepository.initialize();
        SportFacilitiesRepository sportFacilitiesRepository = new SportFacilitiesRepositoryImpl();
        sportFacilitiesRepository.initialize();
        BookSportFacilitiesRepository bookSportFacilitiesRepository = new BookSportFacilitiesRepositoryImpl();
        bookSportFacilitiesRepository.initialize();



        StudentService studentService = new StudentService(studentRepository);
        StudentResultService studentResultService = new StudentResultService(studentResultRepository, studentRepository);
        ClassVenuesService classVenuesService = new ClassVenuesService(studentRepository, classVenuesRepository);
        SportFacilitiesService sportFacilitiesService = new SportFacilitiesService(sportFacilitiesRepository, bookSportFacilitiesRepository);


        //show menu
        String[] menu = {"1.Manage Student","2.Class venues booking", "3.Sports facilities booking","4.Students’ results keeping", "5.Exit"};
        while (true){
            System.out.println("=================Main Menu==================");
            //show menu
            for (String s : menu) {
                System.out.println(s);
            }
            //choose menu
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please choose menu: ");
            int choose = scanner.nextInt();
            System.out.println();
            switch (choose){
                case 1:
                    //manage student
                    studentService.process();
                    System.out.println();
                    break;
                case 2:
                    //class venues booking
                    classVenuesService.process();
                    System.out.println();
                    break;
                case 3:
                    //sports facilities booking
                    sportFacilitiesService.process();
                    System.out.println();
                    break;
                case 4:
                    //students’ results keeping
                    studentResultService.process();
                    System.out.println();
                    break;
                case 5:
                    //exit
                    System.exit(0);
                    System.out.println();
                    break;
                default:
                    System.out.println("Please choose correct menu");
                    System.out.println();
                    break;
            }

        }
    }
}