package repository.impl;

import domain.ClassVenue;
import domain.Student;
import repository.ClassVenuesRepository;

import java.util.HashMap;
import java.util.Map;

public class ClassVenuesRepositoryImpl implements ClassVenuesRepository {

    private static String classVenuesDataPath = "src/data/classVenues.csv";

    private Map<String, ClassVenue> venueMap = new HashMap<>();

    @Override
    public void add(ClassVenue csvClass) {

    }

    @Override
    public void update(ClassVenue csvClass) {

    }

    @Override
    public void delete(String code) {

    }

    @Override
    public void initialize() {

    }

    @Override
    public void showAll() {

    }

    @Override
    public void save() {

    }
}
