import java.util.Random;
import javax.swing.*;
public class MoneyExchange {
    public static void MoneyChange(int money){
            int VND500k = money/500000; 
            int VND200k = (money - 500000*VND500k)/200000;
            int VND100k = (money - (500000*VND500k + 200000*VND200k))/100000;
            int VND50k =  (money - (500000*VND500k + 200000*VND200k + 100000*VND100k))/50000;
            int VND20k = (money - (500000*VND500k + 200000*VND200k + 100000*VND100k + 50000*VND50k))/20000;
            int VND10k = (money - (500000*VND500k + 200000*VND200k + 100000*VND100k + 50000*VND50k 
            + 20000*VND20k))/10000;
            int VND5k = (money - (500000*VND500k + 200000*VND200k + 100000*VND100k + 50000*VND50k 
            + 20000*VND20k + 10000*VND10k))/5000;
            int VND2k = (money - (500000*VND500k + 200000*VND200k + 100000*VND100k + 50000*VND50k 
            + 20000*VND20k + 10000*VND10k + 5000*VND5k))/2000;
            int VND1k = (money - (500000*VND500k + 200000*VND200k + 100000*VND100k + 50000*VND50k 
            + 20000*VND20k + 10000*VND10k + 5000*VND5k + 2000*VND2k))/1000;
            JOptionPane.showMessageDialog(null, 
        "The input amount of money is " + money + " VND\n" +"Here's how this amount of money can be exchanged into: \n" 
        + "500000: " + VND500k + "\n"  + "200000: " + VND200k  + "\n" + "100000: " + VND100k + "\n"  
        + "50000: " + VND50k + "\n" + "20000: " + VND20k + "\n" + "10000: " + VND10k + "\n" + "5000: " + VND5k + "\n" 
        + "2000: " + VND2k + "\n" + "1000: " + VND1k + "\n", "Money Exchange Calculator ", 
        JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String[] args) {
        String flag = JOptionPane.showInputDialog(null, 
        "Welcome to Java Money Exchange Calculator. Please choose input mode:\n " 
        + "1. Manual\n" 
        + "2. Automatic (system will randomly choose an amount of money from 1 to 10^9)","Money Exchange Calculator", 
        JOptionPane.INFORMATION_MESSAGE);
        while(Double.parseDouble(flag)!= 1 && Double.parseDouble(flag)!= 2){
            flag = JOptionPane.showInputDialog(null, 
            "Your input is invalid! Please choose input mode again:\n "
            + "1. Manual\n" 
            + "2. Automatic (system will randomly choose an amount of money from 1 to 10^9)","Money Exchange Calculator", 
            JOptionPane.WARNING_MESSAGE);
        }
        if(Double.parseDouble(flag) == 1){
            String money = JOptionPane.showInputDialog(null, "Please input the amount of money you need to change: ", 
        "Money Exchange Calculator", JOptionPane.INFORMATION_MESSAGE);
        money = money.replaceAll("[^0-9.]", "");
        while(Double.parseDouble(money) <= 0 || Double.parseDouble(money) > Math.pow(10,9)){
            money = JOptionPane.showInputDialog(null, "Invalid input! Please input again the amount of money you need to change: ", 
            "Money Exchange Calculator", JOptionPane.INFORMATION_MESSAGE);
        }
        MoneyChange((int)Double.parseDouble(money));
        }
        else{
            Random rand = new Random();
            double money = rand.nextInt(1,(int)Math.pow(10,9));
            MoneyChange((int) money);
        }
    }
}
