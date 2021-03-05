/*
문제:백준11375번
출처:https://www.acmicpc.net/problem/11375
*/
#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
using namespace std;

int N, M, T, tmp;
vector<int>a[1005];
int d[1005];
bool visited[1005];

bool dfs(int x) {
	for (int i = 0; i < a[x].size(); i++) {
		int t = a[x][i];
		if (visited[t])continue;
		visited[t] = true;
		if (d[t] == 0 || dfs(d[t])) {
			d[t] = x;
			return true;
		}
	}
	return false;
}

int main() {
	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		cin >> T;
		for (int j = 0; j < T; j++) {
			cin >> tmp;
			a[i].push_back(tmp);
		}
	}

	int cnt = 0;
	for (int i = 1; i <= N; i++) {
		memset(visited, false, sizeof(visited));
		if (dfs(i))cnt++;
	}
	cout << cnt << '\n';
}