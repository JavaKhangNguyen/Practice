package Java;
import java.lang.Math;
import javax.swing.*;
public class StoreClerkGUI {
    public static void main(String[] args) {
        JTextField quantity = new JTextField();
        JTextField price = new JTextField();
        Box payment = Box.createVerticalBox();
        payment.add(new JLabel("Input product's quantity:"));
        payment.add(quantity);
        payment.add(new JLabel("Input product price (VND):"));
        payment.add(price);
        double result = JOptionPane.showConfirmDialog(null, payment, "Store Clerk", JOptionPane.OK_CANCEL_OPTION);
        double pay = 1.1*(Integer.parseInt(quantity.getText())*Integer.parseInt(price.getText()));
        if(Integer.parseInt(quantity.getText()) < 0 |  Integer.parseInt(price.getText()) > Math.pow(10,9) | 
        Integer.parseInt(price.getText()) < 0 | Integer.parseInt(quantity.getText()) > Math.pow(10,9)){
            JOptionPane.showMessageDialog(null, "Invalid input!", "Store Clerk",JOptionPane.WARNING_MESSAGE);
        }
        else if (result == JOptionPane.OK_OPTION){
            JOptionPane.showMessageDialog(null,"The total price is "+ (int)pay  + " VND","Store Clerk",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}