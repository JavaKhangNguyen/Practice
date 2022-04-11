import javax.swing.*;
import java.util.Random;
public class NumberPlate {
    public static int NumPlateCounter(int numplate){
        int platesum = 0;
        while(numplate > 0){
            platesum += numplate % 10;
            numplate /= 10;
        }
        if(platesum > 10){
            platesum = platesum % 10;
        }
        return platesum;
    }
    public static void main(String[] args) {
        String flag = JOptionPane.showInputDialog(null, 
        "Chào mừng bạn đến với chương trình Đếm Nút Biển Số Xe. Vui lòng chọn chế độ đầu vào:\n " 
        + "1. Thủ công\n" 
        + "2. Tự động (hệ thống lựa chọn ngẫu nhiên 1 biển số xe trong giới hạn từ 10000 đến 99999)\n", 
        "Đếm Nút Biển Số Xe", JOptionPane.INFORMATION_MESSAGE);
        while(Double.parseDouble(flag)!= 1 && Double.parseDouble(flag)!= 2){
            flag = JOptionPane.showInputDialog(null, 
            "Lựa chọn của bạn không hợp lệ! Vui lòng chọn lại chế độ đầu vào:\n "
            + "1. Thủ công\n" 
            + "2. Tự động (hệ thống lựa chọn ngẫu nhiên 1 biển số xe trong giới hạn từ 10000 đến 99999)\n", 
            "Đếm Nút Biển Số Xe", JOptionPane.WARNING_MESSAGE);
        }
        if(Double.parseDouble(flag) == 1){
            String NumPlate = JOptionPane.showInputDialog(null, "Nhập biển số xe của bạn vào đây: ", "Đếm Nút Biển Số Xe", 
        JOptionPane.INFORMATION_MESSAGE);
        NumPlate = NumPlate.replaceAll("[^-0-9.]", "");
        while(Integer.parseInt(NumPlate) <= 10000 || Integer.parseInt(NumPlate) >= 99999){
            NumPlate = JOptionPane.showInputDialog(null, 
            "Biển số xe nhận được không hợp lệ! Vui lòng nhập biển số xe mới vào đây: ","Đếm Nút Biển Số Xe", 
            JOptionPane.WARNING_MESSAGE);
        }
        if(NumPlateCounter(Integer.parseInt(NumPlate)) %10 == 0)
        JOptionPane.showMessageDialog(null, "Biển số xe của bạn có số nút BÙ", "Đếm Nút Biển Số Xe", JOptionPane.INFORMATION_MESSAGE);
        else 
        JOptionPane.showMessageDialog(null, "Biển số xe của bạn có " + NumPlateCounter(Integer.parseInt(NumPlate)) + " nút", "Đếm Nút Biển Số Xe", JOptionPane.INFORMATION_MESSAGE);    
    }
        else{
            Random rand = new Random();
            int NumPlate = rand.nextInt(10000,99999);
            JOptionPane.showMessageDialog(null, "Biển số xe được chọn là " + NumPlate, "Đếm Nút Biển Số Xe (Tự Động)", 
            JOptionPane.INFORMATION_MESSAGE);
            if(NumPlateCounter(NumPlate) %10 == 0)
            JOptionPane.showMessageDialog(null, "Biển số xe của bạn có số nút BÙ", 
            "Đếm Nút Biển Số Xe", JOptionPane.INFORMATION_MESSAGE);
            else 
            JOptionPane.showMessageDialog(null, "Biển số xe của bạn có " + NumPlateCounter(NumPlate) + " nút", 
            "Đếm Nút Biển Số Xe", JOptionPane.INFORMATION_MESSAGE);  
        }  
    }  
}
