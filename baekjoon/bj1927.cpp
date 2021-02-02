/*
문제:백준1927번
출처:https://www.acmicpc.net/problem/1927
*/
#include<iostream>
#include<queue>
#include<vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	priority_queue<int,vector<int>,greater<int>>pq;
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