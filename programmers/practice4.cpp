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
    answer = "�輭���� " + to_string(idx) + "�� �ִ�";
    return answer;
}

int main() {
    vector<string> seoul;
    seoul.push_back("Jane");
    seoul.push_back("Kim");
    cout << solution(seoul) << endl;
}