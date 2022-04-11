import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.time.YearMonth;
public class NumOfDays {
  
    public static boolean LeapYear(int year) {
        if(year % 100 == 0){
            if(year % 400 == 0){
                return true;
            }
            else return false;
        }
        else if(year % 4 == 0){
            return true;
        }
        else return false;
    }
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        String monthyear = JOptionPane.showInputDialog(null,"Input year and month desired in format MM/yyyy: ",
        "Age calculator (by date)",JOptionPane.QUESTION_MESSAGE);
        while(Integer.parseInt(monthyear.substring(3,7)) < 0 || Integer.parseInt(monthyear.substring(3,7)) > Math.pow(10, 9) 
        || Integer.parseInt(monthyear.substring(0,2)) < 1 || Integer.parseInt(monthyear.substring(0,2)) > 12){ 
            monthyear = JOptionPane.showInputDialog(null,
            "Invalid input! Please input again!\nInput year and month desired in format MM/yyyy: ",
            "Age calculator (by date)",JOptionPane.WARNING_MESSAGE);
        }
        YearMonth monthofyear = YearMonth.parse(monthyear,formatter);
        if(LeapYear(monthofyear.getYear()) == true){
            if(monthofyear.getMonthValue() == 2){
                JOptionPane.showMessageDialog(null, "This month has 29 days", "Java Num of Days", 
                JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                if(monthofyear.getMonthValue() == 4 || monthofyear.getMonthValue() == 6 
            || monthofyear.getMonthValue() == 9|| monthofyear.getMonthValue() == 11){
                JOptionPane.showMessageDialog(null, "This month has 30 days", "Java Num of Days", 
                JOptionPane.INFORMATION_MESSAGE);
            }
            else JOptionPane.showMessageDialog(null, "This month has 31 days", "Java Num of Days", 
            JOptionPane.INFORMATION_MESSAGE);
            }
        }

        else {
            if(monthofyear.getMonthValue() == 2){
                JOptionPane.showMessageDialog(null, "This month has 28 days", "Java Num of Days", 
                JOptionPane.INFORMATION_MESSAGE);
            }
            else if(monthofyear.getMonthValue() == 4 || monthofyear.getMonthValue() == 6 
            || monthofyear.getMonthValue() == 9|| monthofyear.getMonthValue() == 11){
                JOptionPane.showMessageDialog(null, "This month has 30 days", "Java Num of Days", 
                JOptionPane.INFORMATION_MESSAGE);
            }
            else JOptionPane.showMessageDialog(null, "This month has 31 days", "Java Num of Days", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}
}