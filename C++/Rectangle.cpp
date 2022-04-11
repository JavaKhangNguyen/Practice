#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;
int main(){
    double flag, perimeter, width, depth, height;
    cout << "Welcome to C++ Rectangle Calculator. Please select the attribute that needs to be calculated: " 
    <<  "1. Area (with perimeter input)\t2. Volume\n";
    cin >> flag;
    while(flag!=1 && flag != 2){
        cout << "Invalid input! Please select again!\nSelect the attribute that needs to be calculated: " 
        <<  "1. Area (with perimeter input)\t2. Volume\n";
        cin >> flag;
    }
    if(flag == 1){
        cout << "Enter perimeter: ";
        cin >> perimeter;
        while(perimeter <= 0 || perimeter > pow(10,9)){
            cout << "Invalid input! Please enter a new perimeter: ";
            cin >> perimeter;
        }
        cout << setprecision(2) << fixed << "The area of the rectangle is " << 1.5*pow((perimeter/(2*(1.5 + 1))),2);
    }
    else {
        cout << "Enter width: ";
        cin >> width;
        cout << "Enter depth: ";
        cin >> depth;
        cout << "Enter height: ";
        cin >> height;
        while(width <= 0 || depth <= 0 || height <= 0 || width > pow(10,9) || depth > pow(10,9) || height > pow(10,9)){
            cout << "Invalid input! Please input again!";
            cout << "\nEnter width: ";
            cin >> width;
            cout << "Enter depth: ";
            cin >> depth;
            cout << "Enter height: ";
            cin >> height;
        }
        cout << setprecision(2) << fixed << "The volume of the box is " << width*depth*height; 
    }
}