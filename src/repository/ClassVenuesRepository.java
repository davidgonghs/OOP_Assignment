package repository;

import domain.ClassVenues;

public interface ClassVenuesRepository extends Repository {
    public void add(ClassVenues csvClass);
    public void update(ClassVenues csvClass);
    public void delete(String code);
}
