/*
문제:백준4963번
출처:https://www.acmicpc.net/problem/4963
*/
#include<iostream>
#include<cstring>
using namespace std;

bool visited[50][50];
int land[50][50];
int w, h, cnt;
int dx[8] = { 0,0,-1,+1,-1,+1,-1,+1 };
int dy[8] = { +1,-1,0,0,+1,+1,-1,-1 };

void dfs(int x, int y) {
	visited[x][y] = true;

	for (int i = 0; i < 8; i++) {
		int mx = x + dx[i];
		int my = y + dy[i];
		if (mx < 0 || my < 0 || mx >= h || my >= w) continue;
		if (land[mx][my] && !visited[mx][my]) {
			dfs(mx, my);
		}
	}
}

int main() {

	while (cin >> w >> h) {

		if (w == 0 && h == 0) return 0;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				cin >> land[i][j];
			}
		}
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (land[i][j] && !visited[i][j]) {
					cnt++;
					dfs(i, j);
				}
			}
		}
		cout << cnt << '\n';
		memset(land, 0, sizeof(land));
		memset(visited, false, sizeof(visited));
		cnt = 0;
	}
}