//<editor-fold desc="File Description">
// DESCRIPTION :
//       This file serves as a link to csv file, just save com.data and show com.data only
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
package com.repository;

import com.domain.ClassVenues;

import java.util.ArrayList;

public interface ClassVenuesRepository extends Repository {

    public ArrayList<ClassVenues> search(String keyword);

    public void add(ClassVenues csvClass);
//    public void update(ClassVenues csvClass);
    public void delete(String studentNumber, String venueName, int classCode, String bookingDay, String bookingTime );

}
