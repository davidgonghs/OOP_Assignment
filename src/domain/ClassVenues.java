package domain;

public class ClassVenues implements CSVClass {
    private String code;
    private String venue;

    public ClassVenues(String code, String venue) {
        this.code = code;
        this.venue = venue;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Override
    public String toCSV() {
        return code + "," + venue;
    }

    @Override
    public void fromCSV(String csv) {
        String[] data = csv.split(",");
        code = data[0];
        venue = data[1];
    }
}
