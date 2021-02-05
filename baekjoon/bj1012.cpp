/*
문제:백준1012번
출처:https://www.acmicpc.net/problem/1012
*/
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

bool visited[50][50];
int map[50][50];
int M, N, K, x, y;
int dx[4] = { 0,0,-1,1 }; //상하좌우
int dy[4] = { 1,-1,0,0 }; //상하좌우

void dfs(int x, int y) {
	visited[x][y] = true;
	for (int i = 0; i < 4; i++) {
		int mx = x + dx[i];
		int my = y + dy[i];
		if (0 <= mx && 0 <= my && mx < 50 && my < 50) {
			if (map[mx][my] == 1 && !visited[mx][my]) dfs(mx, my);
		}
	}
}

int main() {
	int T;
	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> M >> N >> K;
		for (int j = 0; j < K; j++) {
			cin >> x >> y;
			map[x][y] = 1;
		}
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					dfs(i, j);
				}
			}
		}
		cout << cnt << '\n';

		memset(map, 0, sizeof(map));
		memset(visited, 0, sizeof(visited));

	}

}