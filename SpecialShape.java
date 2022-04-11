import javax.swing.*;
import java.text.DecimalFormat;
public class SpecialShape {
    public static void main(String[] args) {
        JTextField a = new JTextField();
        JTextField b = new JTextField();
        Box math = Box.createVerticalBox();
        math.add(new JLabel("Input edge of the triangle: "));
        math.add(a);
        math.add(new JLabel("Input radius of the circle:"));
        math.add(b);
        int result = JOptionPane.showConfirmDialog(null, math, "Java Special Shape Calculator", JOptionPane.OK_CANCEL_OPTION);
        while(Double.parseDouble(a.getText()) <= 0 || Double.parseDouble(b.getText()) <= 0 || 
        Double.parseDouble(a.getText()) > Math.pow(10, 9) || Double.parseDouble(b.getText()) > Math.pow(10, 9)){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java Special Shape Calculator", 
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, math, "Java Special Shape Calculator", JOptionPane.OK_CANCEL_OPTION);
            if(result == JOptionPane.CANCEL_OPTION){
                result = WindowConstants.EXIT_ON_CLOSE;
                break;
            }
        }
        DecimalFormat df = new DecimalFormat("0.00");
        if(result == JOptionPane.OK_OPTION){
            JOptionPane.showMessageDialog(null, "Volume of the shape is " 
            + df.format(0.5*(3.14*Math.pow(Double.parseDouble(a.getText()), 2)) 
            + 3*(Math.pow((Double.parseDouble(b.getText())), 2)*Math.sqrt(3)/4)), "Java Special Shape Calculator", 
            JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
