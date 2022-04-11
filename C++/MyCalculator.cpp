#include <iostream>
#include <ctime>
#define _USE_MATH_DEFINES
#include <math.h>
#include <iomanip>
using namespace std;
int main()
{
    int n1, n2, n, angle, degree;
    int currentyear = 2021, yearofbirth;
    float radian;
    cout << "Select function to compute: " << "[1] Addition " << " [2] Subtraction " << " [3] Multiplication " << " [4] Division " << " [5] Angular calculator " << " [6] Age calculator\n";
    cin >> n;
    if(n!=1 && n!=2 && n!=3 && n!=4 && n!=5 && n!=6){cout << "Invalid input!";}
    else{
        switch (n)
        {
        case 1:
            cout << "Input integer 1: ";
            cin >> n1;
            cout << "Input integer 2: ";
            cin >> n2;
            cout << n1 << " + " << n2 << " = " << n1 + n2;
            break;
        case 2:
            cout << "Input integer 1: ";
            cin >> n1;
            cout << "Input integer 2: ";
            cin >> n2;
            cout << n1 << " - " << n2 << " = " << n1 - n2;
            break;
        case 3:
            cout << "Input integer 1: ";
            cin >> n1;
            cout << "Input integer 2: ";
            cin >> n2;
            cout << n1 << " * " << n2 << " = " << n1*n2;
            break;
        case 4:
            cout << "Input integer 1: ";
            cin >> n1;
            cout << "Input integer 2: ";
            cin >> n2;
            cout << setprecision(2) << fixed <<  n1 << " / " << n2 << " = " << (float)n1/n2;
            break;
        case 5:
            cout << "Select function to compute: " << "[1] Sin " << " [2] Cos " << " [3] Tan " << " [4] Cot\n";
            cin >> angle;
            if(angle!=1 && angle!=2 && angle!=3 && angle!=4){cout << "Invalid input";}
            else{ 
            cout << "Input desired angle (unit in degrees): ";
            cin >> degree;
            radian = (degree*M_PI)/180;
            switch (angle)
                {
                case 1:
                    cout << setprecision(2) << fixed <<  "Sin of angle is " << sin(radian);
                break;
                case 2:
                cout << setprecision(2) << fixed << "Cos of angle is " << cos(radian);
                    break;
                case 3:
                    cout << setprecision(2) << fixed << "Tan of angle is " << tan(radian);
                 break;
                case 4:
                    cout << setprecision(2) << fixed << "Tan of angle is " << 1/(tan(radian));
                break;
                default:
                    break;
        }}
                break;
        case 6:
        cout << "Input year of birth: ";
        cin >> yearofbirth;
        cout << "Current age is " << currentyear - yearofbirth;
            break;
        default:
            break;
        }
    }
    return 0;
}
