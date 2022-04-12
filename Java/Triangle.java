package Java;
import javax.swing.*;
public class Triangle {
    public static String TriangleCheck(double AB, double BC, double AC){
        if(AB == BC && AB == AC && BC == AC){
            return "Equilateral";
        }
        else if(Math.pow(AB, 2) + Math.pow(AC, 2) == Math.pow(BC, 2)){
            if(AB == AC && Math.pow(BC, 2) - (Math.pow(AB, 2) + Math.pow(AC, 2)) <= 1 ){
                return "Isosceles-righted at A";
            }
            return "Righted at A";
        }
        else if(Math.pow(AB, 2) + Math.pow(BC, 2) == Math.pow(AC, 2)){
            if(AB == BC && Math.pow(AC, 2) - (Math.pow(AB, 2) + Math.pow(BC, 2)) <= 1){
                return "Isosceles-righted at B";
            }
            return "Righted at B";
        }
        else if(Math.pow(AC, 2) + Math.pow(BC, 2) == Math.pow(AB, 2)){
            if(BC == AC && Math.pow(AB, 2) - (Math.pow(AC, 2) + Math.pow(BC, 2)) <= 1){
                return "Isosceles-righted at C";
            }
            return "Righted at C";
        }
        else if(AB == AC){
            return "Isosceles at A";
        }
        else if(AB == BC){
            return "Isosceles at B";
        }
        else if (BC == AC){
            return "Isosceles at C";
        }
        else if(AB + BC > AC && AB + AC > BC && BC + AC > AB){
            return "Common triangle";
        }
        else return "This is not a triangle!";
    }
    public static void main(String[] args) {
        JTextField AB_input = new JTextField();
        JTextField BC_input = new JTextField();
        JTextField AC_input = new JTextField();
        Box triangle = Box.createVerticalBox();
        triangle.add(new JLabel("Enter length of AB: "));
        triangle.add(AB_input);
        triangle.add(new JLabel("Enter length of BC: "));
        triangle.add(BC_input);
        triangle.add(new JLabel("Enter length of AC: "));
        triangle.add(AC_input);
        int result = JOptionPane.showConfirmDialog(null, triangle, "Triangle Type", JOptionPane.OK_CANCEL_OPTION);
        double AB = Double.parseDouble(AB_input.getText());
        double BC = Double.parseDouble(BC_input.getText());
        double AC = Double.parseDouble(AC_input.getText());
        while(AB <= 0 || BC <= 0 || AC <= 0 || AB > Math.pow(10,9) || BC > Math.pow(10,9) 
        || AC > Math.pow(10,9)){
        JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Triangle Type", 
        JOptionPane.WARNING_MESSAGE);
        result = JOptionPane.showConfirmDialog(null, triangle, "Triangle Type", JOptionPane.OK_CANCEL_OPTION);
        AB = Double.parseDouble(AB_input.getText());
        BC = Double.parseDouble(BC_input.getText());
        AC = Double.parseDouble(AC_input.getText());
        if(result == JOptionPane.CANCEL_OPTION){
            result = WindowConstants.EXIT_ON_CLOSE;
            break;
        }
        }
        if(result == JOptionPane.OK_OPTION){
            JOptionPane.showMessageDialog(null, TriangleCheck(AB, BC, AC), "Triangle Type", 
            JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
