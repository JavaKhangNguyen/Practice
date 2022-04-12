package Java;
import java.util.Scanner;
import java.lang.Math;
public class ElectricConsumer {
    public static void main(String[] args) {
        Scanner elec = new Scanner(System.in);
        System.out.print("Input the amount of electricity used this month (unit kWh): ");
        int current = elec.nextInt();
        System.out.print("Input the amount of electricity used last month (unit kWh): ");
        int prev = elec.nextInt();
        elec.close();
        if(prev < 0 && prev > current && current > Math.pow(10,9)){System.out.print("Invalid input!");}
        else System.out.print("The amount of electricity used is " + (current - prev) + " kWh");
    }
}
