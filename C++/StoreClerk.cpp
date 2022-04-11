#include <iostream>
#include <math.h>
using namespace std;
int main(){
    int productquantity;
    double productprice;
    cout << "Input product quantity: ";
    cin >> productquantity;
    cout << "Input product price: ";
    cin >> productprice;
    cout << "Total payment is " << 1.1*(productprice*productquantity);
}