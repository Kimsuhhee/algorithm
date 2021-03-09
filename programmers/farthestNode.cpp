/*
문제:프로그래머스 > 코딩테스트연습 > 그래프 > 가장먼노드
출처:https://programmers.co.kr/learn/courses/30/lessons/49189
*/
#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;
vector<int>v[20001];
queue<int>q;
int cnt[20001];
bool visited[20001];

int solution(int n, vector<vector<int>> edge) {
    int answer = 0;
    for (int i = 0; i < edge.size(); i++) {
        v[edge[i][0]].push_back(edge[i][1]);
        v[edge[i][1]].push_back(edge[i][0]);
    }
    q.push(1);
    while (!q.empty()) {
        int x = q.front();
        visited[x] = true;
        q.pop();
        for (int i = 0; i < v[x].size(); i++) {
            int y = v[x][i];
            if (!visited[y] && cnt[y] == 0) {
                q.push(y);
                cnt[y] = cnt[x] + 1;
            }
        }
    }
    int m = -1;
    for (int num : cnt) m = max(m, num);
    for (int i : cnt) {
        if (i == m) answer++;
    }

    return answer;
}
int main() {
    vector<vector<int>> vertex = { {3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2} };
    cout << solution(6, vertex) << '\n';
}