/*
문제:백준10866번
출처:https://www.acmicpc.net/problem/10866
*/
#include<iostream>
#include<deque>
using namespace std;

int main() {
	deque<int>dq;
	string s;
	int N;
	cin >> N;
	while (N--) {
		int X;
		cin >> s;
		if (s == "push_front") {
			cin >> X;
			dq.push_front(X);
		}
		else if (s == "push_back") {
			cin >> X;
			dq.push_back(X);
		}
		else if (s == "pop_front") {
			if (!dq.empty()) {
				cout << dq.front() << '\n';
				dq.pop_front();
			}
			else cout << -1 << '\n';
		}
		else if (s == "pop_back") {
			if (!dq.empty()) {
				cout << dq.back() << '\n';
				dq.pop_back();
			}
			else cout << -1 << '\n';
		}
		else if (s == "size") {
			cout << dq.size() << '\n';
		}
		else if (s == "empty") {
			if (dq.empty())cout << 1 << '\n';
			else cout << 0 << '\n';
		}
		else if (s == "front") {
			if (!dq.empty())cout << dq.front() << '\n';
			else cout << -1 << '\n';
		}
		else {
			if (!dq.empty())cout << dq.back() << '\n';
			else cout << -1 << '\n';
		}
	}
	
}