package Java;
import javax.swing.*;
public class Rounding extends JFrame {
    public static double RoundingReal(double num){
        if(num - Math.floor(num) == 0){
            return num;
        }
        return  Math.floor(num) + 0.5;
    }
    public static void RoundingInteger(int num, int key){
        if(num % Math.pow(10,key) > (int) 5*Math.pow(10,key - 1)){
        JOptionPane.showMessageDialog(null,"Rounded number is " + 
        (int) (num + (Math.pow(10,key) - (num % Math.pow(10,key)))),"Java Rounding",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null,"Rounded number is " +  
            (int) (num - (num % Math.pow(10,key))),"Java Rounding",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public Rounding() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Rounding Calculator");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel1.setText("Welcome to Java Rounding Calculator! Please select the number type to perform rounding:");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jButton1.setText("1. Integer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jButton2.setText("2. Real numbers");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(103, 103, 103))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        JTextField num = new JTextField();
        JTextField key = new JTextField();
        Box round = Box.createVerticalBox();
        round.add(new JLabel("Enter number needs rounding: "));
        round.add(num);
        round.add(new JLabel("Enter the number of 0s to be rounded up to: "));
        round.add(key);
        int result = JOptionPane.showConfirmDialog(null,round,"Java Rounding",JOptionPane.OK_CANCEL_OPTION);
        while(Integer.parseInt(key.getText()) <= 0 || Integer.parseInt(key.getText()) > 10 || 
        Integer.parseInt(num.getText()) <= 0 || Integer.parseInt(num.getText()) > Math.pow(10, 9)){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again!","Java Rounding",
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null,round,"Java Rounding",JOptionPane.OK_CANCEL_OPTION);
        }
        if(result == JOptionPane.OK_OPTION){
            RoundingInteger(Integer.parseInt(num.getText()),Integer.parseInt(key.getText()));
        }
        else {
            result = WindowConstants.EXIT_ON_CLOSE;
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String num = JOptionPane.showInputDialog(null,"Input a number for rounding: ","Java Rounding",
        JOptionPane.INFORMATION_MESSAGE);
        while(Double.parseDouble(num) <= 0 || Double.parseDouble(num) > Math.pow(10,9)){
            num = JOptionPane.showInputDialog(null,"Invalid input! Input a number for rounding: ","Java Rounding",
        JOptionPane.WARNING_MESSAGE);
        }
        JOptionPane.showMessageDialog(null,"Rounded number is " + RoundingReal(Double.parseDouble(num)),"Java Rounding",
        JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * @param args 
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Rounding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rounding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rounding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rounding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rounding().setVisible(true);
            }
        });
    }
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
}
