#include <iostream>
#include <ctime>
#include <Windows.h>
#include <cmath>
#include <vector>
using namespace std;
void MoneyChange(int money){
    vector <int> MoneyArray = {500000,200000,100000,50000,20000,10000,5000,2000,1000};
    cout << "Here's how this amount of money can be exchanged into: \n";
    for(int i = 0; i < MoneyArray.size(); i++){
        int temp = money / MoneyArray[i];
        cout << MoneyArray[i] << ": " << temp;
        if(i != MoneyArray.size() - 1){
            cout << endl;
        }
        money = money - temp*MoneyArray[i];
    }
}
int main(){
    double flag, money;
    cout << "Welcome to C++ Money Exchange Calculator. Please choose input mode:" << "\n" << "1. Manual" 
    << "\t\t2. Automatic (The input will be randomly selected in the range from 1 to 10^9)\n";
    cin >> flag;
    while(flag != 1 && flag != 2){
        cout << "Invalid input! Please choose input mode again: " << "\n" << "1. Manual input" 
    << "\t\t2. Automatic (The input will be randomly selected in the range from 1 to 10^9)\n";
        cin >> flag;
    }
    if(flag == 1){
        cout << "Input the amount of money: ";
        cin >> money;
        MoneyChange((int) money);
    }
    else{
        srand((unsigned) time(0));
        double money = fmod(rand(),(pow(10,9) - 1 + 1)) + 1;
        cout << "The input amount of money is " << money << " VND\n";
        Sleep(500);
        MoneyChange((int) money);
    }
}