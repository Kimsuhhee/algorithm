/*
문제:프로그래머스 > 코딩테스트연습 > 동적계획법 > 등굣길
출처:https://programmers.co.kr/learn/courses/30/lessons/42898
*/
#include <string>
#include <vector>
#include <iostream>
using namespace std;

int d[101][101];
int solution(int m, int n, vector<vector<int>> puddles) {
    for (int i = 0; i < puddles.size(); i++) {
        d[puddles[i][1]][puddles[i][0]] = -1;
    }
    d[0][1] = 1;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (d[i][j] == -1) {
                d[i][j] = 0;
                continue;
            }
            else d[i][j] = (d[i - 1][j] + d[i][j - 1]) % 1000000007;
        }
    }
    return d[n][m];
}

int main() {
    vector<vector<int>>puddles = { {2,2} };
    cout << solution(4,3,puddles) << '\n';
}