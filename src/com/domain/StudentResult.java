package com.domain;

public class StudentResult implements CSVClass {
    private String studentNumber;
    private int semester;
    private String code;
    private String module;
    private double marks;
    private String grade;
    private double credit;
    private double gpaPoint;


    public StudentResult() {
    }

    public StudentResult(String studentNumber, int semester, String code, String module, double marks, String grade, double credit, double gpaPoint) {
        this.studentNumber = studentNumber;
        this.semester = semester;
        this.code = code;
        this.module = module;
        this.marks = marks;
        this.grade = grade;
        this.credit = credit;
        this.gpaPoint = gpaPoint;
    }


    @Override
    public String toString() {
        return
                "studentNumber='" + studentNumber + '\'' +
                ", semester=" + semester +
                ", code='" + code + '\'' +
                ", module='" + module + '\'' +
                ", marks=" + marks +
                ", grade='" + grade + '\'' +
                ", credit=" + credit +
                ", gpaPoint=" + gpaPoint ;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    public double getGpaPoint() {
        return gpaPoint;
    }

    public void setGpaPoint(double gpaPoint) {
        this.gpaPoint = gpaPoint;
    }


    @Override
    public String toCSV() {
        return studentNumber+","+semester+","+code+","+module+","+marks+","+grade+","+credit+","+gpaPoint;
    }

    @Override
    public void fromCSV(String csv) {
        String[] data = csv.split(",");
        studentNumber = data[0];
        semester = Integer.parseInt(data[1]);
        code = data[2];
        module = data[3];
        marks =  Double.parseDouble(data[4]);
        grade = data[5];
        credit = Double.parseDouble(data[6]);
        gpaPoint = Double.parseDouble(data[7]);
    }
}
