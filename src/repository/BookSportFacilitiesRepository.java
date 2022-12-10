package repository;

public interface BookSportFacilitiesRepository extends Repository {
    public void SearchByFacilityCode(String keyword);
    public void SearchByStudentId(String keyword);
    public void book(String studentNumber, String code);
    public void cancel(String studentNumber, String code);
}
