package Java;
import javax.swing.*;
import java.text.DecimalFormat;
public class Equations {
    
    public static void LinearEquation(){
            DecimalFormat df = new DecimalFormat("0.00");
            JTextField a = new JTextField();
            JTextField b = new JTextField();
            Box math = Box.createVerticalBox();
            math.add(new JLabel("Input a: "));
            math.add(a);
            math.add(new JLabel("Input b:"));
            math.add(b);
            int result = JOptionPane.showConfirmDialog(null, math, "Java Calculator", JOptionPane.OK_CANCEL_OPTION);
            while(Double.parseDouble(a.getText()) < -Math.pow(10, 9) || Double.parseDouble(b.getText()) < -Math.pow(10, 9) || 
            Double.parseDouble(a.getText()) > Math.pow(10, 9) || Double.parseDouble(b.getText()) > Math.pow(10, 9)){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java Calculator", JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, math, "Java Calculator", JOptionPane.OK_CANCEL_OPTION);
            if(result == JOptionPane.CANCEL_OPTION){
                result = WindowConstants.EXIT_ON_CLOSE;
                break;
            }
        }
        if(result == JOptionPane.OK_OPTION){
            JOptionPane.showMessageDialog(null, "x = " 
            + df.format(-Double.parseDouble(b.getText())/Double.parseDouble(a.getText())), "Java Calculator", 
            JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void BinomialEquation(){
            DecimalFormat df = new DecimalFormat("0.00");
            JTextField a1 = new JTextField();
            JTextField b1 = new JTextField();
            JTextField c1 = new JTextField();
            Box polynomial = Box.createVerticalBox();
            polynomial.add(new JLabel("Input a: "));
            polynomial.add(a1);
            polynomial.add(new JLabel("Input b:"));
            polynomial.add(b1);
            polynomial.add(new JLabel("Input c: "));
            polynomial.add(c1);
            int poly_result = JOptionPane.showConfirmDialog(null, polynomial, "Java Calculator", 
            JOptionPane.OK_CANCEL_OPTION);
            double num_a = Double.parseDouble(a1.getText());
            double num_b = Double.parseDouble(b1.getText());
            double num_c = Double.parseDouble(c1.getText());
            double delta = Math.pow(num_b,2) - 4*num_a*num_c;
            while(num_a < -Math.pow(10, 9) || num_b< -Math.pow(10, 9) || num_c < -Math.pow(10, 9)||num_a > Math.pow(10, 9) 
            ||num_b > Math.pow(10, 9) ||num_c > Math.pow(10, 9)){
                JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java Calculator", 
                JOptionPane.WARNING_MESSAGE);
                poly_result = JOptionPane.showConfirmDialog(null, polynomial, "Java Calculator", 
                JOptionPane.OK_CANCEL_OPTION);
                num_a = Double.parseDouble(a1.getText());
                num_b = Double.parseDouble(b1.getText());
                num_c = Double.parseDouble(c1.getText());
                delta = Math.pow(num_b,2) - 4*num_a*num_c;
                if(poly_result == JOptionPane.CANCEL_OPTION){
                    poly_result = WindowConstants.EXIT_ON_CLOSE;
                break;
            }
            }
            if(poly_result == JOptionPane.OK_OPTION){
                if(delta > 0){
                    JOptionPane.showMessageDialog(null, "x1 = " + df.format(((- num_b - Math.sqrt(delta))/(2*num_a))) + 
                    " , x2 = " + df.format(((-num_b + Math.sqrt(delta))/(2*num_a))) , "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
                else if(delta == 0){
                    JOptionPane.showMessageDialog(null, "x = " + df.format((-num_b/2*num_a)), "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
                else {JOptionPane.showMessageDialog(null, "Equation has no root! ", "Java Calculator", 
                JOptionPane.INFORMATION_MESSAGE);}
                
            }
    }

    public static void BiquadraticEquation(){
        DecimalFormat df = new DecimalFormat("0.00");
        JTextField a1 = new JTextField();
        JTextField b1 = new JTextField();
        JTextField c1 = new JTextField();
        Box biquadratic = Box.createVerticalBox();
        biquadratic.add(new JLabel("Input a: "));
        biquadratic.add(a1);
        biquadratic.add(new JLabel("Input b:"));
        biquadratic.add(b1);
        biquadratic.add(new JLabel("Input c: "));
        biquadratic.add(c1);
        int biquad_result = JOptionPane.showConfirmDialog(null, biquadratic, "Java Calculator", 
        JOptionPane.OK_CANCEL_OPTION);
        double num_a = Double.parseDouble(a1.getText());
        double num_b = Double.parseDouble(b1.getText());
        double num_c = Double.parseDouble(c1.getText());
        double delta = Math.pow(num_b,2) - 4*num_a*num_c;
        while(num_a < -Math.pow(10, 9) || num_b< -Math.pow(10, 9) || num_c < -Math.pow(10, 9)||num_a > Math.pow(10, 9) 
        ||num_b > Math.pow(10, 9) ||num_c > Math.pow(10, 9)){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java Calculator", 
            JOptionPane.WARNING_MESSAGE);
            biquad_result = JOptionPane.showConfirmDialog(null, biquadratic, "Java Calculator", 
            JOptionPane.OK_CANCEL_OPTION);
            num_a = Double.parseDouble(a1.getText());
            num_b = Double.parseDouble(b1.getText());
            num_c = Double.parseDouble(c1.getText());
            delta = Math.pow(num_b,2) - 4*num_a*num_c;
            if(biquad_result == JOptionPane.CANCEL_OPTION){
                biquad_result = WindowConstants.EXIT_ON_CLOSE;
            break;
        }
        }
        if(biquad_result == JOptionPane.OK_OPTION){
            if(delta > 0){
                double t1 = ((- num_b - Math.sqrt(delta))/(2*num_a));
                double t2 = ((- num_b + Math.sqrt(delta))/(2*num_a));
                if(t1 < 0 && t2 < 0){
                    JOptionPane.showMessageDialog(null, "Equation has no root! ", "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
                if(t1 > 0 && t2 > 0){
                    JOptionPane.showMessageDialog(null, "x1 = " + df.format(Math.sqrt(t1)) + ", x2 = " 
                    + df.format(-Math.sqrt(t1)) + ", x3 = " + df.format(Math.sqrt(t2))+ ", x4 = " 
                    + df.format(-Math.sqrt(t2)), "Java Calculator", JOptionPane.INFORMATION_MESSAGE);
                }
                if(t1 == 0){
                    JOptionPane.showMessageDialog(null, "x1 = " + df.format(Math.sqrt(t1)) + ", x2 = " 
                    + df.format(Math.sqrt(t2)) + ", x3 = " + df.format(-Math.sqrt(t2)), "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
                if(t2 == 0){
                    JOptionPane.showMessageDialog(null, "x1 = " + df.format(Math.sqrt(t2)) + ", x2 = " 
                    + df.format(Math.sqrt(t1)) + ", x3 = " + df.format(-Math.sqrt(t1)), "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else if(delta == 0){
                if(Math.sqrt((-num_b/2*num_a)) == 0){
                    JOptionPane.showMessageDialog(null, "x = " + df.format(Math.sqrt((-num_b/2*num_a))), 
                    "Java Calculator", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "x1 = " + df.format(Math.sqrt((-num_b/2*num_a))) 
                + ", x2 = " + df.format(-Math.sqrt((-num_b/2*num_a))), "Java Calculator", 
                JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else {JOptionPane.showMessageDialog(null, "Equation has no root! ", "Java Calculator", 
            JOptionPane.INFORMATION_MESSAGE);}
        }
    }
    public static void main(String[] args) {
        String flag = JOptionPane.showInputDialog(null, 
        "Welcome to Java Calculator! Select type of equation you want: \n1. Linear equation ax + b = 0\n" 
        + "2. Binomial equation\n3. Biquadratic equation", "Java Calculator", JOptionPane.INFORMATION_MESSAGE);
        while(Double.parseDouble(flag) != 1 && Double.parseDouble(flag) != 2 && Double.parseDouble(flag) != 3){
            flag = JOptionPane.showInputDialog(null, 
            "Invalid input! Please select again!\nSelect type of equation you want:" 
            + " \n1. Linear equation ax + b = 0\n2. Binomial equation\n3. Biquadratic equation", "Java Calculator", 
            JOptionPane.WARNING_MESSAGE);
            if(Double.parseDouble(flag) == JOptionPane.CANCEL_OPTION){
                double flagger = Double.parseDouble(flag);
                flagger = WindowConstants.EXIT_ON_CLOSE;
                break;
            }
        }
        if(Double.parseDouble(flag) == 1){LinearEquation();}
        else if(Double.parseDouble(flag) == 2){BinomialEquation();}
        else {BiquadraticEquation();}
    }
}
