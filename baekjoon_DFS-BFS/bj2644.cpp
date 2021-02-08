/*
문제:백준2644번
출처:https://www.acmicpc.net/problem/2644
*/
#include<iostream>
#include<vector>
#include<queue>
using namespace std;
int ggd[101][101];
int d[101];
bool visited[101];
queue<int>q;
int n, m;
int wp, wc, x, y;

void bfs(int start) {
	visited[start] = true;
	q.push(start);
	while (!q.empty()) {
		int x = q.front();
		q.pop();
		for (int i = 1; i <= n; i++) {
			if (ggd[x][i] == 1 && !visited[i]) {
				q.push(i);
				visited[i] = true;
				d[i] = d[x] + 1;
			}
		}
	}
}
int main() {
	cin >> n;
	cin >> wp >> wc;
	cin >> m;
	for (int i = 1; i <= m; i++) {
		cin >> x >> y;
		ggd[x][y] = 1;
		ggd[y][x] = 1;
	}

	bfs(wp);
	if (d[wc] != 0) cout << d[wc] << '\n';
	else cout << -1 << '\n';

}