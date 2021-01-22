#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(vector<string> seoul) {
    string answer = "";
    int idx;
    for (int i = 0; i < seoul.size(); i++) {
        if (seoul[i] == "Kim") idx = i;
    }
    answer = "김서방은 " + to_string(idx) + "에 있다";
    return answer;
}

int main() {
    vector<string> seoul;
    seoul.push_back("Jane");
    seoul.push_back("Kim");
    cout << solution(seoul) << endl;
}