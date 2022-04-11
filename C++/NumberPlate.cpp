#include <iostream>
#include <math.h>
#include <Windows.h>
#include <ctime>
using namespace std;
int NumberPlate(int numplate){
    int platesum = 0;
    while(numplate > 0){
        platesum += numplate % 10;
        numplate /= 10;
    }
    if(platesum > 10){
        platesum = platesum % 10;
    }
    return platesum;
}


int main(){
    double flag,numplate;
    cout << "Chào mừng bạn đến với chương trình Đếm nút biển số xe. Vui lòng chọn chế độ đầu vào:\n " << "1. Thủ công\t" 
    << "2. Tự động (hệ thống lựa chọn ngẫu nhiên 1 biển số xe trong giới hạn từ 10000 đến 99999)\n";
    cin >> flag;
    while(flag != 1 && flag != 2){
        cout << "Lựa chọn của bạn không hợp lệ! Vui lòng chọn lại chế độ đầu vào:\n " << "1. Thủ công\t" << 
        "2. Tự động (hệ thống lựa chọn ngẫu nhiên 1 biển số xe trong giới hạn từ 10000 đến 99999)\n";
        cin >> flag;
    }
    if(flag == 1){
        cout << "Nhập biển số xe của bạn vào đây (giới hạn từ 10000 đến 99999): ";
        cin >> numplate;
        while(numplate < 10000 || numplate > 99999){
            cout << "Biển số xe của bạn không hợp lệ! Vui lòng nhập lại biển số xe của bạn vào đây (giới hạn từ 10000 đến 99999): ";
            cin >> numplate;
        }
        if(NumberPlate((int)numplate) % 10 == 0){
        cout << "Biển số xe của bạn có số nút BÙ";
        }
        else cout << "Biển số xe của bạn có " << NumberPlate((int)numplate) << " nút"; 
    }
    else {
        srand((unsigned) time(0));
        numplate = rand() % (99999 - 10000 + 1) + 10000;
        cout << "Biển số xe được chọn là: ";
        Sleep(500);
        cout << numplate << "\n";
        Sleep(300);
        if(NumberPlate((int)numplate) % 10 == 0){
        cout << "Biển số xe được chọn có số nút BÙ";
        }
        else cout << "Biển số xe được chọn có " << NumberPlate((int)numplate) << " nút";
    } 
    return 0;
}
