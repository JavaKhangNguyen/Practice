import javax.swing.*;
import java.text.DecimalFormat;
public class CircleGUI {
    public static void main(String[] args) {
        String radius = JOptionPane.showInputDialog(null, "Please input radius: ", "Circle calculator", JOptionPane.INFORMATION_MESSAGE);
        radius = radius.replaceAll("[^-0-9.]", "");
        while(Double.parseDouble(radius) < 0 || Double.parseDouble(radius) > Math.pow(10,9)){
            radius = JOptionPane.showInputDialog(null, "Invalid input! Please input radius again: ", "Circle calculator", JOptionPane.WARNING_MESSAGE);
        }
        radius = radius.replaceAll("[^0-9.]", "");
        double area = Math.pow(Double.parseDouble(radius), 2)*Math.PI;
        double perimeter = 2*Double.parseDouble(radius)*Math.PI;
        DecimalFormat df = new DecimalFormat("#.##");
        String formatted_area = df.format(area);
        String formatted_perimeter = df.format(perimeter);
        JOptionPane.showMessageDialog(null, "Perimeter of the circle is " + formatted_perimeter + "\n" 
        +  "Area of the circle is " + formatted_area, "Circle calculator", JOptionPane.INFORMATION_MESSAGE);
    }
}
