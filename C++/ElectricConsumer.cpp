#include <iostream>
#include <math.h>
using namespace std;
int main(){
    int prev, current;
    cout << "Input the amount of electricity used this month (unit kWh): ";
    cin >> current;
    cout << "Input the amount of electricity used last month (unit kWh): ";
    cin >> prev;
    if(prev < 0 && prev > current && current > pow(10,9)){
        cout << "Invalid input!";
    }
    else cout << "The amount of electricity used is : " << current - prev << " kWh";
}