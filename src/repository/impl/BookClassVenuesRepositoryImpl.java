package repository.impl;

import domain.BookClassVenue;
import domain.BookSportFacility;
import domain.ClassVenue;
import repository.BookClassVenuesRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookClassVenuesRepositoryImpl implements BookClassVenuesRepository {

    private static String bookClassVenuesDataPath = "src/data/bookClassVenues.csv";

    Map<String, ArrayList<BookClassVenue>> bookClassVenuesMap = new HashMap<>();

    private int lastId = 0;


    @Override
    public void initialize() {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(bookClassVenuesDataPath))) {
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }
                BookClassVenue bookClassVenue = new BookClassVenue();
                bookClassVenue.fromCSV(line);

                if (bookClassVenuesMap.containsKey(bookClassVenue.getVenueCode())) {
                    bookClassVenuesMap.get(bookClassVenue.getVenueCode()).add(bookClassVenue);
                } else {
                    ArrayList<BookClassVenue> bookClassVenueList = new ArrayList<>();
                    bookClassVenueList.add(bookClassVenue);
                    bookClassVenuesMap.put(bookClassVenue.getVenueCode(), bookClassVenueList);
                }
                lastId = bookClassVenue.getId();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAll() {
        for (Map.Entry<String, ArrayList<BookClassVenue>> entry : bookClassVenuesMap.entrySet()) {
            for (BookClassVenue bookClassVenue : entry.getValue()) {
                System.out.println(bookClassVenue.toCSV());
            }
        }
    }

    @Override
    public void save() {
        try {
            File file = new File(bookClassVenuesDataPath);
            BufferedWriter writeText = new BufferedWriter(new FileWriter(file));
            //studentNumber + "," + name + "," + age + ","  + email + "," + phone + "," + programme;
            //write header
            writeText.write("id,code,studentId,startTime,endTime");
            for(Map.Entry<String, ArrayList<BookClassVenue>> entry : bookClassVenuesMap.entrySet()) {
                for (BookClassVenue bookClassVenue : entry.getValue()) {
                    writeText.newLine();
                    writeText.write(bookClassVenue.toCSV());
                }
            }
            writeText.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public List<BookClassVenue> searchByCode(String keyword) {
        if(  bookClassVenuesMap.containsKey(keyword)) {
            return bookClassVenuesMap.get(keyword);
        }

        return null;
    }

    @Override
    public List<BookClassVenue> searchByStudentId(String keyword) {
        List<BookClassVenue> bookClassVenueList = new ArrayList<>();
        for (Map.Entry<String, ArrayList<BookClassVenue>> entry : bookClassVenuesMap.entrySet()) {
            for (BookClassVenue bookClassVenue : entry.getValue()) {
                if (bookClassVenue.getStudentId().equals(keyword)) {
                    bookClassVenueList.add(bookClassVenue);
                }
            }
        }
        return bookClassVenueList;
    }

    @Override
    public void book(BookClassVenue bookClassVenue) {
        lastId+=1;
        bookClassVenue.setId(lastId);
        if (bookClassVenuesMap.containsKey(bookClassVenue.getVenueCode())) {
            bookClassVenuesMap.get(bookClassVenue.getVenueCode()).add(bookClassVenue);
        } else {
            ArrayList<BookClassVenue> bookClassVenueList = new ArrayList<>();
            bookClassVenueList.add(bookClassVenue);
            bookClassVenuesMap.put(bookClassVenue.getVenueCode(), bookClassVenueList);
        }
    }

    @Override
    public void cancel(int id) {
        for (Map.Entry<String, ArrayList<BookClassVenue>> entry : bookClassVenuesMap.entrySet()) {
            for (BookClassVenue bookClassVenue : entry.getValue()) {
                if (bookClassVenue.getId() == id) {
                    bookClassVenuesMap.get(bookClassVenue.getVenueCode()).remove(bookClassVenue);
                    return;
                }
            }
        }
    }

    @Override
    public int getLastId() {
        return lastId;
    }
}
