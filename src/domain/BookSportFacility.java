package domain;

import tool.CommonTool;

import java.util.Date;

public class BookSportFacility implements CSVClass {
    private String studentNumber;
    private String sportFacilityCode;
    private Date startTime;
    private Date endTime;



    public BookSportFacility() {
    }

    public BookSportFacility(String studentNumber, String sportFacilityCode, Date startTime, Date endTime) {
        this.studentNumber = studentNumber;
        this.sportFacilityCode = sportFacilityCode;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getSportFacilityCode() {
        return sportFacilityCode;
    }

    public void setSportFacilityCode(String sportFacilityCode) {
        this.sportFacilityCode = sportFacilityCode;
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
        return studentNumber + "," + sportFacilityCode + "," + CommonTool.convertDateToString(startTime) + "," + CommonTool.convertDateToString(endTime);
    }

    @Override
    public void fromCSV(String csv) {
        String[] data = csv.split(",");
        studentNumber = data[0];
        sportFacilityCode = data[1];
        startTime = CommonTool.convertStringToDate(data[2]);
        endTime = CommonTool.convertStringToDate(data[3]);
    }
}
