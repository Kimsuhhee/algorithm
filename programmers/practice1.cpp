#include <string>
#include<iostream>

using namespace std;

string solution(int num) {
    string answer = "";
    if (num % 2 == 0) answer = "Even";
    else answer = "Odd";
    return answer;
}

int main() {
    int num;
    cout << "number:";
    cin >> num;
    cout << solution(num) << endl;
}