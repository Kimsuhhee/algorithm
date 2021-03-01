/*
문제:백준2252번
출처:https://www.acmicpc.net/problem/2252
*/
#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
using namespace std;

int N, M, A, B;
vector<int>arr[32001];
int inDegree[32001];

void topologySort() {
	queue<int>q;
	for (int i = 0; i < N; i++) {
		if (inDegree[i] == 0)q.push(i);
	}
	while (!q.empty()) {
		int x = q.front();
		q.pop();
		cout << x + 1 << " ";
		for (int j = 0; j < arr[x].size(); j++) {
			int y = arr[x][j];
			if (--inDegree[y] == 0)q.push(y);
		}
	}
}

int main() {
	cin >> N >> M;
	while (M--) {
		cin >> A >> B;
		arr[A-1].push_back(B-1);
		inDegree[B-1]++;
	}

	topologySort();
}