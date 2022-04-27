package Java;
import javax.swing.*;
import java.text.DecimalFormat;
public class Formula {
   public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("0");
    JTextField x = new JTextField();
    JTextField n = new JTextField();
    Box math = Box.createVerticalBox();
    math.add(new JLabel("Enter n: "));
    math.add(n);
    math.add(new JLabel("Enter x: "));
    math.add(x);
    int result = JOptionPane.showConfirmDialog(null, math, "Java Math", 
    JOptionPane.OK_CANCEL_OPTION);
    if(result == JOptionPane.CANCEL_OPTION){
        result = WindowConstants.EXIT_ON_CLOSE;
    }
    while(Double.parseDouble(x.getText()) <= 0 || 
    Double.parseDouble(x.getText()) > Math.pow(10, 9) || 
    Double.parseDouble(n.getText()) <= 0 || 
    Double.parseDouble(x.getText()) > Math.pow(10, 9)){
        JOptionPane.showMessageDialog(null, 
        "Invalid input! Please input again!","Java Math", 
        JOptionPane.WARNING_MESSAGE);
        result = JOptionPane.showConfirmDialog(null, math, "Java Math", 
        JOptionPane.OK_CANCEL_OPTION);
    }
    if(result == JOptionPane.OK_OPTION){
        JOptionPane.showMessageDialog(null,"(x^2 + 1)^n = (" + 
        Double.parseDouble(x.getText()) + "^2 + 1)^" 
        + df.format(Double.parseDouble(n.getText())) + " = " + 
        Math.round(Math.pow((Math.pow(Double.parseDouble(x.getText()),2) + 1),
        Double.parseDouble(n.getText()))*100.0)/100.0,"Java Math", 
        JOptionPane.INFORMATION_MESSAGE);
    }
    else result = WindowConstants.EXIT_ON_CLOSE;
   }
}
