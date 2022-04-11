#include <iostream>
#include <chrono>
#include <iomanip>
using namespace std;
using namespace std::chrono;
int main(){
    double a,b,c;
    cout << "Enter a: ";
    cin >> a;
    cout << "Enter b: ";
    cin >> b;
    cout << "Enter c: ";
    cin >> c;
    auto start = high_resolution_clock::now();
    cout << setprecision (0) << fixed << "a - b - c before swapping: " << a << " " << b << " " << c << "\n";
    a = a + b; 
    b = a - b; 
    a = a - b; 
    b = b + c; 
    c = b - c; 
    b = b - c;
    cout << setprecision (0) << fixed << "a - b - c after swapping: " << a << " " << b << " " << c << "\n"; 
    auto stop = high_resolution_clock::now();
    auto duration = (duration_cast<microseconds>(stop - start));
    cout << "Time taken by function: "
         << duration.count() << " microseconds" << endl;
    return 0;
}