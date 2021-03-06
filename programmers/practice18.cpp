/*
문제:프로그래머스 > 코딩테스트연습 > 연습문제 > 이상한문자만들기
출처:https://programmers.co.kr/learn/courses/30/lessons/12930
*/
#include <string>
#include <vector>
#include <iostream>
#include <cctype>
using namespace std;

string solution(string s) {
    string answer = "";
    int cnt = 1;
    for (int i = 0; i < s.length(); i++) {
        if (s[i] == ' ') {
            cnt = 1;
            answer += ' ';
            continue;
        }
        if (cnt % 2 != 0) {
            int n = s[i];
            answer += toupper(n);
            cnt++;
        }
        else {
            int n = s[i];
            answer += tolower(n);
            cnt++;
        }
    }
    return answer;
}

int main() {
    string s = "try hello world";
    cout << solution(s) << '\n';
}