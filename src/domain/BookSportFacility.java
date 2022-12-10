package domain;

import tool.CommonTool;

import java.util.Date;

public class BookSportFacility implements CSVClass {
    //id,code,studentId,startTime,endTime
    private int id;
    private String sportFacilityCode;
    private String studentId;
    private Date startTime;
    private Date endTime;

    public BookSportFacility() {
    }

    public BookSportFacility(int id, String sportFacilityCode, String studentId, Date startTime, Date endTime) {
        this.id = id;
        this.sportFacilityCode = sportFacilityCode;
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

    public String getSportFacilityCode() {
        return sportFacilityCode;
    }

    public void setSportFacilityCode(String sportFacilityCode) {
        this.sportFacilityCode = sportFacilityCode;
    }

    public String getSudentId() {
        return studentId;
    }

    public void setStudentNumber(String studentId) {
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
        return id + "," + sportFacilityCode + "," + studentId + "," + CommonTool.convertDateToString(startTime) + "," + CommonTool.convertDateToString(endTime);
    }

    @Override
    public void fromCSV(String csv) {
        String[] data = csv.split(",");
        id = Integer.parseInt(data[0]);
        sportFacilityCode = data[1];
        studentId = data[2];
        startTime = CommonTool.convertStringToDate(data[3]);
        endTime = CommonTool.convertStringToDate(data[4]);
    }
}
