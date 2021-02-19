/*
문제:백준10026번
출처:https://www.acmicpc.net/problem/10026
*/
#include<iostream>
#include<vector>
#include<queue>
#include<cstring>
#include<algorithm>
using namespace std;
vector<int>v;
bool visited[101][101];
char d[101][101];
int cnt;
int N;
int dx[4] = { 0,0,-1,1 }; //상하좌우
int dy[4] = { 1,-1,0,0 }; //상하좌우

void dfs(int x, int y) {
	visited[x][y] = true;
	for (int i = 0; i < 4; i++) {
		int mx = x + dx[i];
		int my = y + dy[i];
		if (0 <= mx && 0 <= my && mx < N && my < N) {
			if (d[mx][my] == d[x][y] && !visited[mx][my]) dfs(mx, my);
		}
	}
}

int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> d[i][j];
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (!visited[i][j]) {
				cnt++;
				dfs(i, j);
			}
		}
	}
	cout << cnt << " ";
	cnt = 0;
	memset(visited, false, sizeof(visited));

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {

			if (d[i][j] == 'G')d[i][j] = 'R';
		}
	}


	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (!visited[i][j]) {
				cnt++;
				dfs(i, j);
			}
		}
	}
	cout << cnt;

}