package domain.srk;

import domain.CSVClass;

public class StudentResult implements CSVClass {
    private String studentNumber;
    private int year;
    private int semester;
    private String subjectName;
    private String subjectCode;
    private Double marks;
    private String grade;

    public StudentResult() {
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return
                "studentNumber='" + studentNumber + '\'' +
                ", year=" + year +
                ", semester=" + semester +
                ", subjectName='" + subjectName + '\'' +
                ", subjectCode='" + subjectCode + '\'' +
                ", marks=" + marks +
                ", grade='" + grade + '\'';
    }

    //toCSV function
    public String toCSV(){
        return studentNumber+","+year+","+semester+","+subjectName+","+subjectCode+","+marks+","+grade;
    }

    @Override
    public void fromCSV(String csv) {
        String[] data = csv.split(",");
        studentNumber = data[0];
        year = Integer.parseInt(data[1]);
        semester = Integer.parseInt(data[2]);
        subjectName = data[3];
        subjectCode = data[4];
        marks = Double.parseDouble(data[5]);
        grade = data[6];
    }

}
