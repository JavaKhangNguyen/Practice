package Java;
import java.lang.Math;
import java.util.Scanner;
public class StoreClerk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input product price: ");
        double productprice = sc.nextDouble();
        System.out.print("Input product quantity: ");
        int productquantity = sc.nextInt();
        if(productquantity < -(Math.pow(10,9)) && productprice > Math.pow(10,9)){System.out.print("Invalid input!");}
        sc.close();
        double payment = 1.1*(productquantity*productprice);
        System.out.print("Total payment is " );
        System.out.format("%.0f", payment);
    }
}