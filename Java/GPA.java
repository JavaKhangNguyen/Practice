package Java;
import javax.swing.*;
import java.text.DecimalFormat;
public class GPA {
    public static String getRank(double GPA){
        if(GPA >= 8.5 && GPA <= 10){
            return "A";
        }
        if(GPA >= 7 && GPA < 8.5){
            return "B";
        }
        if(GPA >= 5.5 && GPA < 7){
            return "C";
        }
        if(GPA >= 4 && GPA < 5.5){
            return "D";
        }
        else return "F";
    }
    public static String getClassification(double GPA){
        if(GPA >= 9 && GPA <= 10){
            return "Outstanding";
        }
        if(GPA >= 8 && GPA < 9){
            return "Excellent";
        }
        if(GPA >= 7 && GPA < 8){
            return "Good";
        }
        if(GPA >= 6 && GPA < 7){
            return "Above Average";
        }
        if(GPA >= 5 && GPA < 6){
            return "Average";
        }
        else return "Below Average";
    }
    public static String Qualify(double GPA){
        if(GPA >= 5){
            return "PASSED";
        }
        else return "FAILED";
    }
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.0");
        JTextField assignment = new JTextField();
        JTextField lab = new JTextField();
        JTextField finalscore = new JTextField();
        JTextField cheating = new JTextField();
        Box a = Box.createVerticalBox();
        a.add(new JLabel("Calculating GPA"));
        a.add(new JLabel("Enter student's assignment score:"));
        a.add(assignment);
        a.add(new JLabel("Enter stduent lab's score:"));
        a.add(lab);
        a.add(new JLabel("Enter student's final score:"));
        a.add(finalscore);
        a.add(new JLabel("Student cheating?"));
        a.add(new JLabel("0. No"));
        a.add(new JLabel("1. Yes"));
        a.add(cheating);
        int result = JOptionPane.showConfirmDialog(null, a, "Java GPA Calculator", JOptionPane.OK_CANCEL_OPTION);
        double assignments = Double.parseDouble(assignment.getText());
        double labs = Double.parseDouble(lab.getText());
        double finalresult = Double.parseDouble(finalscore.getText()); 
        int cheatings = Integer.parseInt(cheating.getText());
        double GPA = 0.3*assignments + 0.3*labs + 0.4*finalresult;
        if(cheatings == 1){
            GPA = 0;
        }
        while(assignments < 0 || labs < 0 || finalresult < 0 || assignments > 10 
        || labs > 10 || finalresult >  10 || (cheatings != 0 && cheatings != 1)){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java GPA Calculator", 
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, a, "Java GPA Calculator", JOptionPane.OK_CANCEL_OPTION);
            assignments = Double.parseDouble(assignment.getText());
            labs = Double.parseDouble(lab.getText());
            finalresult = Double.parseDouble(finalscore.getText()); 
            cheatings = Integer.parseInt(cheating.getText());
            GPA = 0.3*assignments + 0.3*labs + 0.4*finalresult;
            if(cheatings == 1){
                GPA = 0;
            }
            if(result == JOptionPane.CANCEL_OPTION){
                result = WindowConstants.EXIT_ON_CLOSE;
                break;
            }
        }
        if(result == JOptionPane.OK_OPTION){
            JOptionPane.showMessageDialog(null, "Student's GPA is " + df.format(GPA) + " - "+ Qualify(GPA) + "\n" 
            + getClassification(GPA) + " - Rank: " + getRank(GPA) , "Java GPA Calculator", 
            JOptionPane.INFORMATION_MESSAGE);
        }
        else result = WindowConstants.EXIT_ON_CLOSE;   
    }
}
