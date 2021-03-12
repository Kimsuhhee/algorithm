/*
문제:백준2206번
출처:https://www.acmicpc.net/problem/2206
*/
#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int visited[1001][1001][2]; //벽을 부셨는지를 기록하는 부분을 추가(벽은 한번 부술수 있음)
int wall[1001][1001];
int N, M;
int dx[4] = { 0,0,-1,1 }; //상하좌우
int dy[4] = { 1,-1,0,0 }; //상하좌우

int bfs(int x, int y, int c) {
	queue<pair<pair<int, int>, int>>q;
	q.push(make_pair(make_pair(x, y), c)); 
	visited[x][y][c] = 1;// visited[0][0][0]=1;

	while (!q.empty()) {
		int x = q.front().first.first;
		int y = q.front().first.second;
		int ch = q.front().second;
		q.pop();
		if (x == N - 1 && y == M - 1) {	//(N,M)의 위치까지 구했다면 값을 리턴
			return visited[x][y][ch];
		}
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if (mx >= 0 && mx < N && my >= 0 && my < M) {
				if (wall[mx][my] == 1 && ch == 0) { //벽인데 벽을 부순적이없다면
					visited[mx][my][ch + 1] = visited[x][y][ch] + 1;
					q.push({ { mx, my }, ch + 1 });
				}
				else if (wall[mx][my] == 0 && visited[mx][my][ch] == 0) { //벽이아닌데 방문한적이없다면
					visited[mx][my][ch] = visited[x][y][ch] + 1;
					q.push({ {mx, my}, ch });
				}
			}
		}
	}
	return -1;
}

int main() {
	cin >> N >> M;
	string s;
	for (int i = 0; i < N; i++) {
		cin >> s;
		for (int j = 0; j < M; j++) {
			wall[i][j] = s[j] - '0';
		}
	}

	cout << bfs(0, 0, 0) << '\n';


}