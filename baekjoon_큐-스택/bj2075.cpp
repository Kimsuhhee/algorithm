/*
문제:백준2075번
출처:https://www.acmicpc.net/problem/2075
*/
#include <string>
#include <iostream>
#include <vector>
#include <queue>
using namespace std;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, x;
	priority_queue<long, vector<long>, greater<long>> pq;
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> x;
			pq.push(x);
			if (pq.size() > N)pq.pop();
		}
	}
	cout << pq.top();
}