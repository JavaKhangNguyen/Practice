package Java;
import javax.swing.*;
public class BigSmall {
    public static int getBigNum(int a, int b){
        if(a > b){
            return a;
        }
        else return b;
    }
    public static int getSmallNum(int a, int b){
        if(a < b){
            return a;
        }
        else return b;
    }
    public static void main(String[] args) {
        JTextField a = new JTextField();
        JTextField b = new JTextField();
        Box math = Box.createVerticalBox();
        math.add(new JLabel("Input a: "));
        math.add(a);
        math.add(new JLabel("Input b:"));
        math.add(b);
        int result = JOptionPane.showConfirmDialog(null, math, "Java Big Small", JOptionPane.OK_CANCEL_OPTION);
        int number_a = Integer.parseInt(a.getText());
        int number_b = Integer.parseInt(b.getText());
        while(number_a == number_b){
            JOptionPane.showMessageDialog(null, "2 equal numbers received! Please input again!", "Java Big Small", 
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, math, "Java Big Small", JOptionPane.OK_CANCEL_OPTION);
            number_a = Integer.parseInt(a.getText());
            number_b = Integer.parseInt(b.getText());
            if(result == JOptionPane.CANCEL_OPTION){
                result = WindowConstants.EXIT_ON_CLOSE;
                break;
            }
        }
        while(number_a < -Math.pow(10, 9) || number_b < -Math.pow(10, 9) || 
        number_a > Math.pow(10, 9) || number_b > Math.pow(10, 9)){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java Big Small", 
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, math, "Java Big Small", JOptionPane.OK_CANCEL_OPTION);
            number_a = Integer.parseInt(a.getText());
            number_b = Integer.parseInt(b.getText());
            if(result == JOptionPane.CANCEL_OPTION){
                result = WindowConstants.EXIT_ON_CLOSE;
                break;
            }
        }
        if(result == JOptionPane.OK_OPTION){
            JOptionPane.showMessageDialog(null, "The bigger number is " + getBigNum(number_a, number_b) 
            + "\nThe smaller number is " + getSmallNum(number_a, number_b), "Java Big Small", 
            JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
