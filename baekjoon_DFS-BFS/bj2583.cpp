/*
문제:백준2583번
출처:https://www.acmicpc.net/problem/2583
*/
#include<iostream>
#include<vector>
#include<cstring>
#include<algorithm>
using namespace std;

vector<int>v;
bool visited[101][101];
int area[101][101];
int cnt;
int M, N, K;
int sx, sy, ex, ey;
int dx[4] = { 0,0,-1,1 }; //상하좌우
int dy[4] = { 1,-1,0,0 }; //상하좌우

void dfs(int x, int y) {
	visited[x][y] = true;
	cnt++;
	for (int i = 0; i < 4; i++) {
		int mx = x + dx[i];
		int my = y + dy[i];
		if (0 <= mx && 0 <= my && mx < M && my < N) {
			if (area[mx][my] == 0 && !visited[mx][my])
				dfs(mx, my);
		}
	}
}

int main() {
	cin >> M >> N >> K;
	for (int i = 0; i < K; i++) {

		cin >> sx >> sy >> ex >> ey;

		for (int i = sy; i < ey; i++) {
			for (int j = sx; j < ex; j++) {
				area[i][j] = 1;
			}
		}

	}
	
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (area[i][j] == 0 && !visited[i][j]) {
				cnt = 0;
				dfs(i, j);
				v.push_back(cnt);
			}
		}
	}
	sort(v.begin(), v.end());
	cout << v.size() << '\n';
	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << " ";
	}
}