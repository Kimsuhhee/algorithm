#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

string solution(string s) {
    string answer = s;
    sort(answer.rbegin(), answer.rend());
    return answer;
}
int main() {
    string s = "Zbcdefg";
    cout << solution(s) << endl;
}