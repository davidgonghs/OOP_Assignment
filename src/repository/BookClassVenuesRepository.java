package repository;

import domain.BookClassVenue;
import domain.BookSportFacility;
import domain.ClassVenue;

import java.util.List;

public interface BookClassVenuesRepository extends Repository {
    public List<BookClassVenue> searchByCode(String keyword);
    public List<BookClassVenue> searchByStudentId(String keyword);
    public void book(BookClassVenue bookClassVenue);
    public void cancel(int id);
    public int getLastId();
}
