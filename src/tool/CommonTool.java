//<editor-fold desc="File Description">
// DESCRIPTION :
//       This file serves as a place to store static functions
//
//  PUBLIC FUNCTIONS :
//       isMarksValid(), getGrade(), getGradePoints()
//
//  NOTES :
//       None
//
//  AUTHOR :    B1146 DAVID GONG
//
//  CHANGES :
//       None
//</editor-fold>

package tool;

public class CommonTool {

    //isMarksValid
    public static boolean isMarksValid(double marks){
        try {
            if (marks >= 0 && marks <= 100){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }


    //get grade from marks
    public static String getGrade(double marks){
        // A+ 90-100
        // A 80-89
        //A- 75-79
        //B+ 70-74
        //B 65-69
        //B- 60-64
        //C+ 55-59
        //C 50-54
        //C-,D+D,D-,F = Fail(0-49)

        if (marks >= 90 && marks <= 100){
            return "A+";
        }else if (marks >= 80 && marks <= 89){
            return "A";
        }else if (marks >= 75 && marks <= 79){
            return "A-";
        }else if (marks >= 70 && marks <= 74){
            return "B+";
        }else if (marks >= 65 && marks <= 69){
            return "B";
        }else if (marks >= 60 && marks <= 64){
            return "B-";
        }else if (marks >= 55 && marks <= 59){
            return "C+";
        }else if (marks >= 50 && marks <= 54){
            return "C";
        }else if (marks >= 0 && marks <= 49){
            return "F";
        }
        return "N/A";
    }


    //get gpa point from grade
    public static double getGradePoints(String grade){
        // A+ 4.0
        // A 4.0
        //A- 3.67
        // B+ 3.33
        // B 3.0
        //B- 2.67
        // C+ 2.33
        // C 2.00
        // C- 1.67
        // D 2.0
        // F 0.0

        if (grade.equals("A+") || grade.equals("A")){
            return 4.0;
        }else if (grade.equals("A-")){
            return 3.67;
        }else if (grade.equals("B+")){
            return 3.33;
        }else if (grade.equals("B")){
            return 3.0;
        }else if (grade.equals("B-")){
            return 2.67;
        }else if (grade.equals("C+")){
            return 2.33;
        }else if (grade.equals("C")){
            return 2.0;
        }else if (grade.equals("C-")){
            return 1.67;
        }else if (grade.equals("D")){
            return 1.0;
        }else if (grade.equals("F")){
            return 0.0;
        }
        return 0.0;
    }

    public static boolean isSportsNameCodeValid(int code){
        try {
            if (code >= 1 && code <= 4){


                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    public static boolean isBookingDayCodeValid(int code){
        try {
            if (code >= 1 && code <= 5){


                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    public static boolean isBookingTimeCodeValid(int code){
        try {
            if (code >= 1 && code <= 2){


                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    public static boolean isCourtNumValid(int code){
        try {
            if (code >= 1 && code <= 2){


                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    public static String sportsNameCodeToName(int sportsNameCode){
        if (sportsNameCode == 1) {
            return "Basketball";
        } else if (sportsNameCode == 2) {
            return "Tennis";
        } else if (sportsNameCode == 3) {
            return "Badminton";
        } else if (sportsNameCode == 4) {
            return "Futsal";
        } else {
            return null;
//                System.out.println("Invalid input, please try again.");
        }
    }

    public static String bookingDayCodeToName(int bookingDayCode){
        if (bookingDayCode == 1) {
            return "Monday";
        } else if (bookingDayCode == 2) {
            return "Tuesday";
        } else if (bookingDayCode == 3) {
            return "Wednesday";
        } else if (bookingDayCode == 4) {
            return "Thursday";
        } else if (bookingDayCode == 5) {
            return "Friday";
        } else {
            return null;
//                System.out.println("Invalid input, please try again.");
        }
    }

    public static String bookingTimeCodeToName(int bookingTimeCode){
        if (bookingTimeCode == 1) {
            return "2pm-3pm";
        } else if (bookingTimeCode == 2) {
            return "4pm-5pm";
        } else {
            return null;
//                System.out.println("Invalid input, please try again.");
        }
    }


}
