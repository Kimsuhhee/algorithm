/*
문제:백준2606번
출처:https://www.acmicpc.net/problem/2606
*/
#include<iostream>
#include<vector>
using namespace std;

vector<int>v[101];
bool visited[101];
int cnt;

void dfs(int start) {
	visited[start] = true;
	cnt++;
	for (int i = 0; i < v[start].size(); i++) {
		int x = v[start][i];
		if (!visited[x]) dfs(x);
	}
}

int main() {
	int N, M; 
	int a, b;
	cin >> N >> M;
	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	dfs(1);
	cout << cnt-1 << '\n';
}