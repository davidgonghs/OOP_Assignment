package com.service;

import com.domain.SportsFacilities;
import com.repository.SportsFacilitiesRepository;
import com.repository.SportsFacilitiesRepositoryImpl;
import com.repository.StudentRepository;
import com.tool.CommonTool;
import java.util.ArrayList;

import java.util.*;

public class SportsFacilitiesService extends Service{
    private SportsFacilitiesRepository sportsFacilitiesRepository;

    private StudentRepository studentRepository;

//    public static ArrayList<SportsFacilities> sportsBookings = new ArrayList<SportsFacilities>();


    //constructor
    public SportsFacilitiesService(SportsFacilitiesRepository sportsFacilitiesRepository, StudentRepository studentRepository) {
        this.sportsFacilitiesRepository = sportsFacilitiesRepository;
        this.studentRepository = studentRepository;
    }


    @Override
    public void showMenu() {
//        String[] menu = {"1.Search Student Result", "2.Show All Student Result", "3.Add Student Result", "4.Update Student Result", "5.Delete Student Result","6.Exit"};
        String[] menu = {"1.Search for Student Booking", "2.Show all Bookings", "3.Add booking", "4.Delete booking","5.Exit"};

        for (String s : menu) {
            System.out.println(s);
        }
    }


    @Override
    public void process() {
        //show menu
        while (true){
            System.out.println("=================Manage Student Sports Facilities Booking==================");
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
        ArrayList<SportsFacilities> sportsFacilities = sportsFacilitiesRepository.search(studentNumber);
        if (sportsFacilities == null){
            System.out.println("No result found");
        }else {
            //show student booking and calculate cgpa and semester gpa

            Map<String, String> studentNumSportsNameMap = new HashMap<>();
            Map<String, Integer> studentNumCourtNumMap = new HashMap<>();
            Map<String, String> studentNumBookingDay = new HashMap<>();
            Map<String, String> studentNumBookingTime = new HashMap<>();


            for (SportsFacilities sportsFacility : sportsFacilities) {
                System.out.println(sportsFacility);
                if (studentNumSportsNameMap.containsKey(sportsFacility.getStudentNumber())){
                    studentNumSportsNameMap.put(sportsFacility.getStudentNumber(),  sportsFacility.getSportName());
                    studentNumCourtNumMap.put(sportsFacility.getStudentNumber(), sportsFacility.getCourtNum());
                    studentNumBookingTime.put(sportsFacility.getStudentNumber(), sportsFacility.getBookingDay());
                    studentNumBookingTime.put(sportsFacility.getStudentNumber(), sportsFacility.getBookingTime());

                }
            }

            //sort student Number with key
            ArrayList<String> studentNumList = new ArrayList<>(studentNumSportsNameMap.keySet());
            Collections.sort(studentNumList);
            for (String studentNum : studentNumList) {
                String sportsName = studentNumSportsNameMap.get(studentNum);
                System.out.println("Student number " + studentNum + " Sport Facility Name: " + sportsName);
            }



        }
    }

    @Override
    public void showAll() {
        sportsFacilitiesRepository.showAll();
    }

    @Override
    public void add() {
        String sportsFacilityName = "";
        String bookingTimeName = "";
        String bookingDayName = "";
        int courtNumCode;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input student number: ");
        String studentNumber = scanner.nextLine();
        scanner.nextLine();

        //check student number
        while (studentRepository.search(studentNumber) == null){
            System.out.println("Student number not found!");
            System.out.println("Please input student number: ");
            studentNumber = scanner.nextLine();
            scanner.nextLine();
        }

        /////////////////////////////////////////////
        //Select Sports Name

        System.out.println("Please select Sports Facility Name: ");
        String[] sportsNameMenu = {"1.Basketball", "2.Tennis", "3.Badminton", "4.Futsal"};
        for (String s : sportsNameMenu) {
            System.out.println(s);
        }
        int sportsNameCode = scanner.nextInt();
        scanner.nextLine();

        sportsFacilityName = CommonTool.sportsNameCodeToName(sportsNameCode);

        while (!CommonTool.isSportsNameCodeValid(sportsNameCode)) {
            System.out.println("Please input a valid number!");
            sportsNameCode = scanner.nextInt();
            scanner.nextLine();
            sportsFacilityName = CommonTool.sportsNameCodeToName(sportsNameCode);
        }
        System.out.println(sportsFacilityName);


        ///////////////////////////////////////////////////////
        //Select Court Number
        System.out.println("Please select Court Number: ");
        String[] courtNumberMenu = {"1. Court 1", "2. Court 2"};

        for (String s : courtNumberMenu) {
            System.out.println(s);
        }
        courtNumCode = scanner.nextInt();
        scanner.nextLine();

        while (!CommonTool.isCourtNumValid(courtNumCode)) {
            System.out.println("Please input a valid number!");
            courtNumCode = scanner.nextInt();
            scanner.nextLine();
        }

        ///////////////////////////////////////////////////////
        //Select Booking Day
        System.out.println("Please select Booking Day: ");
        String[] bookingDayMenu = {"1. Monday", "2. Tuesday", "3. Wednesday", "4. Thursday", "5. Friday"};
        for (String s : bookingDayMenu) {
            System.out.println(s);
        }

        int bookingDayCode = scanner.nextInt();
        scanner.nextLine();

        bookingDayName = CommonTool.bookingDayCodeToName(bookingDayCode);

        while (!CommonTool.isBookingDayCodeValid(bookingDayCode)) {
            System.out.println("Please input a valid number!");
            bookingDayCode = scanner.nextInt();
            scanner.nextLine();
            bookingDayName = CommonTool.bookingDayCodeToName(bookingDayCode);
        }

        ////////////////////////////////////////////////
        //Select Booking Time
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

        ///////////////////////////////////////////////////
        //Add Booking or Booking Taken message
        if(SportsFacilitiesRepositoryImpl.getSportsBooking().size() == 0){
            SportsFacilities sportsFacilities = new SportsFacilities(studentNumber, sportsFacilityName, courtNumCode, bookingDayName, bookingTimeName);
//            sportsBookings.add(sportsFacilities);
            sportsFacilitiesRepository.add(sportsFacilities);
            System.out.println("Your booking is successful!");

        } else{
            for(int i=0; i<SportsFacilitiesRepositoryImpl.getSportsBooking().size(); i++) {
                if(SportsFacilitiesRepositoryImpl.getSportsBooking().get(i).getSportName().equals(sportsFacilityName) && SportsFacilitiesRepositoryImpl.getSportsBooking().get(i).getCourtNum() == courtNumCode && SportsFacilitiesRepositoryImpl.getSportsBooking().get(i).getBookingDay().equals(bookingDayName) && SportsFacilitiesRepositoryImpl.getSportsBooking().get(i).getBookingTime().equals(bookingTimeName)){
                    System.out.println("This reservation is already taken, please try another slot.");
                    break;
                }
                if(i==SportsFacilitiesRepositoryImpl.getSportsBooking().size()-1 && !(SportsFacilitiesRepositoryImpl.getSportsBooking().get(i).getSportName().equals(sportsFacilityName) && SportsFacilitiesRepositoryImpl.getSportsBooking().get(i).getCourtNum() == courtNumCode && SportsFacilitiesRepositoryImpl.getSportsBooking().get(i).getBookingDay().equals(bookingDayName) && SportsFacilitiesRepositoryImpl.getSportsBooking().get(i).getBookingTime().equals(bookingTimeName))){
                    SportsFacilities sportsFacilities = new SportsFacilities(studentNumber, sportsFacilityName, courtNumCode, bookingDayName, bookingTimeName);
//                    SportsFacilitiesRepositoryImpl.getSportsBooking().add(sportsFacilities);
                    sportsFacilitiesRepository.add(sportsFacilities);
                    System.out.println("Booking successful!");
                    break;
                }
            }
        }
    }


    @Override
    public void delete() {
        search();
        System.out.println("");
        System.out.println("Delete Student Booking: ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input student number again for cancelation: ");
        String studentNumber = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Please input sport name to be canceled: ");
        String sportName = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Please input court number to be canceled: ");
        int courtNum = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please input booking day to be canceled: ");
        String bookingDay = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Please input booking time to be canceled: ");
        String bookingTime = scanner.nextLine();
        scanner.nextLine();
//        sportsFacilitiesRepository.delete(studentNumber, sportName);

        sportsFacilitiesRepository.delete(studentNumber, sportName, courtNum, bookingDay, bookingTime);

    }

    @Override
    public void save() {
        sportsFacilitiesRepository.save();
    }
}

