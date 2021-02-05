/*
문제:백준7562번
출처:https://www.acmicpc.net/problem/7562
*/
#include<iostream>
#include<queue>
#include<cstring>
using namespace std;

bool visited[300][300];
int chess[300][300];
int xs, ys, xe, ye, l;
int dx[8] = { -2,-1,+1,+2,+2,+1,-1,-2 };
int dy[8] = { -1,-2,-2,-1,+1,+2,+2,+1 };
queue<pair<int, int>>q;

void bfs(int x, int y) {
	q.push(make_pair(x, y));
	visited[x][y] = true;

	while (!q.empty()) {
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();
		if (cx == xe && cy == ye) {
			return;
		}
		for (int i = 0; i < 8; i++) {
			int mx = cx + dx[i];
			int my = cy + dy[i];
			if (mx >= 0 && mx < l && my >= 0 && my < l) {
				if (!visited[mx][my]) {
					visited[mx][my] = true;
					chess[mx][my] = chess[cx][cy] + 1;
					q.push(make_pair(mx, my));
				}
			}
		}
	}
}

int main() {
	int T;
	cin >> T; 
	for (int i = 0; i < T; i++) {
		cin >> l;
		cin >> xs >> ys >> xe >> ye;
		bfs(xs, ys);
		cout << chess[xe][ye] << '\n';
		while (!q.empty()) {
			q.pop();
		}
		memset(chess, 0, sizeof(chess));
		memset(visited, 0, sizeof(visited));
	}
	
}