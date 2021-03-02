/*
문제:백준11725번
출처:https://www.acmicpc.net/problem/11725
*/
#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
using namespace std;

int N, a, b;
vector<int>v[100001];
bool visited[100001];
int parent[100001];

void bfs(int start) {
	queue<int>q;
	q.push(start);
	visited[start] = true;
	while (!q.empty()) {
		int x = q.front();
		q.pop();
		for (int i = 0; i < v[x].size(); i++) {
			int y = v[x][i];
			if (!visited[y]) {
				q.push(y); 
				parent[y] = x;
				visited[y] = true;
			}
		}
	}
}

int main() {
	cin >> N;
	for (int i = 1; i < N ; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	bfs(1);

	for (int i = 2; i <= N; i++) {
		cout << parent[i] << '\n';
	}
}