package com.domain;

public class SportsFacilities implements CSVClass{
    private String studentNumber;
    private String sportName;
    private int courtNum;
    private String bookingDay;
    private String bookingTime;

    public SportsFacilities() {
    }

    public SportsFacilities(String studentNumber, String sportName, int courtNum, String bookingDay, String bookingTime) {
        this.studentNumber = studentNumber;
        this.sportName = sportName;
        this.courtNum = courtNum;
        this.bookingDay = bookingDay;
        this.bookingTime = bookingTime;
    }


    @Override
    public String toString() {
        return "SportsFacilities Booking Details: {" +
                "studentNumber='" + studentNumber + '\'' +
                ", sportName='" + sportName + '\'' +
                ", courtNum=" + courtNum +
                ", bookingDay='" + bookingDay + '\'' +
                ", bookingTime='" + bookingTime + '\'' +
                '}';
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public int getCourtNum() {
        return courtNum;
    }

    public void setCourtNum(int courtNum) {
        this.courtNum = courtNum;
    }

    public String getBookingDay() {
        return bookingDay;
    }

    public void setBookingDay(String bookingDay) {
        this.bookingDay = bookingDay;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    @Override
    public String toCSV() {
        return studentNumber+","+sportName+","+courtNum+","+bookingDay+","+bookingTime;
    }

    @Override
    public void fromCSV(String csv) {
        String[] data = csv.split(",");
        studentNumber = data[0];
        sportName = data[1];
        courtNum = Integer.parseInt(data[2]);
        bookingDay = data[3];
        bookingTime = data[4];
    }
}

