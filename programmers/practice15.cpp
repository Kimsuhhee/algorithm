/*
문제:프로그래머스 > 코딩테스트연습 > 연습문제 > 정수제곱근판별
출처:https://programmers.co.kr/learn/courses/30/lessons/12934
*/
#include <string>
#include <vector>
#include <cmath>
#include <iostream>
using namespace std;

int n = 121;

long long solution(long long n) {
    long long answer;
    long long temp;
    temp = sqrt(n);
    if (n == pow(temp, 2)) {
        answer = pow(temp + 1, 2);
    }
    else answer = -1;
    return answer;
}

int main() {
    cout << solution(n);
}