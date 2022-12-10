package repository;

import domain.SportsFacilities;
import domain.StudentResult;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SportsFacilitiesRepositoryImpl implements SportsFacilitiesRepository{
    private static String sportsFacilitiesDataPath = "src/data/sportsFacilities.csv";

    //student result map  <StudentNumber,result list>
    private Map<String, List<SportsFacilities>> sportsFacilitiesMap = new HashMap<>();
//    public ArrayList<SportsFacilities> sportsBooking =
    public static ArrayList<SportsFacilities> sportsBooking = new ArrayList<SportsFacilities>();



    //initialize function
    public void initialize() {
        //get student result data from file
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(sportsFacilitiesDataPath))) {
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }

                // use comma as separator
                SportsFacilities sportsFacilities = new SportsFacilities();
                sportsFacilities.fromCSV(line);
                //create sports facility object
                //check sports facility map contains student number
                if (sportsFacilitiesMap.containsKey(sportsFacilities.getStudentNumber())) {
                    //add student result to student result list
                    sportsFacilitiesMap.get(sportsFacilities.getStudentNumber()).add(sportsFacilities);
                    sportsBooking.add(sportsFacilities);
                } else {
                    //create student result list
                    List<SportsFacilities> sportsFacilitiesList = new ArrayList<>();
                    //add student result to student result list
                    sportsFacilitiesList.add(sportsFacilities);
                    sportsBooking.add(sportsFacilities);
                    //add student result list to student result map
                    sportsFacilitiesMap.put(sportsFacilities.getStudentNumber(), sportsFacilitiesList);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAll() {
        for (Map.Entry<String, List<SportsFacilities>> entry : sportsFacilitiesMap.entrySet()) {
            for (SportsFacilities sportsFacilities : entry.getValue()) {
                System.out.println(sportsFacilities.toString());
            }
        }
    }

    //save function
    public void save() {
        try{
            //save student result data to file
            File file = new File(sportsFacilitiesDataPath);
            BufferedWriter writeText = new BufferedWriter(new FileWriter(file));

            writeText.write("studentNumber,sportName,courtNumber,bookingDay,bookingTime");

            //loop student result map
            for (List<SportsFacilities> sportsFacilitiesList : sportsFacilitiesMap.values()) {
                //loop student result list
                for (SportsFacilities sportsFacilities : sportsFacilitiesList) {
                    writeText.newLine();
                    writeText.write(sportsFacilities.toCSV());
                }
            }
            writeText.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<SportsFacilities> search(String keyword) {
        //search student booking by student number
        if (sportsFacilitiesMap.containsKey(keyword)) {
            return (ArrayList<SportsFacilities>) sportsFacilitiesMap.get(keyword);
        } else {
            return null;
        }
    }

    @Override
    public void add(SportsFacilities csvClass) {
        //add student booking to sports booking map
        if (sportsFacilitiesMap.containsKey(csvClass.getStudentNumber())) {
            sportsFacilitiesMap.get(csvClass.getStudentNumber()).add(csvClass);
            sportsBooking.add(csvClass);
        } else {
            List<SportsFacilities> sportsFacilitiesList = new ArrayList<>();
            sportsFacilitiesList.add(csvClass);
            sportsBooking.add(csvClass);
            sportsFacilitiesMap.put(csvClass.getStudentNumber(), sportsFacilitiesList);
        }
    }

    @Override
    public void delete(String studentNumber, String sportName, int courtNum, String bookingDay, String bookingTime) {
        //delete student booking from student sports booking map
        if (sportsFacilitiesMap.containsKey(studentNumber)) {
            List<SportsFacilities> sportsFacilitiesList = sportsFacilitiesMap.get(studentNumber);
            for (int i = 0; i < sportsFacilitiesList.size(); i++) {
//                if (sportsFacilitiesList.get(i).getStudentNumber().equals(studentNumber) ) {
                if (sportsFacilitiesList.get(i).getStudentNumber().equals(studentNumber) && sportsFacilitiesList.get(i).getSportName().equals(sportName) && sportsFacilitiesList.get(i).getCourtNum() == courtNum && sportsFacilitiesList.get(i).getBookingDay().equals(bookingDay) && sportsFacilitiesList.get(i).getBookingTime().equals(bookingTime)) {
                    sportsFacilitiesList.remove(i);
                    System.out.println("Cancelation successful!");
                    break;
//                    i--;
                }

                if (i==sportsFacilitiesList.size()-1 && !(sportsFacilitiesList.get(i).getStudentNumber().equals(studentNumber) && sportsFacilitiesList.get(i).getSportName().equals(sportName) && sportsFacilitiesList.get(i).getCourtNum() == courtNum && sportsFacilitiesList.get(i).getBookingDay().equals(bookingDay) && sportsFacilitiesList.get(i).getBookingTime().equals(bookingTime))) {
                    System.out.println("Inputed details for cancelation do not match, please try again.");
                    break;
//                    i--;
                }
            }
        }
    }

    public Map<String, List<SportsFacilities>> getSportsFacilitiesMap() {
        return sportsFacilitiesMap;
    }

    public static ArrayList<SportsFacilities> getSportsBooking() {
        return sportsBooking;
    }
}
