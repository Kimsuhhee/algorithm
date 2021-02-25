/*
문제:백준16948번
출처:https://www.acmicpc.net/problem/16948
*/
#include<iostream>
#include<queue>
#include<cstring>
using namespace std;

bool visited[200][200];
int chess[200][200];
int xs, ys, xe, ye, N;
int dx[6] = { -2,-2,0,0,+2,+2 };
int dy[6] = { -1,+1,-2,+2,-1,+1 };
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
		for (int i = 0; i < 6; i++) {
			int mx = cx + dx[i];
			int my = cy + dy[i];
			if (mx < 0 || mx > N || my < 0 || my > N)continue;
			if (!visited[mx][my]) {
				visited[mx][my] = true;
				chess[mx][my] = chess[cx][cy] + 1;
				q.push(make_pair(mx, my));
			}
		}
	}
}

int main() {
	cin >> N;
	cin >> xs >> ys >> xe >> ye;
	bfs(xs, ys);
	if (chess[xe][ye] != 0) cout << chess[xe][ye] << '\n';
	else cout << -1 << '\n';
}