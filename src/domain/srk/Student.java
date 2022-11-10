package domain.srk;

import java.util.Arrays;

public class Student implements CSVClass {
    private String studentNumber;

    private String name;

    private int age;


    private String email;

    private String phone;

    private String programme;

    //constructor
    //default constructor
    public Student() {
    }

    public Student(String studentNumber, String name, int age, String email, String phone, String programme) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.age = age;

        this.email = email;
        this.phone = phone;
        this.programme = programme;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    @Override
    public String toString() {
        return "studentNumber='" + studentNumber + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", programme='" + programme + '\'';
    }


    @Override
    public String toCSV() {
        return studentNumber + "," + name + "," + age + ","  + email + "," + phone + "," + programme;

    }

    @Override
    public void fromCSV(String csv) {
        String[] student = csv.split(",");
        this.studentNumber = student[0];
        this.name = student[1];
        this.age = Integer.parseInt(student[2]);
        this.email = student[3];
        this.phone = student[4];
        this.programme = student[5];
    }
}
