import javax.swing.*;
public class BiggestSmallest {
    public static void main(String[] args) {
        JTextField num1 = new JTextField();
        JTextField num2 = new JTextField();
        JTextField num3 = new JTextField();
        JTextField num4 = new JTextField();
        Box num = Box.createVerticalBox();
        num.add(new JLabel("Input number 1: "));
        num.add(num1);
        num.add(new JLabel("Input number 2: "));
        num.add(num2);
        num.add(new JLabel("Input number 3: "));
        num.add(num3);        
        num.add(new JLabel("Input number 4: "));
        num.add(num4);
        int result = JOptionPane.showConfirmDialog(null, num, "Java Biggest Smallest", JOptionPane.OK_CANCEL_OPTION);
        double n1 = Double.parseDouble(num1.getText());
        double n2 = Double.parseDouble(num2.getText());
        double n3 = Double.parseDouble(num3.getText());
        double n4 = Double.parseDouble(num4.getText());
        double A[] = {n1,n2,n3,n4};
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
        JOptionPane.showMessageDialog(null, "The biggest number is " + A[A.length - 1] + "\nThe smallest number is " 
        + A[0],  "Java Biggest Smallest", JOptionPane.INFORMATION_MESSAGE);
    }
    else result = WindowConstants.EXIT_ON_CLOSE;
}
}