package repository;

import domain.BookSportFacility;

public interface BookSportFacilitiesRepository extends Repository {
    public void searchByFacilityCode(String keyword);
    public void searchByStudentId(String keyword);
    public void book(BookSportFacility bookSportFacility);
    public void cancel(int id);
    public int getLastId();
}
