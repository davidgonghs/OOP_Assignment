package repository;

import domain.SportFacility;
import domain.Student;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SportFacilitiesRepositoryImpl implements SportFacilitiesRepository {

    private static String sportFacilitiesDataPath = "src/data/sportFacilities.csv";

    Map<String, SportFacility> sportFacilityMap = new HashMap<>();

    @Override
    public SportFacility search(String code) {
        if (sportFacilityMap.containsKey(code)) {
            return sportFacilityMap.get(code);
        } else {
            return null;
        }
    }

    @Override
    public void add(SportFacility sportFacility) {
        sportFacilityMap.put(sportFacility.getCode(), sportFacility);
    }

    @Override
    public void update(SportFacility sportFacility) {
        sportFacilityMap.put(sportFacility.getCode(), sportFacility);
    }

    @Override
    public void delete(String code) {
        sportFacilityMap.remove(code);
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
        for (Map.Entry<String, SportFacility> entry : sportFacilityMap.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }

    @Override
    public void save() {
        try {
            File file = new File(sportFacilitiesDataPath);
            BufferedWriter writeText = new BufferedWriter(new FileWriter(file));
            //studentNumber + "," + name + "," + age + ","  + email + "," + phone + "," + programme;
            //write header
            writeText.write("code,facilityName,status");
            for (SportFacility sportFacility : sportFacilityMap.values()) {
                writeText.newLine();
                writeText.write(sportFacility.toCSV());
            }
            writeText.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
