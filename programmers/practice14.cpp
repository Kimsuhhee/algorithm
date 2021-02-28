/*
문제:프로그래머스 > 코딩테스트연습 > 연습문제 > 올바른괄호
출처:https://programmers.co.kr/learn/courses/30/lessons/12909
*/
#include <string>
#include <iostream>
#include <stack>
using namespace std;

stack<char>ss;

bool solution(string s)
{
    bool answer = true;
    int cnt = 0;

    for (int i = 0; i < s.length(); i++) {
        if (s[i] == '(') {
            ss.push(s[i]);
        }
        else {
            if (i == 0) {
                answer = false;
                break;
            }
            else {
                if (!ss.empty() && ss.top() == '(')ss.pop();
                else ss.push(s[i]);
            }
        }
    }
    if (!ss.empty()) return false;
    else return answer;
}