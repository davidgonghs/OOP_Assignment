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

package com.service;

import com.domain.ClassVenues;
import com.repository.ClassVenuesRepository;
import com.repository.ClassVenuesRepositoryImpl;
import com.repository.StudentRepository;
import com.tool.CommonTool;

import java.util.*;

public class ClassVenuesService extends Service{

    private StudentRepository studentRepository;

    private ClassVenuesRepository classVenuesRepository;

    Scanner scanner= new Scanner(System.in);

    //constructor
    public ClassVenuesService(StudentRepository studentRepository, ClassVenuesRepository classVenuesRepository) {
        this.classVenuesRepository = classVenuesRepository;
        this.studentRepository = studentRepository;
    }


    @Override
    public void showMenu() {
        String[] menu = {"1.Search for Student Booking", "2.Show all Bookings", "3.Add booking", "4.Delete booking","5.Exit"};

        for (String s : menu) {
            System.out.println(s);
        }
    }

    @Override
    public void process() {
//show menu
        while (true){
            System.out.println("=================Manage Class Booking==================");
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
                    save();
                    System.out.println();
                    break;
                case 4:
                    //delete
                    delete();
                    save();
                    System.out.println();
                    break;
                case 5:
                    //exit
                    save();
                    System.out.println();
                    return;
                default:
                    System.out.println("Please choose correct menu");
                    System.out.println();
                    break;
            }


        }
    }

    @Override
    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input student number: ");
        String studentNumber = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Boookings made by student number " + studentNumber + ":");
        ArrayList<ClassVenues> classVenues = classVenuesRepository.search(studentNumber);
        if (classVenues == null){
            System.out.println("No result found");
        }else {
            //show student booking and calculate cgpa and semester gpa

            Map<String, String> studentNumVenueNameMap = new HashMap<>();
            Map<String, Integer> studentNumClassIdMap = new HashMap<>();
            Map<String, String> studentNumBookingDay = new HashMap<>();
            Map<String, String> studentNumBookingTime = new HashMap<>();


            for (ClassVenues classVenue : classVenues) {
                System.out.println(classVenue);
                if (studentNumVenueNameMap.containsKey(classVenue.getStudentNumber())){
                    studentNumVenueNameMap.put(classVenue.getStudentNumber(),  classVenue.getVenue());
                    studentNumClassIdMap.put(classVenue.getStudentNumber(), classVenue.getClassCode());
                    studentNumBookingDay.put(classVenue.getStudentNumber(), classVenue.getBookingDay());
                    studentNumBookingTime.put(classVenue.getStudentNumber(), classVenue.getBookingTime());

                }
            }

            //sort student Number with key
            ArrayList<String> studentNumList = new ArrayList<>(studentNumVenueNameMap.keySet());
            Collections.sort(studentNumList);
            for (String studentNum : studentNumList) {
                String venueName = studentNumVenueNameMap.get(studentNum);
                System.out.println("Student number " + studentNum + " Venue Name: " + venueName);
            }



        }

    }

    @Override
    public void showAll() {
        classVenuesRepository.showAll();
    }

    @Override
    public void add() {
        String venueName="";
        String bookingTimeName="";
        String bookingDayName="";
        int classCode=0;

        System.out.println("Please input student number: ");
        String studentNumber=scanner.nextLine();

        scanner.nextLine();

        //1. Check student number
        while (studentRepository.search(studentNumber) == null){
            System.out.println("Alert: Student number not found!");
            System.out.print("Please input student number: ");
            studentNumber = scanner.nextLine();
            scanner.nextLine();
        }

        //2. Select class
        System.out.println("Please select class: ");
        String[] classVenueNameMenu = {"1.IT Lab", "2.Engineering Lab", "3.Art studio", "4.Lecture hall"};
        for (String s : classVenueNameMenu) {
            System.out.println(s);
        }

        System.out.print("Option: ");
        int classNameCode = scanner.nextInt();

        scanner.nextLine();

        venueName  = CommonTool.classCodeToName(classNameCode);

        while (!CommonTool.isClassNameCodeValid(classNameCode)) {
            System.out.println("Alert: Please input a valid number!");
            classNameCode = scanner.nextInt();
            scanner.nextLine();
            venueName = CommonTool.classCodeToName(classNameCode);
        }
        System.out.println(venueName);

        //3. Select class number
        System.out.println("Please select Class Number: ");
        String[] classNumberMenu = {"1. Class 1", "2. Class 2"};

        for (String s : classNumberMenu) {
            System.out.println(s);
        }
        classCode = scanner.nextInt();
        scanner.nextLine();

        while (!CommonTool.isClassIdValid(classCode)) {
            System.out.println("Alert: Please input a valid number!");
            classCode = scanner.nextInt();
            scanner.nextLine();
        }

        //4. Select Booking Day
        System.out.println("Please select Booking Day: ");
        String[] bookingDayMenu = {"1. Monday", "2. Tuesday", "3. Wednesday", "4. Thursday", "5. Friday"};
        for (String s : bookingDayMenu) {
            System.out.println(s);
        }

        int bookingDayCode = scanner.nextInt();
        scanner.nextLine();

        while (!CommonTool.isBookingDayCodeValid(bookingDayCode)) {
            System.out.println("Alert: Please input a valid number!");
            bookingDayCode = scanner.nextInt();
            scanner.nextLine();
            bookingDayName = CommonTool.bookingDayCodeToName(bookingDayCode);
        }
        //5. Select Booking Time
        System.out.println("Please select Booking Time: ");
        String[] bookingTimeMenu = {"1. 2pm-3pm", "2. 4pm-5pm"};
        for (String s : bookingTimeMenu) {
            System.out.println(s);
        }
        int bookingTimeCode = scanner.nextInt();
        scanner.nextLine();

        bookingTimeName = CommonTool.bookingTimeCodeToName(bookingTimeCode);

        while (!CommonTool.isBookingTimeCodeValid(bookingTimeCode)) {
            System.out.println("Please input a valid number!");
            bookingTimeCode = scanner.nextInt();
            scanner.nextLine();
            bookingTimeName = CommonTool.bookingTimeCodeToName(bookingTimeCode);
        }
        //5. Add Booking or Booking Taken message
        if(ClassVenuesRepositoryImpl.getClassVenuesBooking().size() == 0){
            ClassVenues classVenues= new ClassVenues(studentNumber, venueName, classCode, bookingDayName, bookingTimeName);
            classVenuesRepository.add(classVenues);
            System.out.println("Alert: Your booking is successful!");

        } else{
            for(int i=0; i<ClassVenuesRepositoryImpl.getClassVenuesBooking().size(); i++) {
                if(ClassVenuesRepositoryImpl.getClassVenuesBooking().get(i).getVenue().equals(venueName) &&
                        ClassVenuesRepositoryImpl.getClassVenuesBooking().get(i).getClassCode() == classCode
                        && ClassVenuesRepositoryImpl.getClassVenuesBooking().get(i).getBookingDay().equals(bookingDayName) &&
                        ClassVenuesRepositoryImpl.getClassVenuesBooking().get(i).getBookingTime().equals(bookingTimeName)){
                    System.out.println("Alert: This reservation is already taken, please try another slot.");
                    break;
                }
                if(i==ClassVenuesRepositoryImpl.getClassVenuesBooking().size()-1 &&
                        !(ClassVenuesRepositoryImpl.getClassVenuesBooking().get(i).getVenue().equals(venueName) &&
                                ClassVenuesRepositoryImpl.getClassVenuesBooking().get(i).getClassCode() == classCode &&
                                ClassVenuesRepositoryImpl.getClassVenuesBooking().get(i).getBookingDay().equals(bookingDayName) &&
                                ClassVenuesRepositoryImpl.getClassVenuesBooking().get(i).getBookingTime().equals(bookingTimeName))){
                    ClassVenues classVenues = new ClassVenues(studentNumber, venueName,classCode, bookingDayName, bookingTimeName);
//                    SportsFacilitiesRepositoryImpl.getSportsBooking().add(sportsFacilities);
                    classVenuesRepository.add(classVenues);
                    System.out.println("Alert: Booking successful!");
                    break;
                }
            }
        }





    }

//    @Override
//    public void update() {
//
//    }

    @Override
    public void delete() {
        search();
        System.out.println("");
        System.out.println("Delete Student Booking: ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input student number again for cancelation: ");
        String studentNumber = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Please input venue name to be canceled: ");
        String venueName = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Please input class id to be canceled: ");
        int classCode = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please input booking day to be canceled: ");
        String bookingDay = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Please input booking time to be canceled: ");
        String bookingTime = scanner.nextLine();
        scanner.nextLine();

        classVenuesRepository.delete(studentNumber, venueName, classCode, bookingDay, bookingTime);

    }

    @Override
    public void save() {
        classVenuesRepository.save();
    }
}
