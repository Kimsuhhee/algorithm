/*
문제:프로그래머스 > 코딩테스트연습 > heap > 이중우선순위큐
출처:https://programmers.co.kr/learn/courses/30/lessons/42628
*/
#include <string>
#include <vector>
#include <iostream>
#include <deque>
#include <algorithm>
using namespace std;

vector<int> answer(2);

vector<int> solution(vector<string> operations) {
    deque<int>dq;
    for (int i = 0; i < operations.size(); i++) {
        string s = operations[i];
        if (s[0] == 'I') {
            string tmp = s.substr(1);
            int num = stoi(tmp);
            dq.push_back(num);
            sort(dq.begin(), dq.end());
        }
        if (s[0] == 'D') {
            if (s[2] == '-') {
                if (!dq.empty())dq.pop_front();
            }
            else {
                if (!dq.empty())dq.pop_back();
            }
        }
    }
    if (!dq.empty()) {
        answer[0] = dq.back();
        answer[1] = dq.front();
    }

    return answer;
}

int main() {
    vector <string>operations = { "I 7","I 5","I -5","D -1" };
    vector <int>ans = solution(operations);
    for (int a : ans)cout << a << " ";
}