/*
문제:백준2178번
출처:https://www.acmicpc.net/problem/2178
*/
#include<iostream>
#include<vector>
#include<queue>
using namespace std;

bool visited[100][100];
int maze[100][100];
int s[100][100];
int N, M;
int dx[4] = { 0,0,-1,1 }; //상하좌우
int dy[4] = { 1,-1,0,0 }; //상하좌우
void bfs(int x, int y) {
	queue<pair<int, int>>q;
	q.push(make_pair(x, y));
	visited[x][y] = true;
	s[x][y] = 1;

	while (!q.empty()) {
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int mx = cx + dx[i];
			int my = cy + dy[i];
			if (mx >= 0 && mx < 100 && my >= 0 && my < 100) {
				if (maze[mx][my] == 1 && !visited[mx][my]) {
					visited[mx][my] = true;
					s[mx][my] = s[cx][cy] + 1;
					q.push(make_pair(mx, my));
				}
			}
		}
	}
}

int main() {
	cin >> N >> M;
	string d;
	for (int i = 0; i < N; i++) {
		cin >> d;
		for (int j = 0; j < M; j++) {
			maze[i][j] = d[j] - '0';
		}
	}

	bfs(0, 0);

	cout << s[N - 1][M - 1] << '\n';

}