package repository;

import domain.BookSportFacility;

public interface BookSportFacilitiesRepository extends Repository {
    public void SearchByFacilityCode(String keyword);
    public void SearchByStudentId(String keyword);
    public void book(BookSportFacility bookSportFacility);
    public void cancel(String studentNumber, String code);
    public int getLastId();
}
