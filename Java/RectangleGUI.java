package Java;
import javax.swing.*;
import java.text.DecimalFormat;
public class RectangleGUI extends JFrame {
    public static double Area(double perimeter){
        return 1.5*Math.pow((perimeter/(2*(1.5 + 1))),2);
    }
    public static double Volume(double width, double depth, double height){
        return width*depth*height;
    }
    
    public RectangleGUI() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Rectangle Calculator");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel1.setText("Welcome to Java Rectangle Calculator! Please select the attribute that needs to be calculated:");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jButton1.setText("1. Area (with perimeter input)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jButton2.setText("2. Volume");
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
        DecimalFormat df = new DecimalFormat("0.00");
        String perimeter = JOptionPane.showInputDialog(null, "Enter perimeter: ", 
            "Rectangle Calculator", JOptionPane.INFORMATION_MESSAGE);
            while(Double.parseDouble(perimeter) <= 0 || Double.parseDouble(perimeter) > Math.pow(10, 9)){
                perimeter = JOptionPane.showInputDialog(null, "Invalid input! Enter perimeter again: ", 
            "Rectangle Calculator", JOptionPane.WARNING_MESSAGE);
            if(Double.parseDouble(perimeter) == JOptionPane.CANCEL_OPTION){
                double flagger = Double.parseDouble(perimeter);
                flagger = WindowConstants.EXIT_ON_CLOSE;
                break;
            }
        }
            JOptionPane.showMessageDialog(null, "Area of the rectangle is " 
            + df.format(Area(Double.parseDouble(perimeter))), "Rectangle Calculator", JOptionPane.INFORMATION_MESSAGE);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
            DecimalFormat df = new DecimalFormat("0.00");
            JTextField width_input = new JTextField();
            JTextField depth_input = new JTextField();
            JTextField height_input = new JTextField();
            Box rectangle = Box.createVerticalBox();
            rectangle.add(new JLabel("Enter width: "));
            rectangle.add(width_input);
            rectangle.add(new JLabel("Enter depth: "));
            rectangle.add(depth_input);
            rectangle.add(new JLabel("Enter height: "));
            rectangle.add(height_input);
            int result = JOptionPane.showConfirmDialog(null, rectangle, "Rectangle Calculator", 
            JOptionPane.OK_CANCEL_OPTION);
            double width = Double.parseDouble(width_input.getText());
            double depth = Double.parseDouble(depth_input.getText());
            double height = Double.parseDouble(height_input.getText());
            while(width <= 0 || depth <= 0 || height <= 0 || width > Math.pow(10, 9) || depth > Math.pow(10, 9) 
            || height > Math.pow(10, 9)){
                JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Rectangle Calculator", 
                JOptionPane.WARNING_MESSAGE);
                result = JOptionPane.showConfirmDialog(null, rectangle , "Rectangle Calculator", 
            JOptionPane.OK_CANCEL_OPTION);
            width = Double.parseDouble(width_input.getText());
            depth = Double.parseDouble(depth_input.getText());
            height = Double.parseDouble(height_input.getText());
            if(result == JOptionPane.CANCEL_OPTION){
                result = WindowConstants.EXIT_ON_CLOSE;
                break;
            }
            }    
            if(result == JOptionPane.OK_OPTION){
                JOptionPane.showMessageDialog(null, "Volume of the box is " + df.format(width*depth*height), 
                "Rectangle Calculator", JOptionPane.INFORMATION_MESSAGE);
            }   
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
            java.util.logging.Logger.getLogger(RectangleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RectangleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RectangleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RectangleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RectangleGUI().setVisible(true);
            }
        });
    }
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
}
