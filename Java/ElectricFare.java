package Java;
import javax.swing.*;
public class ElectricFare {
    public static void main(String[] args) {
        JTextField current = new JTextField();
        JTextField previous = new JTextField();
        Box electric = Box.createVerticalBox();
        electric.add(new JLabel("Electric meter's index last month (in kWh):"));
        electric.add(previous);
        electric.add(new JLabel("Electric meter's index this month (in kWh): "));
        electric.add(current);
        int result = JOptionPane.showConfirmDialog(null, electric, "Java Electric Fare", JOptionPane.OK_CANCEL_OPTION);
        while(Integer.parseInt(previous.getText()) < 0 || Integer.parseInt(previous.getText()) > Math.pow(10, 9) || 
        Integer.parseInt(previous.getText()) > Integer.parseInt(current.getText()) || 
        Integer.parseInt(current.getText()) < 0 || Integer.parseInt(current.getText()) > Math.pow(10, 9)){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again", "Java Electric Fare", 
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, electric, "Java Electric Fare", JOptionPane.OK_CANCEL_OPTION);
        }
        int usage = Integer.parseInt(current.getText()) - Integer.parseInt(previous.getText());
        if(result == JOptionPane.OK_OPTION){
            if(usage <= 50){
                JOptionPane.showMessageDialog(null, "Your electric bill this month is " + (int) (1.1*(usage*1484)) + " VND",
                "Java Electric Fare", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(usage >= 51 && usage <= 100){
                JOptionPane.showMessageDialog(null, "Your electric bill this month is " 
                + (int) (1.1*(usage*1484 + (usage - 50)*1533)) + " VND","Java Electric Fare", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(usage >= 101 && usage <= 200){
                JOptionPane.showMessageDialog(null, "Your electric bill this month is " 
                + (int) (1.1*(50*1484 + 50*1533 + (usage-100)*1786)) + " VND","Java Electric Fare", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(usage >= 201 && usage <= 300){
                JOptionPane.showMessageDialog(null, "Your electric bill this month is " 
                + (int) (1.1*(50*1484 + 50*1533 + 100*1786 + (usage - 200)*2242)) + " VND","Java Electric Fare", 
                JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(usage >= 301 && usage <= 400){
                JOptionPane.showMessageDialog(null, "Your electric bill this month is " 
                + (int) (1.1*(50*1484 + 50*1533 + 100*1786 + 100*2242 + (usage - 300)*2503)) 
                + " VND","Java Electric Fare", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            else {
                JOptionPane.showMessageDialog(null, "Your electric bill this month is " 
                + (int) (1.1*(50*1484 + 50*1533 + 100*1786 + 100*2242 + 100*2503 + (usage - 400)*2587)) + " VND",
                "Java Electric Fare", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        else result = WindowConstants.EXIT_ON_CLOSE;
    }
}
