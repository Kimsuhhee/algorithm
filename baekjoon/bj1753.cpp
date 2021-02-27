/*
문제:백준1753번
출처:https://www.acmicpc.net/problem/1753
*/
#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
using namespace std;

int V, E, K, u, v, w;
int INF = 1000000000;
vector<pair<int, int>>a[20001]; //간선정보
int d[20001]; //최소비용
priority_queue<pair<int, int>> pq;


void dijkstra(int start) {
	d[start] = 0;
	pq.push(make_pair(0, start));

	while (!pq.empty()) {
		int cur = pq.top().second;
		int distance = -pq.top().first;
		pq.pop();
		if (d[cur] < distance)continue;
		for (int i = 0; i < a[cur].size(); i++) {
			int next = a[cur][i].first;
			int nextDistance = distance + a[cur][i].second;
			if (nextDistance < d[next]) {
				d[next] = nextDistance;
				pq.push(make_pair(-nextDistance, next));
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> V >> E >> K;

	for (int i = 1; i <= V; i++) {
		d[i] = INF;
	}

	for (int i = 0; i < E; i++) {
		cin >> u >> v >> w;
		a[u].push_back(make_pair(v, w));
	}

	dijkstra(K);
	for (int i = 1; i <= V; i++) {
		if (d[i] == INF) cout << "INF" << '\n';
		else cout << d[i] << '\n';
	}
}