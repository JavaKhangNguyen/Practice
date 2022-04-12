package Java;
import java.util.Scanner;
public class TriangleOOP {
    private double edge1, edge2, edge3;
    public TriangleOOP(double edge1, double edge2, double edge3){
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.edge3 = edge3;
    }

    public double getEdge1(){
        return edge1;
    }
    public double getEdge2(){
        return edge2;
    }
    public double getEdge3(){
        return edge3;
    }
    public double Area(){
        double halfperi = Perimeter()/2;
        return Math.sqrt(halfperi*(halfperi - edge1)*(halfperi - edge2)*(halfperi - edge3));
    }
    public double Perimeter(){
        return (edge1 + edge2 + edge3);
    }
    public boolean TriangleCheck(double edge1, double edge2, double edge3){
        if(edge1 == edge2 && edge1 == edge3 && edge2 == edge3){
            return true;
        }
        else if(edge1 == edge2 || edge1 == edge3 || edge2 == edge3){
            return true;
        }
        else if(edge1 + edge2 >= edge3 && edge1 + edge3 >= edge2 && edge2 + edge3 >= edge1){
            return true;
        }
        else return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of edge 1: ");
        double edge1 = sc.nextDouble();
        System.out.print("Enter the length of edge 2: ");
        double edge2 = sc.nextDouble();
        System.out.print("Enter the length of edge 3: ");
        double edge3 = sc.nextDouble();
        while(edge1 <= 0 || edge2 <= 0 || edge3 <= 0 || edge1 > Math.pow(10,9) || edge2 > Math.pow(10,9) 
        || edge3 > Math.pow(10,9)){
            System.out.println("Invalid input! Please input again!");
            System.out.print("Enter the length of edge 1: ");
            edge1 = sc.nextDouble();
            System.out.print("Enter the length of edge 2: ");
            edge2 = sc.nextDouble();
            System.out.print("Enter the length of edge 3: ");
            edge3 = sc.nextDouble();
        }
        TriangleOOP t1 = new TriangleOOP(edge1, edge2, edge3);
        while(t1.TriangleCheck(edge1, edge2, edge3) == false){
            System.out.println("This is not a triangle! Please input again!");
            System.out.print("Enter the length of edge 1: ");
            edge1 = sc.nextDouble();
            System.out.print("Enter the length of edge 2: ");
            edge2 = sc.nextDouble();
            System.out.print("Enter the length of edge 3: ");
            edge3 = sc.nextDouble();
        }
        t1 = new TriangleOOP(edge1, edge2, edge3);
        System.out.printf("\nPerimeter of the triangle is %.2f ", t1.Perimeter());
        System.out.printf("Area of the triangle is %.2f ",t1.Area());
        sc.close();
    }
} 
