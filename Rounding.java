import javax.swing.*;
public class Rounding {
    public static void RoundingReal(int num){
        //TODO: round real numbers here
    }
    public static void RoundingInteger(int num, int key){
        if(num % Math.pow(10,key) > (int) 5*Math.pow(10,key - 1)){
        JOptionPane.showMessageDialog(null,"Rounded number is " + 
        (int) (num + (Math.pow(10,key) - (num % Math.pow(10,key)))),"Java Rounding",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null,"Rounded number is " +  
            (int) (num - (num % Math.pow(10,key))),"Java Rounding",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void main(String[] args) {
        JTextField num = new JTextField();
        JTextField key = new JTextField();
        Box round = Box.createVerticalBox();
        round.add(new JLabel("Enter number needs rounding: "));
        round.add(num);
        round.add(new JLabel("Enter the number of 0s to be rounded up to: "));
        round.add(key);
        int result = JOptionPane.showConfirmDialog(null,round,"Java Rounding",JOptionPane.OK_CANCEL_OPTION);
        while(Integer.parseInt(key.getText()) < 0 || Integer.parseInt(key.getText()) > 10 || 
        Integer.parseInt(num.getText()) < 0 || Integer.parseInt(num.getText()) > Math.pow(10, 9)){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again!","Java Rounding",
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null,round,"Java Rounding",JOptionPane.OK_CANCEL_OPTION);
        }
        if(result == JOptionPane.OK_OPTION){
            RoundingInteger(Integer.parseInt(num.getText()),Integer.parseInt(key.getText()));
        }
        else {
            result = WindowConstants.EXIT_ON_CLOSE;
        }
    }
}