/*
문제:백준7576번
출처:https://www.acmicpc.net/problem/7576
*/
#include<iostream>
#include<algorithm>
#include<queue>
using namespace std;

bool visited[1000][1000];
int tomato[1000][1000];
int N, M;
int dx[4] = { 0,0,-1,1 }; //상하좌우
int dy[4] = { 1,-1,0,0 }; //상하좌우
queue<pair<int, int>>q;

void bfs() {
	while (!q.empty()) {
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int mx = cx + dx[i];
			int my = cy + dy[i];
			if (mx >= 0 && mx < N && my >= 0 && my < M) {
				if (tomato[mx][my] == 0 && !visited[mx][my]) {
					visited[mx][my] = true;
					tomato[mx][my] = tomato[cx][cy] + 1;
					q.push(make_pair(mx, my));
				}
			}
		}
	}
}

int main() {
	int m = -1;
	cin >> M >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> tomato[i][j];
			if (tomato[i][j] == 1)
				q.push(make_pair(i, j));
		}
	}

	bfs();

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (tomato[i][j] == 0) {
				cout << -1 << '\n';
				return 0;
			}
			m = max(m, tomato[i][j]);
		}
	}
	cout << m - 1 << '\n';
	return 0;

}