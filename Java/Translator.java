package Java;
import javax.swing.*;

public class Translator {
    public static void main(String[] args) {
        String num = JOptionPane.showInputDialog(null, "Input the number (only 0 to 9 are accepted): ", 
        "Java Number Translator", JOptionPane.INFORMATION_MESSAGE);
        int number = Integer.parseInt(num);
        String result = null;
        switch (number) {
            case 0:
                result = "Zero";
                break;
            case 1:
                result = "One";
                break;
            case 2:
                result = "Two";
                break;
            case 3:
                result = "Three";
                break;
            case 4:
                result = "Three";
                break;
            case 5:
                result = "Five";
                break;
            case 6:
                result = "Six";
                break;
            case 7:
                result = "Seven";
                break;
            case 8:
                result = "Eight";
                break;
            case 9:
                result = "Nine";
                break;
            default:
                result = "Unknown";
                break;
        }
        JOptionPane.showMessageDialog(null, number + ": " + result, "Java Number Translator", 
        JOptionPane.INFORMATION_MESSAGE);
    }   
}