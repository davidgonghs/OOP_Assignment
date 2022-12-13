//<editor-fold desc="File Description">
// DESCRIPTION :
//       This file serves as an object blueprint
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


package domain;


public class ClassVenues implements CSVClass {
    private String studentNumber;
    private String venueName;

    private int classCode;
    private String bookingDay;
    private String bookingTime;

    //Constructor
    public ClassVenues() {
    }

    public ClassVenues(String _studentNumber, String _venueName, int _classCode, String _bookingDay, String _bookingTime) {
        this.studentNumber = _studentNumber;
        this.venueName = _venueName;
        this.classCode = _classCode;
        this.bookingDay = _bookingDay;
        this.bookingTime = _bookingTime;
    }

    //Getter and setter methods
    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getVenue() {
        return venueName;
    }

    public void setVenue(String _venueName) {
        this.venueName = _venueName;
    }

    public int getClassCode() {
        return classCode;
    }

    public void setClassCode(int _classCode) {
        this.classCode = _classCode;
    }

    public String getBookingDay() {
        return bookingDay;
    }

    public void setBookingDay(String _bookingDay) {
        this.bookingDay = _bookingDay;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String _bookingTime) {
        this.bookingTime = _bookingTime;
    }

    @Override
    public String toCSV() {
        return studentNumber+","+venueName+","+classCode+","+bookingDay+","+bookingTime;
    }


    //Retrieve data from csv file
    @Override
    public void fromCSV(String csv) {
        String[] data = csv.split(",");

        studentNumber = data[0];
        venueName = data[1];
        classCode = Integer.parseInt(data[2]);
        bookingDay = data[3];
        bookingTime = data[4];
    }

    @Override
    public String toString() {
        return "Class Booking Details: {" +
                "1. Student Number : '" + studentNumber + '\'' +
                ", 2. Venue : '" + venueName + '\'' +
                ", 3. Class Code : " + classCode +
                ", 4. Booking Day :'" + bookingDay + '\'' +
                ", 5. Booking Time :'" + bookingTime + '\'' +
                '}';
    }
}
