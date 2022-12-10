package domain;

public class SportFacility implements CSVClass {
    //code,facilityName,status
    private String code;
    private String facilityName;
    private String status;

    public SportFacility(){
        
    }

    public SportFacility(String code, String facilityName, String status) {
        this.code = code;
        this.facilityName = facilityName;
        this.status = status;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toCSV() {
        return code + "," + facilityName + "," + status;
    }

    @Override
    public void fromCSV(String csv) {
        String[] data = csv.split(",");
        code = data[0];
        facilityName = data[1];
        status = data[2];
    }
}
