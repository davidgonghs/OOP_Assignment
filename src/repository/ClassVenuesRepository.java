//<editor-fold desc="File Description">
// DESCRIPTION :
//       This file serves as a link to csv file, just save data and show data only
//
//  PUBLIC FUNCTIONS :
//       None
//
//  NOTES :
//       None
//
//  AUTHOR :    B1499 JEREMY PUN
//
//  CHANGES :
//       None
//</editor-fold>
package repository;

import domain.ClassVenues;

public interface ClassVenuesRepository extends Repository {
    public void add(ClassVenues csvClass);
    public void update(ClassVenues csvClass);
    public void delete(String code);
}
