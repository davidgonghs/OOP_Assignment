package repository.impl;

import domain.ClassVenue;
import domain.SportFacility;
import domain.Student;
import repository.ClassVenuesRepository;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ClassVenuesRepositoryImpl implements ClassVenuesRepository {

    private static String classVenuesDataPath = "src/data/classVenues.csv";

    private Map<String, ClassVenue> venueMap = new HashMap<>();

    @Override
    public ClassVenue search(String code, String name) {
        if(code != null){
            return venueMap.get(code);
        }else{
            for(ClassVenue venue : venueMap.values()){
                if(venue.getClassVenuesName().equals(name)){
                    return venue;
                }
            }
        }
        return null;
    }

    @Override
    public void add(ClassVenue csvClass) {
        venueMap.put(csvClass.getCode(), csvClass);
    }

    @Override
    public void update(ClassVenue csvClass) {
        venueMap.put(csvClass.getCode(), csvClass);
    }

    @Override
    public void delete(String code) {
        venueMap.remove(code);
    }

    @Override
    public void initialize() {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(classVenuesDataPath))) {
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }
                ClassVenue classVenue = new ClassVenue();
                classVenue.fromCSV(line);
                venueMap.put(classVenue.getCode(),classVenue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAll() {
        for (Map.Entry<String, ClassVenue> entry : venueMap.entrySet()) {
            System.out.println(entry.getValue().toCSV());
        }
    }

    @Override
    public void save() {
        try {
            File file = new File(classVenuesDataPath);
            BufferedWriter writeText = new BufferedWriter(new FileWriter(file));
            //studentNumber + "," + name + "," + age + ","  + email + "," + phone + "," + programme;
            //write header
            writeText.write("code,classVenuesName,status");
            for (ClassVenue entry : venueMap.values()) {
                writeText.newLine();
                writeText.write(entry.toCSV());
            }
            writeText.close();
        }catch (IOException e) {
            e.printStackTrace();
        }


    }
}
