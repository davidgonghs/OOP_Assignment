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

public class ClassVenue implements CSVClass {
    //code,classVenuesName,status
    private String code;
    private String classVenuesName;
    private boolean status;

    public ClassVenue() {
    }

    public ClassVenue(String code, String classVenuesName, boolean status) {
        this.code = code;
        this.classVenuesName = classVenuesName;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClassVenuesName() {
        return classVenuesName;
    }

    public void setClassVenuesName(String classVenuesName) {
        this.classVenuesName = classVenuesName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toCSV() {
        return code + "," + classVenuesName + "," + (status?"1":"0");
    }

    @Override
    public void fromCSV(String csv) {
        String[] data = csv.split(",");
        code = data[0];
        classVenuesName = data[1];
        status = Integer.parseInt(data[2]) == 1;

    }
}
