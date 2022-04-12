package Java;
import javax.swing.*;
public class DayTime {
    private int day, year, month;
    public DayTime(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public void setDay(int day){
        this.day = day;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public void setYear(int year){
        this.year = year;
    }
    public int getDay(){
        return day;	
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public boolean isLeapYear(){
        if(year % 400 == 0){
            return true;
        }
        if(year % 100 == 0){
            return false;
        }
        if(year % 4 == 0){
            return true;
        }
        return false;
    }
    public static boolean LeapYear(int year){
        if(year % 400 == 0){
            return true;
        }
        if(year % 100 == 0){
            return false;
        }
        if(year % 4 == 0){
            return true;
        }
        return false;

    }
    //note case beginning of month
    public DayTime Yesterday(DayTime date){
        if(date.getDay() == 1){
            if(date.getMonth() == 2||date.getMonth() == 4 || date.getMonth() == 6 || date.getMonth() == 8 ||  
            date.getMonth() == 9 || date.getMonth() == 11){
                date.setDay(31);
                date.setMonth(date.getMonth() - 1);
                return date;
            }
            if(date.isLeapYear() == true){
                if(date.getMonth() == 3){
                    date.setDay(29);
                    date.setMonth(date.getMonth() - 1);
                    return date;
                }
            }
            if(date.isLeapYear() == false){
                if(date.getMonth() == 3){
                    date.setDay(28);
                    date.setMonth(date.getMonth() - 1);
                    return date;
                }
            }
            setDay(30);
            date.setMonth(date.getMonth() - 1);
            return date;
            
        }
        if(date.getDay() == 1 && date.getMonth() == 1){
            date.setDay(31);
            date.setMonth(12);
            date.setYear(date.getYear() - 1);
            return date;
        }
        setDay(date.getDay()  - 1);
        return date;
    }
    public DayTime Tomorrow(DayTime date){
        //note case
        if(date.getMonth() == 2){
            if(date.isLeapYear() == true){
                if(date.getDay() == 28){
                    date.setDay(29);
                }
                if(date.getDay() == 29) {
                    date.setDay(1);
                    date.setMonth(3);
                    return date;
                }
            }
            if(date.isLeapYear() == false) {
                if(date.getDay() == 28){
                    date.setDay(1);
                    date.setMonth(3);
                    return date;
                }
            }
            date.setDay(date.getDay() + 1);
            return date;
            
        }

        if(date.getMonth() != 2){
            if(date.getMonth() == 4 || date.getMonth() == 6 || date.getMonth() == 9 || date.getMonth() == 11){
                if(date.getDay() == 30){
                    date.setDay(1);
                    date.setMonth(date.getMonth() + 1);
                    return date;
                }
                date.setDay(date.getDay() + 1);
                return date;
            }
            else {
                if(date.getDay() == 31){
                    if(date.getMonth() == 12){
                        date.setDay(1);
                        date.setMonth(1);
                        date.setYear(date.getYear() + 1);
                        return date;
                    }
                    else {
                        date.setDay(1);
                        date.setMonth(date.getMonth() + 1);
                        return date;
                    }
                }
                date.setDay(date.getDay() + 1);
            }
        }
        return date;
    }
    
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
    public static void main(String[] args) {
        JTextField day = new JTextField();    
        JTextField month = new JTextField();
        JTextField year = new JTextField();
        Box test = Box.createVerticalBox();
        test.add(new JLabel("Enter day: "));
        test.add(day);
        test.add(new JLabel("Enter month: "));
        test.add(month);
        test.add(new JLabel("Enter year: "));
        test.add(year);
        int result = JOptionPane.showConfirmDialog(null, test, "Java DayTime", JOptionPane.OK_CANCEL_OPTION);
        //check input
        while(Integer.parseInt(day.getText()) < 0 || Integer.parseInt(month.getText()) < 0 || Integer.parseInt(month.getText()) > 12 || 
        Integer.parseInt(year.getText()) > Math.pow(10, 9)){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java DayTime", 
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, test, "Java DayTime", JOptionPane.OK_CANCEL_OPTION);
        }
        while(Integer.parseInt(month.getText()) == 2 && Integer.parseInt(day.getText()) > 28){
            JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java DayTime", 
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, test, "Java DayTime", JOptionPane.OK_CANCEL_OPTION);
            if(LeapYear(Integer.parseInt(year.getText())) == true){
                break;
            }
        }
        while(LeapYear(Integer.parseInt(year.getText())) == true){
            if(Integer.parseInt(month.getText()) == 2 && Integer.parseInt(day.getText()) > 29){
                JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java DayTime", 
                JOptionPane.WARNING_MESSAGE);
                result = JOptionPane.showConfirmDialog(null, test, "Java DayTime", JOptionPane.OK_CANCEL_OPTION);
            }
            else break;
        }
        while(Integer.parseInt(month.getText()) == 4 || Integer.parseInt(month.getText()) == 6 || 
        Integer.parseInt(month.getText()) == 9 || Integer.parseInt(month.getText()) == 11){
            while(Integer.parseInt(day.getText()) > 30){
                JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java DayTime", 
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, test, "Java DayTime", JOptionPane.OK_CANCEL_OPTION);
            }
            break;
        }
        while(Integer.parseInt(month.getText()) != 2 && Integer.parseInt(month.getText()) != 4 &&
        Integer.parseInt(month.getText()) != 6 && Integer.parseInt(month.getText()) != 9 &&
        Integer.parseInt(month.getText()) != 11){
            while(Integer.parseInt(day.getText()) > 31){
                JOptionPane.showMessageDialog(null, "Invalid input! Please input again!", "Java DayTime", 
            JOptionPane.WARNING_MESSAGE);
            result = JOptionPane.showConfirmDialog(null, test, "Java DayTime", JOptionPane.OK_CANCEL_OPTION);
            }
            break;
        }
        //Date processing
        DayTime yesterday_test = new DayTime(Integer.parseInt(day.getText()), Integer.parseInt(month.getText()), 
        Integer.parseInt(year.getText()));
        //avoid pass-by reference
        DayTime tomorrow_test =  new DayTime(Integer.parseInt(day.getText()), Integer.parseInt(month.getText()), 
        Integer.parseInt(year.getText()));
        if(result == JOptionPane.OK_OPTION){
            JOptionPane.showMessageDialog(null, "Day input is "+ yesterday_test.toString(), 
        "Java DayTime", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Yesterday is " + yesterday_test.Yesterday(yesterday_test).toString() + 
        "\nTomorrow is " + tomorrow_test.Tomorrow(tomorrow_test).toString(), "Java DayTime", JOptionPane.INFORMATION_MESSAGE);
        }
        else result = WindowConstants.EXIT_ON_CLOSE;
    }
}
