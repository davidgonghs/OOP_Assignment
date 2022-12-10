package repository;

import domain.ClassVenue;

public interface BookClassVenuesRepository extends Repository {
    public void add(ClassVenue csvClass);
    public void update(ClassVenue csvClass);
    public void delete(String code);
}
