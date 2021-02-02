/*
문제:백준11286번
출처:https://www.acmicpc.net/problem/11286
*/
#include<iostream>
#include<queue>
#include<vector>
#include<stdlib.h>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false); 
	priority_queue<pair<int, int>, vector<pair<int, int> >, greater<pair<int, int> > > pq;

	int N, x;
	cin >> N;
	while (N--) {
		cin >> x;
		if (x == 0) {
			if (pq.empty()) cout << 0 << '\n';
			else {
				cout << pq.top().second << '\n';
				pq.pop();
			}
		}
		else {
			pq.push({ abs(x),x });
		}
		
	}
}