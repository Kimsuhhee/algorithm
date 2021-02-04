/*
문제:백준1966번
출처:https://www.acmicpc.net/problem/1966
*/
#include <string>
#include <iostream>
#include <vector>
#include <queue>
using namespace std;


int main() {
	int N;
	cin >> N;
	while (N--) {
		int a, b, c;
		int cnt = 0;
		priority_queue<int> pq;
		queue<pair<int, int>>q;
		cin >> a >> b;
		for (int i = 0; i < a; i++) {
			cin >> c;
			pq.push(c);
			q.push({ i,c });
		}
		while (!q.empty()) {
			pair<int, int>temp = q.front();
			q.pop();
			if (pq.top() == temp.second) {
				pq.pop();
				cnt++;
				if (b == temp.first) {
					cout << cnt << '\n';
					break;
				}
			}
			else {
				q.push(temp);
			}
		}
	}

}