/*
문제:프로그래머스 > 코딩테스트연습 > 연습문제 > 이상한문자만들기
출처:https://programmers.co.kr/learn/courses/30/lessons/12930
*/
#include <string>
#include <vector>
#include <iostream>
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
            if (s[i] >= 'a' && s[i] <= 'z') {
                int t = s[i] - 32;
                char c = t;
                answer += c;
            }
            else {
                answer += s[i];
            }
            cnt++;
        }
        else {
            if (s[i] >= 'A' && s[i] <= 'Z') {
                int t = s[i] + 32;
                char c = t;
                answer += c;
            }
            else {
                answer += s[i];
            }
            cnt++;
        }
    }
    return answer;
}

int main() {
    string s = "try hello world";
    cout << solution(s) << '\n';
}