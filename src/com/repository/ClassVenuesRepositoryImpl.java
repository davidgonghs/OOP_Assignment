package com.repository;

import com.domain.ClassVenues;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassVenuesRepositoryImpl implements ClassVenuesRepository {

    private static String classVenuesDataPath = "src/com.data/classVenues.csv";

    private Map<String, List<ClassVenues>> classVenuesMap = new HashMap<>();
    //    public ArrayList<SportsFacilities> sportsBooking =
    public static ArrayList<ClassVenues> classVenuesBooking= new ArrayList<ClassVenues>();

    //get student result com.data from file
    public void initialize() {
        //get student result com.data from file
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(classVenuesDataPath))) {
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }

                // use comma as separator
                ClassVenues classVenues = new ClassVenues();

                classVenues.fromCSV(line);

                if (classVenuesMap.containsKey(classVenues.getStudentNumber())) {
                    classVenuesMap.get(classVenues.getStudentNumber()).add(classVenues);
                    classVenuesBooking.add(classVenues);

                } else {
                    //create student result list
                    List<ClassVenues> classVenuesList= new ArrayList<>();
                    //add student result to student result list
                    classVenuesList.add(classVenues);
                    classVenuesBooking.add(classVenues);
                    //add student result list to student result map
                    classVenuesMap.put(classVenues.getStudentNumber(),classVenuesList);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ArrayList<ClassVenues> search(String keyword) {
        if (classVenuesMap.containsKey(keyword)) {
            return (ArrayList<ClassVenues>) classVenuesMap.get(keyword);
        } else {
            return null;
        }
    }

    @Override
    public void add(ClassVenues csvClass) {
        //add student booking to classVenues map
        if (classVenuesMap.containsKey(csvClass.getStudentNumber())) {
            classVenuesMap.get(csvClass.getStudentNumber()).add(csvClass);
            classVenuesBooking.add(csvClass);
        } else {
            List<ClassVenues> classBookingList = new ArrayList<>();
            classBookingList.add(csvClass);
            classVenuesBooking.add(csvClass);
            classVenuesMap.put(csvClass.getStudentNumber(), classBookingList);
        }
    }

    @Override
    public void delete(String _studentNumber, String _venue, int _classCode, String _bookingDay, String _bookingTime) {
        if (classVenuesMap.containsKey(_studentNumber)) {
            List<ClassVenues> classVenuesList = classVenuesMap.get(_studentNumber);
            for (int i = 0; i < classVenuesList.size(); i++) {
                if (classVenuesList.get(i).getStudentNumber().equals(_studentNumber) &&
                        classVenuesList.get(i).getVenue().equals(_venue) &&
                        classVenuesList.get(i).getClassCode() == _classCode &&
                        classVenuesList.get(i).getBookingDay().equals(_bookingDay) &&
                        classVenuesList.get(i).getBookingTime().equals(_bookingTime)) {

                    classVenuesList.remove(i);
                    System.out.println("Alert: Cancelation successful!");
                    break;
                }

                if (i==classVenuesList.size()-1 &&
                        !(classVenuesList.get(i).getStudentNumber().equals(_studentNumber) &&
                                classVenuesList.get(i).getVenue().equals(_venue) &&
                                classVenuesList.get(i).getClassCode() == _classCode &&
                                classVenuesList.get(i).getBookingDay().equals(_bookingDay) &&
                                classVenuesList.get(i).getBookingTime().equals(_bookingTime))) {
                    System.out.println("Alert: Inputed details for cancelation do not match, please try again.");
                    break;
                }
            }
        }
    }

    @Override
    public void showAll() {
        for (Map.Entry<String, List<ClassVenues>> entry : classVenuesMap.entrySet()) {
            for (ClassVenues classVenues : entry.getValue()) {
                System.out.println(classVenues.toString());
            }
        }
    }

    @Override
    public void save() {
        try{
            //save student result com.data to file
            File file = new File(classVenuesDataPath);
            BufferedWriter writeText = new BufferedWriter(new FileWriter(file));

            writeText.write("studentNumber,venueName,classCode,bookingDay,bookingTime");

            //loop student result map
            for (List<ClassVenues> classVenuesList : classVenuesMap.values()) {
                //loop student result list
                for (ClassVenues classVenues :classVenuesList) {
                    writeText.newLine();
                    writeText.write(classVenues.toCSV());
                }
            }
            writeText.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, List<ClassVenues>> getClassVenuesMap() {
        return classVenuesMap;
    }

    public static ArrayList<ClassVenues> getClassVenuesBooking() {
        return classVenuesBooking;
    }

}
