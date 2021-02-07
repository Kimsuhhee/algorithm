/*
문제:백준7569번
출처:https://www.acmicpc.net/problem/7569
*/
#include<iostream>
#include<algorithm>
#include<queue>
#include<tuple>
using namespace std;

int tomato[101][101][101];
int N, M, H, m;
int dx[6] = { 0,0,-1,1,0,0 }; //상하좌우앞뒤
int dy[6] = { -1,1,0,0,0,0 }; //상하좌우앞뒤
int dz[6] = { 0,0,0,0,-1,1 }; //상하좌우앞뒤
queue<tuple<int, int, int>>q;

void bfs() {
	while (!q.empty()) {
		int cx, cy, cz;
		tie(cx, cy, cz) = q.front();
		q.pop();
		for (int i = 0; i < 6; i++) {
			int mx = cx + dx[i];
			int my = cy + dy[i];
			int mz = cz + dz[i];
			if (mx < 0 || mx >= M || my < 0 || my >= N || mz < 0 || mz >= H) continue;
			if (tomato[mx][my][mz]) continue;
			tomato[mx][my][mz] = tomato[cx][cy][cz] + 1;
			q.push(make_tuple(mx, my, mz));

		}
	}
}

int main() {
	cin >> M >> N >> H;
	for (int k = 0; k < H; k++) {
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < M; i++) {
				cin >> tomato[i][j][k];
				if (tomato[i][j][k] == 1)
					q.push(make_tuple(i, j, k));
			}
		}
	}
	bfs();

	for (int k = 0; k < H; k++) {
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < M; i++) {
				if (tomato[i][j][k] == 0) {
					cout << -1 << '\n';
					return 0;
				}
				m = max(m, tomato[i][j][k]);
			}
		}
	}

	cout << m - 1 << '\n';
	return 0;

}