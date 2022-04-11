#include <iostream>
#define _USE_MATH_DEFINES
#include <math.h>
#include <iomanip>
using namespace std;
int main(){
    double radius;
    cout << "Enter radius of the circle: ";
    cin >> radius;
    while(radius < 0 || radius > pow(10,9)){
        cout << "Invalid input! Please enter a new radius: ";
        cin >> radius; 
    }
    cout << setprecision(2) << fixed << "Perimeter of the circle is " <<  2*radius*M_PI;
    cout << setprecision(2) << fixed << "\nArea of the circle is " << pow(radius,2)*M_PI;
    return 0;
}