/*
문제:백준2667번
출처:https://www.acmicpc.net/problem/2667
*/
#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;
vector<int>v;
bool visited[25][25];
int dan[25][25];
int cnt;
int N;
int dx[4] = { 0,0,-1,1 }; //상하좌우
int dy[4] = { 1,-1,0,0 }; //상하좌우

void dfs(int x, int y) {
	cnt++;
	visited[x][y] = true;
	for (int i = 0; i < 4; i++) {
		int mx = x + dx[i];
		int my = y + dy[i];
		if (0 <= mx && 0 <= my && mx < N && my < N) {
			if (dan[mx][my] == 1 && !visited[mx][my]) dfs(mx, my);
		}
	}
}

int main() {
	cin >> N;
	string d;
	for (int i = 0; i < N; i++) {
		cin >> d;
		for (int j = 0; j < N; j++) {
			dan[i][j] = d[j] - '0';
		}
	}


	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (dan[i][j] == 1 && !visited[i][j]) {
				cnt = 0;
				dfs(i, j);
				v.push_back(cnt);
			}
		}
	}
	sort(v.begin(), v.end());
	cout << v.size() << '\n';
	for (int i = 0; i < v.size(); i++)cout << v[i] << '\n';

}