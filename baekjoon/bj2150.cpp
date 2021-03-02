/*
문제:백준2150번
출처:https://www.acmicpc.net/problem/2150
*/
#include<iostream>
#include<algorithm>
#include<vector>
#include<stack>
using namespace std;

int V, E, a, b;
int id, d[10001];
bool finished[10001];
vector<int>arr[10001];
vector<vector<int>>SCC;
stack<int>s;

int dfs(int x) {
	d[x] = ++id;
	s.push(x);
	int parent = d[x];
	for (int i = 0; i < arr[x].size(); i++) {
		int y = arr[x][i];
		if (d[y] == 0)parent = min(parent, dfs(y));
		else if (!finished[y])parent = min(parent, d[y]);
	}
	if (parent == d[x]) {
		vector<int>scc;
		while (1) {
			int t = s.top();
			s.pop();
			scc.push_back(t);
			finished[t] = true;
			if (t == x)break;
		}
		sort(scc.begin(), scc.end());
		SCC.push_back(scc);
	}
	return parent;
}

int main() {
	cin >> V >> E;
	for (int i = 0; i < E; i++) {
		cin >> a >> b;
		arr[a].push_back(b);
	}
	for (int i = 1; i <= V; i++) {
		if (d[i] == 0)dfs(i);
	}
	sort(SCC.begin(), SCC.end());
	cout << SCC.size() << '\n';
	for (int i = 0; i < SCC.size(); i++) {
		for (int j = 0; j < SCC[i].size(); j++) {
			cout << SCC[i][j] << " ";
		}
		cout << -1 << '\n';
	}
}