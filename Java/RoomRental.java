package Java;
import javax.swing.*;
import java.text.DecimalFormat;
public class RoomRental {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0");
        JTextField type = new JTextField();
        JTextField numofdays = new JTextField();
        Box room = Box.createVerticalBox();
        room.add(new JLabel("Enter the number of rental days:"));
        room.add(numofdays);
        room.add(new JLabel("Enter type of room (A,B,C): "));
        room.add(type);
        int result = JOptionPane.showConfirmDialog(null, room, 
        "Java Room Rental", JOptionPane.OK_CANCEL_OPTION);
        if(result == JOptionPane.CANCEL_OPTION){
            result = WindowConstants.EXIT_ON_CLOSE;
        }
        while((type.getText().equalsIgnoreCase("A") != true && 
        type.getText().equalsIgnoreCase("B") != true && 
        type.getText().equalsIgnoreCase("C") != true) || 
        Integer.parseInt(numofdays.getText()) <= 0 || 
        Integer.parseInt(numofdays.getText()) > Math.pow(10, 9)){
            JOptionPane.showMessageDialog(null,
            "Invalid input! Please input again!","Java Room Rental", 
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, room, 
            "Java Room Rental", JOptionPane.OK_CANCEL_OPTION);
        }
        if(result == JOptionPane.OK_OPTION){
            if(type.getText().equalsIgnoreCase("A")){
                if(Integer.parseInt(numofdays.getText()) > 12){
                    JOptionPane.showMessageDialog(null, 
                    "Your rental costs " + 
                    (df.format(0.9*(450000*Double.parseDouble(numofdays.getText())))) 
                    + " VND","Java Room Rental", 
                    JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(null, 
                "Your rental costs " 
                + (df.format(450000*Double.parseDouble(numofdays.getText()))) 
                + " VND", "Java Room Rental", JOptionPane.INFORMATION_MESSAGE);
            }
            if(type.getText().equalsIgnoreCase("B")){
                if(Double.parseDouble(numofdays.getText()) > 12){
                    JOptionPane.showMessageDialog(null, 
                    "Your rental costs " + 
                    (df.format(0.92*(350000*Double.parseDouble(numofdays.getText())))) 
                    + " VND","Java Room Rental", 
                    JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(null, 
                "Your rental costs " 
                + (df.format(350000*Double.parseDouble(numofdays.getText()))) 
                + " VND","Java Room Rental", JOptionPane.INFORMATION_MESSAGE);
            }
            if(type.getText().equalsIgnoreCase("C")){
                if(Double.parseDouble(numofdays.getText()) > 12){
                    JOptionPane.showMessageDialog(null, 
                    "Your rental costs " + 
                    (df.format(0.92*(25000*Double.parseDouble(numofdays.getText())))) 
                    + " VND","Java Room Rental", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(null, 
                "Your rental costs " + (df.format(25000*Double.parseDouble(numofdays.getText()))) 
                + " VND","Java Room Rental", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }   
}