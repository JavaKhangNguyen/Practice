import javax.swing.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
public class AgeCalculator extends JFrame {
    public static String BirthdayCheck(String birthday){
        if((birthday.substring(3,5).compareTo("13") >= 0) | (birthday.substring(3,5).compareTo("01") < 0) 
        | (birthday.substring(0,2).compareTo("32") >= 0) | (birthday.substring(0,2).compareTo("01") < 0) 
        | (birthday.substring(6,10).compareTo("1000") < 0)){
            String BD = JOptionPane.showInputDialog(null,"Invalid input! Please input again! \n" + "Input your birthday in format dd/MM/yyyy: ",
            "Age calculator (by date)",JOptionPane.WARNING_MESSAGE);
            birthday = BirthdayCheck(BD);
        }
        return birthday;
    }
    public AgeCalculator() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Age Calculator");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel1.setText("Welcome to Java Age Calculator! Please select the desired accuracy:");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jButton1.setText("1. DATE accuracy");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jButton2.setText("2. Year accuracy");
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String birthdate = JOptionPane.showInputDialog(null,"Input your birthday in format dd/MM/yyyy: ","Age calculator (by date)",JOptionPane.QUESTION_MESSAGE) ;
            //Date month input processing
            birthdate = BirthdayCheck(birthdate);
            if((birthdate.substring(3,5).equals("04") | birthdate.substring(3,5).equals("06") 
            | birthdate.substring(3,5).equals("09") | birthdate.substring(3,5).equals("11"))){
                if(birthdate.substring(0,2).compareTo("31") >= 0){
                    String BD = JOptionPane.showInputDialog(null,"Invalid input! Please input again! \n" + "Input your birthday in format dd/MM/yyyy: ",
                    "Age calculator (by date)",JOptionPane.WARNING_MESSAGE);
                    birthdate = BirthdayCheck(BD);
                }
            }
            LocalDate birth = LocalDate.parse(birthdate,formatter);
            LocalDate birthday = LocalDate.of(birth.getYear(),birth.getMonthValue(),birth.getDayOfMonth());
            LocalDate thisyear = LocalDate.now();
            //Leap year & February processing
            while(birthday.isLeapYear() == true && birth.getMonthValue() == 2){
                if(birthdate.substring(0,2).compareTo("30") >= 0){
                    String BD = JOptionPane.showInputDialog(null,"Invalid input! Please input again! \n" + "Input your birthday in format dd/MM/yyyy: ",
                    "Age calculator (by date)",JOptionPane.WARNING_MESSAGE);
                    birthdate = BirthdayCheck(BD);
                    birth = LocalDate.parse(birthdate,formatter);
                    birthday = LocalDate.of(birth.getYear(),birth.getMonthValue(),birth.getDayOfMonth());
                    }
                else break;
                }
            while(birthday.isLeapYear() == false && birth.getMonthValue() == 2){
                if(birthdate.substring(0,2).compareTo("29") >= 0){
                    String BD = JOptionPane.showInputDialog(null,"Invalid input! Please input again! \n" + "Input your birthday in format dd/MM/yyyy: ",
                    "Age calculator (by date)",JOptionPane.WARNING_MESSAGE);
                    birthdate = BirthdayCheck(BD);
                    birth = LocalDate.parse(birthdate,formatter);
                    birthday = LocalDate.of(birth.getYear(),birth.getMonthValue(),birth.getDayOfMonth());
                    }
                else break;
            }
            JOptionPane.showMessageDialog(null, "Current age is " + ChronoUnit.YEARS.between(birthday,thisyear),"Age calculator (by date)",JOptionPane.INFORMATION_MESSAGE);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String yearofbirth = JOptionPane.showInputDialog(null,"Input year of birth: ","Age calculator (by year)",JOptionPane.QUESTION_MESSAGE);
        int birthyear = Integer.parseInt(yearofbirth);
        long currentyear = Calendar.getInstance().get(Calendar.YEAR);
        if(birthyear > currentyear| birthyear < 0 | birthyear < 1911){JOptionPane.showMessageDialog(null,"Invalid input!","Age calculator (by year)",JOptionPane.WARNING_MESSAGE);}
            else{
                JOptionPane.showMessageDialog(null,"Current age is " + (currentyear - birthyear),"Age calculator (by year)",JOptionPane.INFORMATION_MESSAGE);}
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
            java.util.logging.Logger.getLogger(AgeCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgeCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgeCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgeCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgeCalculator().setVisible(true);
            }
        });
    }
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
}
