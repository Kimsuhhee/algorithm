/*
문제:백준1021번
출처:https://www.acmicpc.net/problem/1021
*/
#include<iostream>
#include<deque>
using namespace std;

int main() {
	deque<int>dq;
	deque<int>::iterator it;
	int N, M, k;
	int res = 0;
	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		dq.push_back(i);
	}
	while (M--) {
		int idx = 0;
		cin >> k;
		for (it = dq.begin(); it < dq.end(); it++) {
			if (*it == k)break;
			idx++;
		}
		int l = idx;
		int r = dq.size() - idx;

		if (l < r) {
			while(1){
				int temp = dq.front();
				if (temp == k) {
					dq.pop_front(); break;
				}
				res++;
				dq.pop_front();
				dq.push_back(temp);
			}
		}
		else {
			while(1){
				if (dq.front() == k) {
					dq.pop_front(); break;
				}
				res++;
				int temp = dq.back();
				dq.pop_back();
				dq.push_front(temp);
			}
		}
		
	}
	cout << res << '\n';
}