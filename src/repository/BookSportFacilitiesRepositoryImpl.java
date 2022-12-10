package repository;

import domain.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BookSportFacilitiesRepositoryImpl implements BookSportFacilitiesRepository {

    private static String bookSportFacilitiesDataPath = "src/data/bookSportFacilities.csv";

    Map<String, ArrayList<String>> bookSportFacilitiesMap = new HashMap<>();

    @Override
    public void SearchByFacilityCode(String keyword) {

    }

    @Override
    public void SearchByStudentId(String keyword) {

    }

    @Override
    public void book(String studentNumber, String code) {

    }

    @Override
    public void cancel(String studentNumber, String code) {

    }

    @Override
    public void initialize() {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(bookSportFacilitiesDataPath))) {
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }
                String[] data = line.split(",");
                String code = data[0];
                String studentNumber = data[1];
                //code,studentName,startTime,endTime
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAll() {

    }

    @Override
    public void save() {

    }
}
