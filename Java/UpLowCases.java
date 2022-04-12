package Java;
import javax.swing.*;
public class UpLowCases {
    public static void main(String[] args) {
        char uppercase, lowercase;
        String input = JOptionPane.showInputDialog(null, "Input letter:", "Up low case letter", 
        JOptionPane.INFORMATION_MESSAGE);
        char a = input.charAt(0);
        if(a >= 65 && a <= 90){
            lowercase = (char) (a + 32);
            uppercase = a;
        }
        else {
            uppercase = (char) (a - 32);
            lowercase = a;
        }
        JOptionPane.showMessageDialog(null, "Uppercase: " + uppercase + "\nLowercase: " + lowercase, "Up low case letter", 
        JOptionPane.INFORMATION_MESSAGE);
    }
}
