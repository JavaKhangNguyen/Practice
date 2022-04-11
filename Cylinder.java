import javax.swing.*;
import java.text.DecimalFormat;
public class Cylinder {
    public static void main(String[] args) {
        JTextField a = new JTextField();
        JTextField b = new JTextField();
        Box math = Box.createVerticalBox();
        math.add(new JLabel("Input radius: "));
        math.add(a);
        math.add(new JLabel("Input height:"));
        math.add(b);
        int result = JOptionPane.showConfirmDialog(null, math, "Java Cylinder Calculator", JOptionPane.OK_CANCEL_OPTION);
        while(Double.parseDouble(a.getText()) <= 0 || Double.parseDouble(b.getText()) <= 0 || 
        Double.parseDouble(a.getText()) > Math.pow(10, 9) || Double.parseDouble(b.getText()) > Math.pow(10, 9)){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java Cylinder Calculator", 
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, math, "Java Cylinder Calculator", JOptionPane.OK_CANCEL_OPTION);
            if(result == JOptionPane.CANCEL_OPTION){
                result = WindowConstants.EXIT_ON_CLOSE;
                break;
            }
        }
        DecimalFormat df = new DecimalFormat("0.00");
        if(result == JOptionPane.OK_OPTION){
            JOptionPane.showMessageDialog(null, "Volume of the cylinder is " 
            + df.format(3.14*Math.pow(Double.parseDouble(a.getText()),2)*Double.parseDouble(b.getText())) , 
            "Java Cylinder Calculator", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
