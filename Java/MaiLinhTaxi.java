package Java;
import javax.swing.*;
public class MaiLinhTaxi {
    public static void main(String[] args) {
        String distance = JOptionPane.showInputDialog(null,"Input distance (in km): ", "Java Mai Linh Taxi", 
        JOptionPane.INFORMATION_MESSAGE);
        while(Double.parseDouble(distance) <= 0 || Double.parseDouble(distance) > Math.pow(10, 9)){
            distance = JOptionPane.showInputDialog(null,"Invalid distance! Please input distance again (in km): ", 
            "Java Mai Linh Taxi", JOptionPane.WARNING_MESSAGE);
        }
        if(Double.parseDouble(distance) <= 1){
            JOptionPane.showMessageDialog(null, "Distance to be traveled is " + distance + " km"
            + "\nYour taxi fare is 15.000 VND", "Java Mai Linh Taxi", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (Double.parseDouble(distance) > 1 && Double.parseDouble(distance) <= 5){
            JOptionPane.showMessageDialog(null, "Distance to be traveled is " + distance + " km"
            + "\nYour taxi fare is " + (15 + (Double.parseDouble(distance) - 1)*13.5)*1000 
            + " VND","Java Mai Linh Taxi", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (Double.parseDouble(distance) > 5){
            JOptionPane.showMessageDialog(null, "Distance to be traveled is " + distance + " km"
            + "\nYour taxi fare is " + 
            (15 + (Double.parseDouble(distance) - 1)*13.5 + (Double.parseDouble(distance) - 5)*11)*1000 + " VND",
            "Java Mai Linh Taxi", JOptionPane.INFORMATION_MESSAGE);
        } 
        else if (Double.parseDouble(distance) > 12){
            JOptionPane.showMessageDialog(null, "Distance to be traveled is " + distance + " km"
            + "\nYour taxi fare is " + 
            (0.1*((15 + (Double.parseDouble(distance) - 1)*13.5 + (Double.parseDouble(distance) - 5)*11)))*1000 + " VND",
            "Java Mai Linh Taxi", JOptionPane.INFORMATION_MESSAGE);
        }
    }    
}
