/*
문제:백준4196번
출처:https://www.acmicpc.net/problem/4196
*/
#include<iostream>
#include<algorithm>
#include<vector>
#include<stack>
#include<cstring>
using namespace std;

int T, N, M, x, y;
int cnt = 1;
int id, d[100001], g[100001], inDegree[100001];
bool finished[100001];
vector<int>a[100001];
vector<vector<int>>SCC;
stack<int>s;

int dfs(int x) {
	d[x] = ++id;
	s.push(x);
	int parent = d[x];
	for (int i = 0; i < a[x].size(); i++) {
		int y = a[x][i];
		if (d[y] == 0)parent = min(parent, dfs(y));
		else if (!finished[y])parent = min(parent, d[y]);
	}
	if (parent == d[x]) {
		vector<int>scc;
		while (1) {
			int t = s.top();
			s.pop();
			g[t] = cnt;
			scc.push_back(t);
			finished[t] = true;
			if (t == x)break;
		}
		SCC.push_back(scc);
		cnt++;
	}
	return parent;
}

int main() {
	cin >> T;
	while (T--) {
		cin >> N >> M;
		for (int i = 0; i < M; i++) {
			cin >> x >> y;
			a[x].push_back(y);
		}
		for (int i = 1; i <= N; i++) {
			if (d[i] == 0)dfs(i);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < a[i].size(); j++) {
				int y = a[i][j];
				if (g[i] != g[y])
					inDegree[g[y]]++;
			}
		}

		int sum = 0;
		for (int i = 1; i <= SCC.size(); i++) {
			if (inDegree[i] == 0)sum++;
		}
		cout << sum << '\n';
		cnt = 1;
		memset(a, 0, sizeof(a));
		memset(d, 0, sizeof(d));
		memset(inDegree, 0, sizeof(inDegree));
		memset(finished, 0, sizeof(finished));
		SCC.clear();
	}
}