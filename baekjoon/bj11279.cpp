/*
문제:백준11279번
출처:https://www.acmicpc.net/problem/11279
*/
#include<iostream>
#include<queue>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	priority_queue<int>pq;
	int N, x;
	cin >> N;
	while (N--) {
		cin >> x;
		if (x == 0) {
			if (!pq.empty()) {
				int temp = pq.top();
				cout << temp << '\n';
				pq.pop();
			}
			else cout << 0 << '\n';
		}
		else {
			pq.push(x);
		}
	}
}