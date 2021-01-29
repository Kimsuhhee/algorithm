/*
문제:백준10828번
출처:https://www.acmicpc.net/problem/10828
*/
#include<iostream>
#include<stack>
#include<string>
using namespace std;

int main() {
	int N;
	string c; int num;
	cin >> N;
	stack<int> s;
	while (N--) {
		cin >> c;
		if (c == "push") {
			cin >> num;
			s.push(num);
		}
		else if (c == "pop") {
			if (!s.empty()) {
				cout << s.top() << '\n';
				s.pop();
			}
			else cout << -1 << '\n';
		}
		else if (c == "size") {
			cout << s.size() << '\n';
		}
		else if (c == "empty") {
			if (s.empty())cout << 1 << '\n';
			else cout << 0 << '\n';
		}
		else {
			if (!s.empty()) cout << s.top() << '\n';
			else cout << -1 << '\n';
		}
	}
}