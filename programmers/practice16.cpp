/*
문제:프로그래머스 > 코딩테스트연습 > 연습문제 > 2 x n 타일링
출처:https://programmers.co.kr/learn/courses/30/lessons/12900
*/
#include <string>
#include <vector>
#include <iostream>
using namespace std;
int dp[60001];
int solution(int n) {
    int answer = 0;
    dp[0] = 0; dp[1] = 1; dp[2] = 2;
    for (int i = 3; i <= n; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
    }
    return dp[n];
}
int main() {
    cout << solution(4) << '\n';
}