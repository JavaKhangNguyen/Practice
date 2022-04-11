#include <iostream>
#include <math.h>
#include <iomanip>
#include <ctime>
using namespace std;
int main(){
    double x,flag;
    cout << "Please select input mode:\n " << "1. Manual input" 
    << "\t2. Automatic input (The input will be randomly selected in the range from 0 to 10^9)\n";
    cin >> flag;
    while(flag != 1 && flag != 2){
        cout << "Invalid input! Please select input mode again:\n " << "1. Manual input" 
        << "\t2. Automatic input (The input will be randomly selected in the range from 0 to 10^9)\n";
        cin >> flag;
    }
    if(flag == 1){
        cout << "Input x: ";
        cin >> x;
    }
    else{
        srand((unsigned) time(0));
        x = fmod(rand(),(pow(10,9)));
        cout << "The selected x is " << x << "\n";
        
    }
    double y1 = 4*(pow(x,2) + 10*(x*sqrt(x)) + 3*x + 1);
    double y2 = (sin(3.14*pow(x,2)) + sqrt(pow(x,2) + 1))/(pow(2.71,2*x) + cos((3.14/4)*x));
    cout << setprecision(10) << fixed << "y1 is "  << y1 << "\ny2 is " << y2;
}
