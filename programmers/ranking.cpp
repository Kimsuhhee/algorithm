/*
문제:프로그래머스 > 코딩테스트연습 > 그래프 > 순위
출처:https://programmers.co.kr/learn/courses/30/lessons/49191
*/
#include <string>
#include <vector>
#include <iostream>
using namespace std;
int d[101][101];

int solution(int n, vector<vector<int>> results) {
    int answer = 0;
    for (int i = 0; i < results.size(); i++) {
        d[results[i][1]][results[i][0]] = 1;
        d[results[i][0]][results[i][1]] = -1;
    }

    for (int k = 1; k <= n; k++) { 
        for (int i = 1; i <= n; i++) { 
            if (d[i][k] == 1) { //i번째 선수가 k번째 선수를 이겼고
                for (int j = 1; j <= n; j++) { 
                    if (d[k][j] == 1) { //k번째 선수가 j번째 선수를 이겼으면
                        d[i][j] = 1; //i번째 선수가 j번째 선수를 이긴것과 같다.
                        d[j][i] = -1;
                    }
                }
            }
        }
    }

    for (int i = 1; i <= n; i++) {
        int cnt = 0;
        for (int j = 1; j <= n; j++) {
            if (i != j && d[i][j] != 0) cnt++;
        }
        if (cnt == n - 1)answer++;
    }

    return answer;
}

int main() {
    vector<vector<int>> results = { {4,3},{4,2},{3,2},{1,2},{2,5} };
    cout << solution(5, results) << '\n';
}