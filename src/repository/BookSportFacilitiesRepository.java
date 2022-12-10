package repository;

import domain.BookSportFacility;

import java.util.ArrayList;
import java.util.List;

public interface BookSportFacilitiesRepository extends Repository {
    public ArrayList<BookSportFacility> searchByFacilityCode(String keyword);
    public ArrayList<BookSportFacility> searchByStudentId(String keyword);
    public void book(BookSportFacility bookSportFacility);
    public void cancel(int id);
    public int getLastId();
}
