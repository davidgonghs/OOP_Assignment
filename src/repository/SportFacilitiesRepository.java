package repository;

import domain.SportFacility;

public interface SportFacilitiesRepository extends Repository {
    public void add(SportFacility sportFacility);
    public void update(SportFacility sportFacility);
    public void delete(String code);
}
