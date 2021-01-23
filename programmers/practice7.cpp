#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(string phone_number) {
    string answer = "";
    answer = phone_number;
    int len = phone_number.length();
    for (int i = 0; i < len - 4; i++) {
        answer[i] = '*';
    }
    return answer;
}

int main() {
   // string phone_number = "01033334444";
    string phone_number = "027778888";
    cout << solution(phone_number);
}