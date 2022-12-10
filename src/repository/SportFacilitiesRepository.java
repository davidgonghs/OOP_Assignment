package repository;

import domain.SportFacility;

public interface SportFacilitiesRepository extends Repository {

    public SportFacility search(String code);
    public void add(SportFacility sportFacility);
    public void update(SportFacility sportFacility);
    public void delete(String code);
}
