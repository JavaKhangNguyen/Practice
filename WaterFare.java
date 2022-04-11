import javax.swing.*;
import java.text.DecimalFormat;
public class WaterFare {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0");
        JTextField previous = new JTextField();
        JTextField current = new JTextField();
        JTextField num_of_member = new JTextField();
        Box water = Box.createVerticalBox();
        water.add(new JLabel("Enter the water's index last month: "));
        water.add(previous);
        water.add(new JLabel("Enter the water's index this month: "));
        water.add(current);
        water.add(new JLabel("Enter the number of member in the family: "));
        water.add(num_of_member);
        int result = JOptionPane.showConfirmDialog(null, water, "Java Water Fare", JOptionPane.OK_CANCEL_OPTION);
        while(Integer.parseInt(num_of_member.getText()) > 10 || Integer.parseInt(num_of_member.getText()) < 1 
        || Integer.parseInt(current.getText()) < Integer.parseInt(previous.getText()) || 
        Integer.parseInt(current.getText()) < 0 || Integer.parseInt(previous.getText()) < 0 || 
        Integer.parseInt(current.getText()) > Math.pow(10,9) || Integer.parseInt(previous.getText()) > Math.pow(10,9)){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java Water Fare", 
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, water, "Java Water Fare", JOptionPane.OK_CANCEL_OPTION);
        }
        int amount_of_water = Integer.parseInt(current.getText()) - Integer.parseInt(previous.getText());
        if(result == JOptionPane.OK_OPTION){
            if(amount_of_water / 10 <= 4){
                JOptionPane.showMessageDialog(null, "The water fare is " +  df.format(1.1*(amount_of_water*3300))
                + " VND","Java Water Fare", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(amount_of_water / 10 > 4 && amount_of_water / 10 <= 6){
                JOptionPane.showMessageDialog(null, "The water fare is " +  df.format(1.1*(amount_of_water*5200))
                + " VND","Java Water Fare", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "The water fare is " +  df.format(1.1*(amount_of_water*7000))
                + " VND","Java Water Fare", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}