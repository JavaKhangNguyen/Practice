package Java;
import javax.swing.*;
import java.text.DecimalFormat;
public class EquationsGUI extends JFrame {

     public static void LinearEquation(){
            DecimalFormat df = new DecimalFormat("0.00");
            JTextField a = new JTextField();
            JTextField b = new JTextField();
            Box math = Box.createVerticalBox();
            math.add(new JLabel("Input a: "));
            math.add(a);
            math.add(new JLabel("Input b:"));
            math.add(b);
            int result = JOptionPane.showConfirmDialog(null, math, "Java Calculator", JOptionPane.OK_CANCEL_OPTION);
            while(Double.parseDouble(a.getText()) < -Math.pow(10, 9) || Double.parseDouble(b.getText()) < -Math.pow(10, 9) || 
            Double.parseDouble(a.getText()) > Math.pow(10, 9) || Double.parseDouble(b.getText()) > Math.pow(10, 9)){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java Calculator", JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, math, "Java Calculator", JOptionPane.OK_CANCEL_OPTION);
            if(result == JOptionPane.CANCEL_OPTION){
                result = WindowConstants.EXIT_ON_CLOSE;
                break;
            }
        }
        if(result == JOptionPane.OK_OPTION){
            if(Double.parseDouble(a.getText()) == 0){
                if(Double.parseDouble(b.getText()) == 0){
                    JOptionPane.showMessageDialog(null, "x has infinite number of roots" , "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
                else JOptionPane.showMessageDialog(null, "Equation has no roots!" , "Java Calculator", 
                JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            else {
                if(Double.parseDouble(b.getText()) == 0){
                    JOptionPane.showMessageDialog(null, "x = " 
            + df.format(Math.abs(-Double.parseDouble(b.getText())/Double.parseDouble(a.getText()))), "Java Calculator", 
            JOptionPane.INFORMATION_MESSAGE);
                }
                else
                JOptionPane.showMessageDialog(null, "x = " 
            + df.format(-Double.parseDouble(b.getText())/Double.parseDouble(a.getText())), "Java Calculator", 
            JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
    }
    
    public static void BinomialEquation(){
            DecimalFormat df = new DecimalFormat("0.00");
            JTextField a1 = new JTextField();
            JTextField b1 = new JTextField();
            JTextField c1 = new JTextField();
            Box polynomial = Box.createVerticalBox();
            polynomial.add(new JLabel("Input a: "));
            polynomial.add(a1);
            polynomial.add(new JLabel("Input b:"));
            polynomial.add(b1);
            polynomial.add(new JLabel("Input c: "));
            polynomial.add(c1);
            int poly_result = JOptionPane.showConfirmDialog(null, polynomial, "Java Calculator", 
            JOptionPane.OK_CANCEL_OPTION);
            double num_a = Double.parseDouble(a1.getText());
            double num_b = Double.parseDouble(b1.getText());
            double num_c = Double.parseDouble(c1.getText());
            double delta = Math.pow(num_b,2) - 4*num_a*num_c;
            while(num_a < -Math.pow(10, 9) || num_b< -Math.pow(10, 9) || num_c < -Math.pow(10, 9)||num_a > Math.pow(10, 9) 
            ||num_b > Math.pow(10, 9) ||num_c > Math.pow(10, 9)){
                JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java Calculator", 
                JOptionPane.WARNING_MESSAGE);
                poly_result = JOptionPane.showConfirmDialog(null, polynomial, "Java Calculator", 
                JOptionPane.OK_CANCEL_OPTION);
                num_a = Double.parseDouble(a1.getText());
                num_b = Double.parseDouble(b1.getText());
                num_c = Double.parseDouble(c1.getText());
                if(poly_result == JOptionPane.CANCEL_OPTION){
                    poly_result = WindowConstants.EXIT_ON_CLOSE;
                break;
            }
            }
            if(poly_result == JOptionPane.OK_OPTION){
                if(num_a == 0){
                    delta = Math.pow(num_b,2);
                    if(delta > 0){
                        if(num_c == 0){
                            JOptionPane.showMessageDialog(null, "x = " + df.format(Math.abs((-num_c / num_b))) , 
                            "Java Calculator", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "x = " + df.format(((-num_c / num_b))) , "Java Calculator", 
                        JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                    }

                    else if(delta == 0){
                        if(num_c == 0){
                            JOptionPane.showMessageDialog(null, "x has infinite number of roots " , "Java Calculator", 
                        JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Equation has no root! ", "Java Calculator", 
                            JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    return;
                }

                delta = Math.pow(num_b,2) - 4*num_a*num_c;
                if(delta > 0){
                    JOptionPane.showMessageDialog(null, "x1 = " + df.format(((- num_b - Math.sqrt(delta))/(2*num_a))) + 
                    " , x2 = " + df.format(((-num_b + Math.sqrt(delta))/(2*num_a))) , "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
                else if(delta == 0){
                    if(num_c == 0){
                        JOptionPane.showMessageDialog(null, "x = " + df.format(Math.abs((-num_b/2*num_a))), "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "x = " + df.format((-num_b/2*num_a)), "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                }
                else {JOptionPane.showMessageDialog(null, "Equation has no root! ", "Java Calculator", 
                JOptionPane.INFORMATION_MESSAGE);}
                
            }
    }

    public static void BiquadraticEquation(){
        DecimalFormat df = new DecimalFormat("0.00");
        JTextField a1 = new JTextField();
        JTextField b1 = new JTextField();
        JTextField c1 = new JTextField();
        Box biquadratic = Box.createVerticalBox();
        biquadratic.add(new JLabel("Input a: "));
        biquadratic.add(a1);
        biquadratic.add(new JLabel("Input b:"));
        biquadratic.add(b1);
        biquadratic.add(new JLabel("Input c: "));
        biquadratic.add(c1);
        int biquad_result = JOptionPane.showConfirmDialog(null, biquadratic, "Java Calculator", 
        JOptionPane.OK_CANCEL_OPTION);
        double num_a = Double.parseDouble(a1.getText());
        double num_b = Double.parseDouble(b1.getText());
        double num_c = Double.parseDouble(c1.getText());
        double delta = Math.pow(num_b,2) - 4*num_a*num_c;
        while(num_a < -Math.pow(10, 9) || num_b< -Math.pow(10, 9) || num_c < -Math.pow(10, 9)||num_a > Math.pow(10, 9) 
        ||num_b > Math.pow(10, 9) ||num_c > Math.pow(10, 9)){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java Calculator", 
            JOptionPane.WARNING_MESSAGE);
            biquad_result = JOptionPane.showConfirmDialog(null, biquadratic, "Java Calculator", 
            JOptionPane.OK_CANCEL_OPTION);
            num_a = Double.parseDouble(a1.getText());
            num_b = Double.parseDouble(b1.getText());
            num_c = Double.parseDouble(c1.getText());
            
            if(biquad_result == JOptionPane.CANCEL_OPTION){
                biquad_result = WindowConstants.EXIT_ON_CLOSE;
            break;
        }
        }
        if(biquad_result == JOptionPane.OK_OPTION){
            if(num_a == 0){
                delta = -4*num_b*num_c;
                if(delta > 0){
                    JOptionPane.showMessageDialog(null, "x1 = " + df.format(((-Math.sqrt(delta))/(2*num_b))) + 
                    " , x2 = " + df.format(((Math.sqrt(delta))/(2*num_b))) , "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
                else if(delta == 0){
                    if(num_c == 0){
                        if(num_b == 0){
                            JOptionPane.showMessageDialog(null, "x has infinite number of roots " , "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                    else if(num_b != 0){
                        JOptionPane.showMessageDialog(null, "x = 0 ", "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                    else
                    JOptionPane.showMessageDialog(null, "Equation has no root! ", "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
                else {JOptionPane.showMessageDialog(null, "Equation has no root! ", "Java Calculator", 
                JOptionPane.INFORMATION_MESSAGE);}
                return;
            }
            delta = Math.pow(num_b,2) - 4*num_a*num_c;
            if(delta > 0){
                double t1 = ((- num_b - Math.sqrt(delta))/(2*num_a));
                double t2 = ((- num_b + Math.sqrt(delta))/(2*num_a));
                if(t1 < 0 && t2 < 0){
                    JOptionPane.showMessageDialog(null, "Equation has no root! ", "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
                if(t1 > 0 && t2 > 0){
                    JOptionPane.showMessageDialog(null, "x1 = " + df.format(Math.sqrt(t1)) + ", x2 = " 
                    + df.format(-Math.sqrt(t1)) + ", x3 = " + df.format(Math.sqrt(t2))+ ", x4 = " 
                    + df.format(-Math.sqrt(t2)), "Java Calculator", JOptionPane.INFORMATION_MESSAGE);
                }
                if(t1 < 0 && t2 > 0){
                    JOptionPane.showMessageDialog(null, "x1 = " + df.format(Math.sqrt(t2)) + ", x2 = " 
                    + df.format(-Math.sqrt(t2)) , "Java Calculator", JOptionPane.INFORMATION_MESSAGE);
                }
                if(t2 < 0 && t1 > 0){
                    JOptionPane.showMessageDialog(null, "x1 = " + df.format(Math.sqrt(t1)) + ", x2 = " 
                    + df.format(-Math.sqrt(t1)) , "Java Calculator", JOptionPane.INFORMATION_MESSAGE);
                }
                if(t1 == 0 && t2 > 0){
                    JOptionPane.showMessageDialog(null, "x1 = " + df.format(Math.sqrt(t1)) + ", x2 = " 
                    + df.format(Math.sqrt(t2)) + ", x3 = " + df.format(-Math.sqrt(t2)), "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
                if(t2 == 0 && t1 > 0){
                    JOptionPane.showMessageDialog(null, "x1 = " + df.format(Math.sqrt(t2)) + ", x2 = " 
                    + df.format(Math.sqrt(t1)) + ", x3 = " + df.format(-Math.sqrt(t1)), "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
                if(t1 == 0 && t2 < 0){
                    JOptionPane.showMessageDialog(null, "x = " + df.format(Math.sqrt(t1)), "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
                if(t2 == 0 && t1 < 0){
                    JOptionPane.showMessageDialog(null, "x = " + df.format(Math.sqrt(t2)), "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else if(delta == 0){
                if(num_c == 0){
                    JOptionPane.showMessageDialog(null, "x = " + df.format(Math.abs(Math.sqrt((-num_b/2*num_a)))), 
                    "Java Calculator", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if(Math.sqrt((-num_b/2*num_a)) == 0){
                    JOptionPane.showMessageDialog(null, "x = " + df.format(Math.sqrt((-num_b/2*num_a))), 
                    "Java Calculator", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(Math.sqrt((-num_b/2*num_a)) > 0){
                    JOptionPane.showMessageDialog(null, "x1 = " + df.format(Math.sqrt((-num_b/2*num_a))) 
                + ", x2 = " + df.format(-Math.sqrt((-num_b/2*num_a))), "Java Calculator", 
                JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Equation has no root! ", "Java Calculator", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else {JOptionPane.showMessageDialog(null, "Equation has no root! ", "Java Calculator", 
            JOptionPane.INFORMATION_MESSAGE);}
        }
    }

    public EquationsGUI() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Calculator");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); 
        jLabel1.setText("Welcome to Java Calculator! Select type of equation you want:");

        jButton1.setText("Linear equation ax + b = 0");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Binomial equation");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Biquadratic equation");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(50, 50, 50)
                .addComponent(jButton2)
                .addGap(51, 51, 51)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(89, 89, 89))
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        
        BinomialEquation();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        BiquadraticEquation();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        LinearEquation();
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
            java.util.logging.Logger.getLogger(EquationsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EquationsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EquationsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EquationsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EquationsGUI().setVisible(true);
            }
        });
    }
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;

}
