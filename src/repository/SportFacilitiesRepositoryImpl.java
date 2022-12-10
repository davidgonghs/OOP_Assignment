package repository;

import domain.SportFacility;
import domain.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SportFacilitiesRepositoryImpl implements SportFacilitiesRepository {

    private static String sportFacilitiesDataPath = "src/data/sportFacilities.csv";

    Map<String, SportFacility> sportFacilityMap = new HashMap<>();

    @Override
    public void add(SportFacility sportFacility) {

    }

    @Override
    public void update(SportFacility sportFacility) {

    }

    @Override
    public void delete(String code) {

    }

    @Override
    public void initialize() {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(sportFacilitiesDataPath))) {
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }
                SportFacility sportFacility = new SportFacility();
                sportFacility.fromCSV(line);
                sportFacilityMap.put(sportFacility.getCode(),sportFacility);
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
