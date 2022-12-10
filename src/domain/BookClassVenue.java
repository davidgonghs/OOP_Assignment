package domain;

import tool.CommonTool;

import java.util.Date;

public class BookClassVenue implements CSVClass {
    private int id;
    private String venueCode;
    private String studentId;
    private Date startTime;
    private Date endTime;

    public BookClassVenue() {
    }

    public BookClassVenue(String venueCode, String studentId, Date startTime, Date endTime) {
        this.venueCode = venueCode;
        this.studentId = studentId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public BookClassVenue(int id, String venueCode, String studentId, Date startTime, Date endTime) {
        this.id = id;
        this.venueCode = venueCode;
        this.studentId = studentId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVenueCode() {
        return venueCode;
    }

    public void setVenueCode(String venueCode) {
        this.venueCode = venueCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toCSV() {
        return id + "," + venueCode + "," + studentId + "," + CommonTool.convertDateToString(startTime) + "," + CommonTool.convertDateToString(endTime);
    }

    //toString
    public String toString() {
        return id + "," + venueCode + "," + studentId + "," + CommonTool.convertDateToString(startTime) + "," + CommonTool.convertDateToString(endTime);
    }


    @Override
    public void fromCSV(String csv) {
        String[] data = csv.split(",");
        id = Integer.parseInt(data[0]);
        venueCode = data[1];
        studentId = data[2];
        startTime = CommonTool.convertStringToDate(data[3]);
        endTime = CommonTool.convertStringToDate(data[4]);

    }
}
