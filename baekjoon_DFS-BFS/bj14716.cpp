/*
문제:백준14716번
출처:https://www.acmicpc.net/problem/14716
*/
#include<iostream>
#include<vector>
#include<cstring>
using namespace std;

bool visited[251][251];
int mac[251][251];
int M, N, cnt;
int dx[8] = { 0,0,-1,+1,-1,+1,-1,+1 };
int dy[8] = { +1,-1,0,0,+1,+1,-1,-1 };
vector<int>v;

void dfs(int x, int y) {
	visited[x][y] = true;
	cnt++;
	for (int i = 0; i < 8; i++) {
		int mx = x + dx[i];
		int my = y + dy[i];
		if (0 <= mx && 0 <= my && mx < M && my < N) {
			if (mac[mx][my] == 1 && !visited[mx][my])
				dfs(mx, my);
		}
	}
}


int main() {
	cin >> M >> N;
	
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			cin >> mac[i][j];
		}
	}


	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (mac[i][j] == 1 && !visited[i][j]) {
				cnt = 0;
				dfs(i, j);
				v.push_back(cnt);
			}
		}
	}

	cout << v.size() << '\n';

}