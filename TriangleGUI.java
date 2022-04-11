import javax.swing.*;
import java.text.DecimalFormat;
public class TriangleGUI {
   private double edge1, edge2, edge3;
   public TriangleGUI(double edge1, double edge2, double edge3){
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.edge3 = edge3;
   }
   public double Perimeter(){
      return (edge1 + edge2 + edge3);
   }
   public double Area(){
      double halfperi = Perimeter()/2;
      return Math.sqrt(halfperi*(halfperi - edge1)*(halfperi - edge2)*(halfperi - edge3));
   }
   public static boolean TriangleCheck(double edge1, double edge2, double edge3){
      if(edge1 == edge2 && edge1 == edge3 && edge2 == edge3){
          return true;
      }
      else if(edge1 == edge2 || edge1 == edge3 || edge2 == edge3){
          return true;
      }
      else if(edge1 + edge2 > edge3 && edge1 + edge3 > edge2 && edge2 + edge3 > edge1){
          return true;
      }
      else return false;
  }
   public static void main(String[] args) {
      JTextField edge1_input = new JTextField();
      JTextField edge2_input = new JTextField();
      JTextField edge3_input = new JTextField();
      Box triangle = Box.createVerticalBox();
      triangle.add(new JLabel("Enter length of edge 1: "));
      triangle.add(edge1_input);
      triangle.add(new JLabel("Enter length of edge 2: "));
      triangle.add(edge2_input);
      triangle.add(new JLabel("Enter length of edge 3: "));
      triangle.add(edge3_input);
      int result = JOptionPane.showConfirmDialog(null, triangle, "Triangle Calculator", JOptionPane.OK_CANCEL_OPTION);
      double edge1 = Double.parseDouble(edge1_input.getText());
      double edge2 = Double.parseDouble(edge2_input.getText());
      double edge3 = Double.parseDouble(edge3_input.getText());
      while(edge1 <= 0 || edge2 <= 0 || edge3 <= 0 || edge1 > Math.pow(10,9) || edge2 > Math.pow(10,9) 
      || edge3 > Math.pow(10,9) || TriangleCheck(edge1, edge2, edge3) == false){
         if(edge1 <= 0 || edge2 <= 0 || edge3 <= 0 || edge1 > Math.pow(10,9) || edge2 > Math.pow(10,9) 
         || edge3 > Math.pow(10,9)){
         JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Triangle Calculator", 
         JOptionPane.WARNING_MESSAGE);
         }
         else {JOptionPane.showMessageDialog(null, "This is not a triangle! Please input again!", "Triangle Calculator", 
         JOptionPane.WARNING_MESSAGE);}
         result = JOptionPane.showConfirmDialog(null, triangle, "Triangle Calculator", JOptionPane.OK_CANCEL_OPTION);
         edge1 = Double.parseDouble(edge1_input.getText());
         edge2 = Double.parseDouble(edge2_input.getText());
         edge3 = Double.parseDouble(edge3_input.getText());
         if(result == JOptionPane.CANCEL_OPTION){
            result = WindowConstants.EXIT_ON_CLOSE;
            break;
        }
      }
      TriangleGUI t1 = new TriangleGUI(edge1, edge2, edge3);
      DecimalFormat df = new DecimalFormat("0.00");
      if(result == JOptionPane.OK_OPTION){
         JOptionPane.showMessageDialog(null, "Perimeter of the triangle is " + df.format(t1.Perimeter())
         + "\nArea of the triangle is " + df.format(t1.Area()), "Triangle Calculator", JOptionPane.INFORMATION_MESSAGE);
      }
   } 
}
