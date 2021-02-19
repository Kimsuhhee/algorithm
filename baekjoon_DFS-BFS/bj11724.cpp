/*
문제:백준11724번
출처:https://www.acmicpc.net/problem/11724
*/
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
vector<int>v[1000];
bool visited[1000];
int cnt;
int N, M;

void dfs(int start) {
	visited[start] = true;
	for (int i = 0; i < v[start].size(); i++) {
		int y = v[start][i];
		if (!visited[y])dfs(y);
	}
}

int main() {
	int a, b;
	cin >> N >> M;
	for (int i = 0; i < M; i++) {
			cin >> a >> b;
			v[a].push_back(b);
			v[b].push_back(a);
	}

	for (int i = 1; i <= N; i++) {
		if (!visited[i]) {
			dfs(i); cnt++;
		}
	}
	cout << cnt << '\n';
}

