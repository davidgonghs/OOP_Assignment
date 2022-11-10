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


}
