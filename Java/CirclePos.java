package Java;
import javax.swing.*;
public class CirclePos {
    public static void main(String[] args) {
        JTextField radius1 = new JTextField();
        JTextField radius2 = new JTextField();
        JTextField distance = new JTextField();
        Box circle = Box.createVerticalBox();
        circle.add(new JLabel("Input radius 1: "));
        circle.add(radius1);
        circle.add(new JLabel("Input radius 2: "));
        circle.add(radius2);
        circle.add(new JLabel("Input distance between the circles' center: "));
        circle.add(distance);  
        int result = JOptionPane.showConfirmDialog(null, circle, "Java Circle Pos", 
        JOptionPane.OK_CANCEL_OPTION);
        double r1 = Double.parseDouble(radius1.getText());
        double r2 = Double.parseDouble(radius2.getText());
        double d = Double.parseDouble(distance.getText());
        while(r1 <= 0 || r1 > Math.pow(10, 9) || r2 <= 0 || r2 > Math.pow(10, 9) || d < 0 ||
        d > Math.pow(10, 9)){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again!","Java Circle Pos", 
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, circle, "Java Circle Pos", 
        JOptionPane.OK_CANCEL_OPTION);
            r1 = Double.parseDouble(radius1.getText());
            r2 = Double.parseDouble(radius2.getText());
            d = Double.parseDouble(distance.getText());
        }
        if(result == JOptionPane.OK_OPTION){
            if(d == 0){
                JOptionPane.showMessageDialog(null, "The 2 circle are concentric.",
                "Java Circle Pos",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(d > Math.abs(r1 - r2) && d < r1 + r2){
                JOptionPane.showMessageDialog(null, "The 2 circle intersect.",
                "Java Circle Pos",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(d == Math.abs(r1 - r2)){
                JOptionPane.showMessageDialog(null, "The 2 circle are inner-tangential",
                "Java Circle Pos",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(d == r1 + r2){
                JOptionPane.showMessageDialog(null, "The 2 circle are outer-tangential",
                "Java Circle Pos",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(d > r1 + r2){
                JOptionPane.showMessageDialog(null, "The 2 circle are independent.",
                "Java Circle Pos",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(d < Math.abs(r1 - r2)){
                JOptionPane.showMessageDialog(null, "The 2 circle are looped.",
                "Java Circle Pos",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        else result = WindowConstants.EXIT_ON_CLOSE;
}
}
