#include <iostream>
#include <iomanip>
using namespace std;
int main(){
    double a, b;
    cout << "Enter a: ";
    cin >> a;
    cout << "Enter b: ";
    cin >> b;
    cout << setprecision (0) << fixed << "a & b before swapping: " << a << " " << b << "\n";
    a = a + b;
    b = a - b;
    a = a - b;
    cout << setprecision (0) << fixed << "a & b after swapping: " << a << " " << b << "\n";
}