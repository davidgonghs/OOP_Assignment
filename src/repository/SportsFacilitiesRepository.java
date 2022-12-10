package repository;

import domain.SportsFacilities;

import java.util.ArrayList;
public interface SportsFacilitiesRepository extends Repository{
    public ArrayList<SportsFacilities> search(String keyword);
    public void add(SportsFacilities csvClass);
    public void delete(String studentNumber, String sportName, int courtNum, String bookingDay, String bookingTime);
//    public void delete(String studentNumber, String sportName);

}

