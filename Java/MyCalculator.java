package Java;
import java.lang.Math;
import java.time.LocalDate;
import java.util.Calendar;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
public class MyCalculator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select function to compute: ");
        System.out.println("[1] Addition" + " [2] Subtraction " + " [3] Multiplication " + " [4] Division " + " [5] Angular calculator" + " [6] Age calculator (by year)" + " [7] Age calculator (by date)");
        int n = sc.nextInt();
        if(n!=1 && n!=2 && n!=3 && n!=4 && n!=5 && n!=6 && n!=7){System.out.print("Invalid input!");;}
        else{
        switch (n) {
            case 1:
            System.out.print("Input integer 1: ");
            int n1 = sc.nextInt();
            System.out.print("Input integer 2: ");
            int n2 = sc.nextInt();
            double sum = n1 + n2;
            System.out.print(n1 +" + " + n2 + " = " + sum);
                break;
            case 2:
            System.out.print("Input integer 1: ");
            int no1 = sc.nextInt();
            System.out.print("Input integer 2: ");
            int no2 = sc.nextInt();
            double subtract = no1 - no2;
            System.out.print(no1 +" - " + no2 + " = " + subtract);
                break;
            case 3:
            System.out.print("Input integer 1: ");
            int num1 = sc.nextInt();
            System.out.print("Input integer 2: ");
            int num2 = sc.nextInt();
            double product = num1*num2;
            System.out.print(num1 +" * " + num2 + " = " + product); 
                break;
            case 4: 
            System.out.print("Input integer 1: ");
            int number1 = sc.nextInt();
            System.out.print("Input integer 2: ");
            int number2 = sc.nextInt();
            float div = (float)number1/number2;
            System.out.print(number1 +" / " + number2 + " = ");
            System.out.format("%.2f",div);    
                break;
            case 5:
            System.out.print("Select function to compute: ");
                System.out.println(" [1] Sin" + " [2] Cos " + " [3] Tan " + " [4] Cot ");
                int angle = sc.nextInt();
                if(angle!=1 && angle!=2 && angle!=3 && angle!=4){System.out.print("Invalid input!");;}
                else 
                {
                System.out.print("Input desired angle (unit in degrees): ");
                double degree = sc.nextDouble();
                double radian = degree*Math.PI/180;
                switch (angle) {
                case 1:
                System.out.printf("Sin of input angle is ");
                System.out.format("%.2f",Math.sin(radian));
                    break;
                case 2:
                System.out.print("Cos of input angle is ");
                System.out.format("%.2f",Math.cos(radian));
                    break;
                case 3:
                System.out.print("Tan of input angle is "); 
                System.out.format("%.2f",Math.tan(radian));   
                    break;
                default:
                System.out.print("Cot of input angle is ");
                System.out.format("%.2f",1/(Math.tan(radian)));
                    break;
                }
            }    
                break;
            case 6:
            System.out.print("Input year of birth: ");
            int yearofbirth = sc.nextInt();
            long currentyear = Calendar.getInstance().get(Calendar.YEAR);
            if(yearofbirth > currentyear| yearofbirth < 0){System.out.print("Invalid input!");}
            else{
            System.out.print("Current age is " + (currentyear - yearofbirth));}
                break;
            case 7: 
            System.out.print("Input year of birth: ");
            int yearbirth = sc.nextInt();
            if(yearbirth > Calendar.getInstance().get(Calendar.YEAR) | yearbirth < 0){System.out.print("Invalid input!");}
            else{
            System.out.print("Input month of birth: ");
            int monthofbirth = sc.nextInt();
            System.out.print("Input date of birth: ");
            int dateofbirth = sc.nextInt();
            LocalDate birthyear = LocalDate.of(yearbirth,monthofbirth,dateofbirth);
            LocalDate thisyear = LocalDate.now();
            System.out.print("Current age is " + ChronoUnit.YEARS.between(birthyear,thisyear));
        }
                break;
            default:
                break; 
}
}
sc.close();
}
}

