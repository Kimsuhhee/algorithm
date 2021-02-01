/*
문제:백준1260번
출처:https://www.acmicpc.net/problem/1260
*/
#include<iostream>
#include<queue>
#include<algorithm>
#include<vector>
using namespace std;

vector<int>v[10000];
bool visited[10000];
bool visited1[10000];
int N, M, V;

void bfs(int start) {
	queue<int>q;
	q.push(start);
	visited1[start] = true;
	while (!q.empty()) {
		int x = q.front();
		cout << x << " ";
		q.pop();
		for (int i = 0; i < v[x].size(); i++) {
			int y = v[x][i];
			if (!visited1[y]) {
				visited1[y] = true;
				q.push(y);
			}
		}
	}
}

void dfs(int start) {
	if (visited[start])return;
	cout << start << " ";
	visited[start] = true;
	for (int i = 0; i < v[start].size(); i++) {
		int y = v[start][i];
		if (!visited[y]) {
			dfs(y);
		}

	}
}
int main() {
	int a, b;
	cin >> N >> M >> V;
	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	for (int i = 1; i <= N; i++) {
		sort(v[i].begin(), v[i].end());
	}
	dfs(V);
	cout << '\n';
	bfs(V);
}