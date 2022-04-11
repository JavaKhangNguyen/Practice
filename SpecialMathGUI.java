import javax.swing.*;
import java.text.DecimalFormat;
public class SpecialMathGUI {
    public static void main(String[] args) {
        String x = JOptionPane.showInputDialog(null, "Please input x: ",
        "Special math calculator", JOptionPane.INFORMATION_MESSAGE);
        x = x.replaceAll("[^-0-9.]", "");
        while(Double.parseDouble(x) <= 0 || Double.parseDouble(x) >= Math.pow(10,9)){
            x = JOptionPane.showInputDialog(null, "Invalid input! Please input x again: ", "Special math calculator", 
            JOptionPane.WARNING_MESSAGE);
        }
        x = x.replaceAll("[^0-9.]", "");
        double y1 = 4*(Math.pow(Double.parseDouble(x),2) + 10*(Double.parseDouble(x)*Math.sqrt(Double.parseDouble(x))) 
        + 3*Double.parseDouble(x) + 1);
        double y2 = (Math.sin(3.14*Math.pow(Double.parseDouble(x),2)) + Math.sqrt(Math.pow(Double.parseDouble(x),2) + 1))
        /(Math.pow(2.71,2*Double.parseDouble(x)) + Math.cos((3.14/4)*Double.parseDouble(x)));
        DecimalFormat df =  new DecimalFormat("#.##########");
        String formatted_y1 = df.format(y1);
        String formatted_y2 = df.format(y2);
        JOptionPane.showMessageDialog(null, "y1 is " + formatted_y1 + "\n" 
        +  "y2 is " + formatted_y2, "Special math calculator", JOptionPane.INFORMATION_MESSAGE);
    }
}
