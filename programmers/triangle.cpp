/*
문제:프로그래머스 > 코딩테스트연습 > 동적계획법 > 정수삼각형
출처:https://programmers.co.kr/learn/courses/30/lessons/43105
*/
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int d[500][500];
int solution(vector<vector<int>> triangle) {
    int answer = -1;
    d[0][0] = triangle[0][0];
    for (int i = 1; i < triangle.size(); i++) {
        for (int j = 0; j <= i; j++) {
            if (j == 0) d[i][0] = triangle[i][0] + d[i - 1][0];
            else if (j == i) d[i][j] = triangle[i][j] + d[i - 1][j - 1];
            else d[i][j] = max(d[i - 1][j - 1], d[i - 1][j]) + triangle[i][j];

            if (i == triangle.size() - 1)answer = max(answer, d[i][j]);
        }
    }
    return answer;
}

int main() {
    vector<vector<int>>triangle = { {7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5} };
    cout << solution(triangle) << '\n';
}