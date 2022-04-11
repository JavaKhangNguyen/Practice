import javax.swing.*;
public class CinemaTicket {
    public static void main(String[] args) {
        JTextField hour = new JTextField();    
        JTextField day_of_week = new JTextField();
        Box cinema = Box.createVerticalBox();
        cinema.add(new JLabel("Welcome to Java Cinema!"));
        cinema.add(new JLabel("Enter day of week: "));
        cinema.add(day_of_week);
        cinema.add(new JLabel("Enter hour: "));
        cinema.add(hour);
        int result = JOptionPane.showConfirmDialog(null, cinema, "Java Cinema", JOptionPane.OK_CANCEL_OPTION);
        while(Integer.parseInt(hour.getText()) < 0 || Integer.parseInt(hour.getText()) >= 24 || 
        Integer.parseInt(day_of_week.getText()) < 2 || Integer.parseInt(day_of_week.getText()) > 8){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java Cinema", 
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, cinema, "Java Cinema", JOptionPane.OK_CANCEL_OPTION);
        }
        if(result == JOptionPane.OK_OPTION){
            if(Integer.parseInt(day_of_week.getText()) == 3){
                JOptionPane.showMessageDialog(null, "It's Happy Day! Your ticket costs 50.000 VND",  "Java Cinema", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
            if(Integer.parseInt(hour.getText()) < 17){
                if(Integer.parseInt(day_of_week.getText()) == 2 || Integer.parseInt(day_of_week.getText()) == 4 || 
                Integer.parseInt(day_of_week.getText()) == 5){
                    JOptionPane.showMessageDialog(null, "Your ticket costs 60.000 VND",  "Java Cinema", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
                else if(Integer.parseInt(day_of_week.getText()) == 6 || Integer.parseInt(day_of_week.getText()) == 7 || 
                Integer.parseInt(day_of_week.getText()) == 8){
                    JOptionPane.showMessageDialog(null, "Your ticket costs 75.000 VND",  "Java Cinema", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else {
                if(Integer.parseInt(day_of_week.getText()) == 2 || Integer.parseInt(day_of_week.getText()) == 4 || 
                Integer.parseInt(day_of_week.getText()) == 5){
                    JOptionPane.showMessageDialog(null, "Your ticket costs 70.000 VND",  "Java Cinema", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
                else if(Integer.parseInt(day_of_week.getText()) == 6 || Integer.parseInt(day_of_week.getText()) == 7 || 
                Integer.parseInt(day_of_week.getText()) == 8){
                    JOptionPane.showMessageDialog(null, "Your ticket costs 80.000 VND",  "Java Cinema", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}
