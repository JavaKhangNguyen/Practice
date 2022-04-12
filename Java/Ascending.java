package Java;
import javax.swing.*;
import java.util.Arrays;
public class Ascending {
   public static void main(String[] args) {
    JTextField num1 = new JTextField();
    JTextField num2 = new JTextField();
    JTextField num3 = new JTextField();
    Box number = Box.createVerticalBox();
    number.add(new JLabel("Input number 1: "));
    number.add(num1);
    number.add(new JLabel("Input number 2: "));
    number.add(num2);
    number.add(new JLabel("Input number 3: "));
    number.add(num3);
    int result = JOptionPane.showConfirmDialog(null, number, "Java Ascending Number", JOptionPane.OK_CANCEL_OPTION);
    double n1 = Double.parseDouble(num1.getText());
    double n2 = Double.parseDouble(num2.getText());
    double n3 = Double.parseDouble(num3.getText());
    double A[] = {n1,n2,n3};
    for(int i = A.length - 1; i >= 1; i--){
        for(int j = 0; j < i; j++){
            if(A[j] > A[j + 1]){
                double temp = A[j];
                A[j] = A[j + 1];
                A[j + 1] = temp;
            }
        }
}
    if(result == JOptionPane.OK_OPTION){
    JOptionPane.showMessageDialog(null, "Numbers in ascending order: " + Arrays.toString(A), "Java Ascending Number", 
    JOptionPane.INFORMATION_MESSAGE);
    }
    else result = WindowConstants.EXIT_ON_CLOSE;
}
}
