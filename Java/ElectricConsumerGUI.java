package Java;
import javax.swing.*;
public class ElectricConsumerGUI {
    public static void main(String[] args) {
        JTextField current = new JTextField();
        JTextField previous = new JTextField();
        Box electric = Box.createVerticalBox();
        electric.add(new JLabel("Electric meter's index this month: "));
        electric.add(current);
        electric.add(new JLabel("Electric meter's index last month:"));
        electric.add(previous);
        int result = JOptionPane.showConfirmDialog(null, electric, "Electric Calculator", JOptionPane.OK_CANCEL_OPTION);
        int elec = (Integer.parseInt(current.getText()) - Integer.parseInt(previous.getText()));
        if(Integer.parseInt(current.getText()) < 0 | Integer.parseInt(current.getText()) < Integer.parseInt(previous.getText()) | 
        Integer.parseInt(previous.getText()) < 0 | Integer.parseInt(current.getText()) > Math.pow(10,9) ){
            JOptionPane.showMessageDialog(null, "Invalid input!", "Electric Calculator",JOptionPane.WARNING_MESSAGE);}
        else if (result == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null,"The amount of electricty used is " + elec + " kWh","Electric Calculator",JOptionPane.INFORMATION_MESSAGE);
        }
}
}