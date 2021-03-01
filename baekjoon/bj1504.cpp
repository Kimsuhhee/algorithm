/*
문제:백준1504번
출처:https://www.acmicpc.net/problem/1504
*/
#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
using namespace std;

int N, E, a, b, c;
int v1, v2;
int d[801];
vector<pair<int, int>>dijk[801];
int INF = 1000000001;

void dijkstra(int start) {
	for (int i = 1; i <= N; i++) {
		d[i] = INF;
	}
	d[start] = 0;
	priority_queue<pair<int, int>>pq;
	pq.push(make_pair(0,start));
	while (!pq.empty()) {
		int cur = pq.top().second; 
		int distance = -pq.top().first;
		pq.pop();

		if (d[cur] < distance)continue;
		for (int i = 0; i < dijk[cur].size(); i++) {
			int next = dijk[cur][i].first;
			int nextDistance = distance + dijk[cur][i].second;
			if (nextDistance < d[next]) {
				d[next] = nextDistance;
				pq.push(make_pair(-nextDistance, next));
			}
		}
	}
}

int main() {
	cin >> N >> E;
	
	for (int i = 0; i < E; i++) {
		cin >> a >> b >> c;
		dijk[a].push_back(make_pair(b, c));
		dijk[b].push_back(make_pair(a, c));
	}
	cin >> v1 >> v2;

	dijkstra(1);
	int oneTov1 = d[v1];
	int oneTov2 = d[v2];
	
	dijkstra(v1);
	int v1Tov2 = d[v2];
	int v1ToN = d[N];
	
	dijkstra(v2);
	int v2Tov1 = d[v1];
	int v2ToN = d[N];

	int sum = min(oneTov1 + v1Tov2 + v2ToN, oneTov2 + v2Tov1 + v1ToN);
	if (sum >= INF || sum < 0)cout << -1 << '\n';
	else cout << sum << '\n';
}