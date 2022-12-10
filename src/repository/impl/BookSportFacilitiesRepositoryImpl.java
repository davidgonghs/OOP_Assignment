package repository.impl;

import domain.BookSportFacility;
import domain.Student;
import repository.BookSportFacilitiesRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BookSportFacilitiesRepositoryImpl implements BookSportFacilitiesRepository {

    private static String bookSportFacilitiesDataPath = "src/data/bookSportFacilities.csv";

    Map<String, ArrayList<BookSportFacility>> bookSportFacilitiesMap = new HashMap<>();

    private int lastId = 0;

    public int getLastId() {
        return lastId;
    }

    @Override
    public void SearchByFacilityCode(String keyword) {
        if (bookSportFacilitiesMap.containsKey(keyword)) {
            for (BookSportFacility bookSportFacility : bookSportFacilitiesMap.get(keyword)) {
                System.out.println(bookSportFacility.toString());
            }
        } else {
            System.out.println("No record found");
        }
    }

    @Override
    public void SearchByStudentId(String keyword) {
        for (Map.Entry<String, ArrayList<BookSportFacility>> entry : bookSportFacilitiesMap.entrySet()) {
            for (BookSportFacility bookSportFacility : entry.getValue()) {
                if (bookSportFacility.getSudentId().equals(keyword)) {
                    System.out.println(bookSportFacility.toString());
                }
            }
        }
    }

    @Override
    public void book(BookSportFacility bookSportFacility) {
        if (bookSportFacilitiesMap.containsKey(bookSportFacility.getSportFacilityCode())) {
            bookSportFacilitiesMap.get(bookSportFacility.getSportFacilityCode()).add(bookSportFacility);
        } else {
            ArrayList<BookSportFacility> bookSportFacilities = new ArrayList<>();
            bookSportFacilities.add(bookSportFacility);
            bookSportFacilitiesMap.put(bookSportFacility.getSportFacilityCode(), bookSportFacilities);
        }
    }

    @Override
    public void cancel(String sudentId, String code) {
        if (bookSportFacilitiesMap.containsKey(code)) {
            for (BookSportFacility bookSportFacility : bookSportFacilitiesMap.get(code)) {
                if (bookSportFacility.getSudentId().equals(sudentId)) {
                    bookSportFacilitiesMap.get(code).remove(bookSportFacility);
                    break;
                }
            }
        }
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
                BookSportFacility bookSportFacility = new BookSportFacility();
                bookSportFacility.fromCSV(line);

                if (bookSportFacilitiesMap.containsKey(bookSportFacility.getSportFacilityCode())) {
                    bookSportFacilitiesMap.get(bookSportFacility.getSportFacilityCode()).add(bookSportFacility);
                } else {
                    ArrayList<BookSportFacility> bookSportFacilities = new ArrayList<>();
                    bookSportFacilities.add(bookSportFacility);
                    bookSportFacilitiesMap.put(bookSportFacility.getSportFacilityCode(), bookSportFacilities);
                }
                lastId = bookSportFacility.getId();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAll() {
        for (String key : bookSportFacilitiesMap.keySet()) {
            System.out.println("Sport Facility Code: " + key);
            for (BookSportFacility bookSportFacility : bookSportFacilitiesMap.get(key)) {
                System.out.println(bookSportFacility.toCSV());
            }
        }
    }

    @Override
    public void save() {
        try {
            File file = new File(bookSportFacilitiesDataPath);
            BufferedWriter writeText = new BufferedWriter(new FileWriter(file));
            //studentNumber + "," + name + "," + age + ","  + email + "," + phone + "," + programme;
            //write header
            writeText.write("id,code,facilityName,status");
            for (Map.Entry<String, ArrayList<BookSportFacility>> entry : bookSportFacilitiesMap.entrySet()) {
                for (BookSportFacility bookSportFacility : entry.getValue()) {
                    writeText.newLine();
                    writeText.write(bookSportFacility.toCSV());
                }
            }
            writeText.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
