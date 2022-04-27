package Java;
import javax.swing.*;
public class RSP {
    public static void main(String[] args) {
        JTextField player1 = new JTextField();
        JTextField player2 = new JTextField();
        Box RSP = Box.createVerticalBox();
        RSP.add(new JLabel("Enter player 1's decision: "));
        RSP.add(player1);
        RSP.add(new JLabel("Enter player 2's decision: "));
        RSP.add(player2);
        int result = JOptionPane.showConfirmDialog(null, RSP,"Rock Paper Scissors",
        JOptionPane.OK_CANCEL_OPTION);
        if(result == JOptionPane.CANCEL_OPTION){
            result = WindowConstants.EXIT_ON_CLOSE;
        }
        else {
            while(player1.getText().equalsIgnoreCase("R") == false && 
            player1.getText().equalsIgnoreCase("S") == false && 
            player1.getText().equalsIgnoreCase("P") == false &&
            player2.getText().equalsIgnoreCase("R") == false && 
            player2.getText().equalsIgnoreCase("S") == false && 
            player2.getText().equalsIgnoreCase("P") == false){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again",
            "Rock Paper Scissor",JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, RSP,"Rock Paper Scissor",
            JOptionPane.OK_CANCEL_OPTION);
            }
            if(player1.getText().equalsIgnoreCase(player2.getText())){
                JOptionPane.showMessageDialog(null,"Draw","Rock Paper Scissors",
                JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                if(player1.getText().equalsIgnoreCase("R")){
                    if(player2.getText().equalsIgnoreCase("S")){
                        JOptionPane.showMessageDialog(null,"Player 1 wins",
                        "Rock Paper Scissors",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Player 2 wins",
                        "Rock Paper Scissors",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else if(player1.getText().equalsIgnoreCase("S")){
                    if(player2.getText().equalsIgnoreCase("P")){
                        JOptionPane.showMessageDialog(null,"Player 1 wins",
                        "Rock Paper Scissors",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Player 2 wins",
                        "Rock Paper Scissors",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else {
                    if(player2.getText().equalsIgnoreCase("R")){
                        JOptionPane.showMessageDialog(null,"Player 1 wins",
                        "Rock Paper Scissors",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Player 2 wins",
                        "Rock Paper Scissors",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
        
    }
}
