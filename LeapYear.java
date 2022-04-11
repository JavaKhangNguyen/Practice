import javax.swing.*;
public class LeapYear {
    public static void main(String[] args) {
        String year = JOptionPane.showInputDialog(null, "Input a year:", "Leap Year Check", 
        JOptionPane.INFORMATION_MESSAGE);
        while(Integer.parseInt(year) <= 0 || Integer.parseInt(year) >= Math.pow(10, 9)){
            year = JOptionPane.showInputDialog(null,"Invalid input! Please input again!Input a year: ", "Leap Year Check", 
            JOptionPane.WARNING_MESSAGE);
        }
        if(Integer.parseInt(year) % 100 == 0){
            if(Integer.parseInt(year) % 400 == 0){
                JOptionPane.showMessageDialog(null, "This is a leap year", "Leap Year Check", 
            JOptionPane.INFORMATION_MESSAGE);
            }
            else JOptionPane.showMessageDialog(null, "This is not a leap year", "Leap Year Check", 
            JOptionPane.INFORMATION_MESSAGE);
        }
        else if(Integer.parseInt(year) % 4 == 0){
            JOptionPane.showMessageDialog(null, "This is a leap year", "Leap Year Check", 
            JOptionPane.INFORMATION_MESSAGE);
        }
        else JOptionPane.showMessageDialog(null, "This is not a leap year", "Leap Year Check", 
        JOptionPane.INFORMATION_MESSAGE);
    }
}
