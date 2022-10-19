package domain.srk;

public class StudentResult {
    private String studentNumber;
    private String subjectName;
    private String subjectCode;
    private Double marks;
    private String grade;

    public StudentResult() {
    }

    public StudentResult(String studentNumber, String subjectName, String subjectCode, Double marks, String grade) {
        this.studentNumber = studentNumber;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentResult{" +
                "studentNumber='" + studentNumber + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", subjectCode='" + subjectCode + '\'' +
                ", marks=" + marks +
                ", grade='" + grade + '\'' +
                '}';
    }

    //to csv string
    public String toCsvString() {
        return studentNumber + "," + subjectName + "," + subjectCode + "," + marks + "," + grade;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
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
}
