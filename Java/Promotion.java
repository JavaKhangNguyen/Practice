package Java;
import javax.swing.*;
import java.text.DecimalFormat;
public class Promotion {
    public static void main(String[] args) {
        JTextField a = new JTextField();
        JTextField b = new JTextField();
        Box math = Box.createVerticalBox();
        math.add(new JLabel("Input percentage: "));
        math.add(a);
        math.add(new JLabel("Input quota:"));
        math.add(b);
        int result = JOptionPane.showConfirmDialog(null, math, "Java Promotion Calculator", JOptionPane.OK_CANCEL_OPTION);
        while(Double.parseDouble(a.getText()) <= 0 || Double.parseDouble(b.getText()) <= 0 || 
        Double.parseDouble(a.getText()) > Math.pow(10, 9) || Double.parseDouble(b.getText()) > Math.pow(10, 9)){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java Promotion Calculator", 
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, math, "Java Promotion Calculator", JOptionPane.OK_CANCEL_OPTION);
            if(result == JOptionPane.CANCEL_OPTION){
                result = WindowConstants.EXIT_ON_CLOSE;
                break;
            }
        }
        DecimalFormat df = new DecimalFormat("0");
        if(result == JOptionPane.OK_OPTION){
            JOptionPane.showMessageDialog(null, "The amount of money that you need to spend to get the maximum refund is " 
            + df.format(Double.parseDouble(b.getText())/(Double.parseDouble(a.getText())/100)), 
            "Java Promotion Calculator", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
