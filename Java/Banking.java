package Java;
import javax.swing.*;
public class Banking {
    public static void main(String[] args) {
        JTextField balance = new JTextField();
        JTextField month = new JTextField();
        JTextField rate = new JTextField();
        Box banking = Box.createVerticalBox();
        banking.add(new JLabel("Enter the balance: "));
        banking.add(balance);
        banking.add(new JLabel("Enter the month sent: "));
        banking.add(month);
        banking.add(new JLabel("Enter the rate: "));
        banking.add(rate);
        int result = JOptionPane.showConfirmDialog(null, banking, 
        "Java Banking", JOptionPane.OK_CANCEL_OPTION);
        if(result == JOptionPane.CANCEL_OPTION){
            result = WindowConstants.EXIT_ON_CLOSE;
        }
        while(Integer.parseInt(balance.getText()) <= 0 || 
        Integer.parseInt(balance.getText()) > Math.pow(10, 9) ||
        Integer.parseInt(month.getText()) <= 0 || 
        Integer.parseInt(month.getText()) > Math.pow(10, 9) || 
        Double.parseDouble(rate.getText()) > Math.pow(10, 9) || 
        Double.parseDouble(rate.getText()) <= 0 || Double.parseDouble(rate.getText()) >= 1){
            JOptionPane.showMessageDialog(null, 
            "Invalid input! Please input again","Java Banking", 
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, banking, 
        "Java Banking", JOptionPane.OK_CANCEL_OPTION);
        }
        if(result == JOptionPane.OK_OPTION){
            JOptionPane.showMessageDialog(null, 
            "The total balance is " + 
            (int) (Integer.parseInt(balance.getText())*
            Math.pow((1 + Double.parseDouble(rate.getText())),Integer.parseInt(month.getText()))) 
            + " VND", "Java Banking", JOptionPane.INFORMATION_MESSAGE);
        }
        else result = WindowConstants.EXIT_ON_CLOSE;
    }
}
