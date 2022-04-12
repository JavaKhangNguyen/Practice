package Java;
import javax.swing.*;
import java.text.DecimalFormat;
public class PaceSpeed {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        JTextField distance = new JTextField();
        JTextField hour = new JTextField();
        JTextField minute = new JTextField();
        JTextField second = new JTextField();
        Box a = Box.createVerticalBox();
        a.add(new JLabel("Calculating pace (minute/km) and speed (km/h) with known running time and distance"));
        a.add(new JLabel("Enter running distance (in km):"));
        a.add(distance);
        a.add(new JLabel("Enter running hours:"));
        a.add(hour);
        a.add(new JLabel("Enter running minute:"));
        a.add(minute);
        a.add(new JLabel("Enter running second:"));
        a.add(second);
        int result = JOptionPane.showConfirmDialog(null, a, "Java Marathon Calculator", JOptionPane.OK_CANCEL_OPTION);
        double distances = Double.parseDouble(distance.getText());
        double hours = Double.parseDouble(hour.getText());
        double minutes = Double.parseDouble(minute.getText()); 
        double seconds = Double.parseDouble(second.getText());
        double time_in_hours = (hours*3600 + minutes*60 + seconds)/3600;
        double time_in_minutes = (hours*3600 + minutes*60 + seconds)/60;
        double speed = distances / time_in_hours;
        double pace = time_in_minutes / distances;
        while(distances <= 0 || hours <= 0 || minutes <= 0 || seconds <= 0 || distances > Math.pow(10, 9) 
        || hours > 5 || minutes >  60 || seconds > 60){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java Marathon Calculator", 
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, a, "Java Marathon Calculator", JOptionPane.OK_CANCEL_OPTION);
            distances = Double.parseDouble(distance.getText());
            hours = Double.parseDouble(hour.getText());
            minutes = Double.parseDouble(minute.getText()); 
            seconds = Double.parseDouble(second.getText());
            time_in_hours = (hours*3600 + minutes*60 + seconds)/3600;
            time_in_minutes = (hours*3600 + minutes*60 + seconds)/60;
            speed = distances / time_in_hours;
            pace = time_in_minutes / distances;
            if(result == JOptionPane.CANCEL_OPTION){
                result = WindowConstants.EXIT_ON_CLOSE;
                break;
            }
        }
        if(result == JOptionPane.OK_OPTION){
            JOptionPane.showMessageDialog(null, "Speed of the runner is " + df.format(speed) + " km/h" 
            + "\nPace of the runner is " + df.format(pace) + " minute/km", "Java Marathon Calculator", JOptionPane.INFORMATION_MESSAGE);
        }
        else result = WindowConstants.EXIT_ON_CLOSE;   
    }
}
