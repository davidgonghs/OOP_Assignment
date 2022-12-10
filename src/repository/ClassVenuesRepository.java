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

import domain.ClassVenue;

public interface ClassVenuesRepository extends Repository {
    public void add(ClassVenue csvClass);
    public void update(ClassVenue csvClass);
    public void delete(String code);
}
