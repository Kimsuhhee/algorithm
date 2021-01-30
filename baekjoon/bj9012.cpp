/*
문제:백준9012번
출처:https://www.acmicpc.net/problem/9012
*/
#include<iostream>
#include<stack>
#include<string>
using namespace std;

bool isVPS(string ps) {
	stack<char> s;
	for (int i = 0; i < ps.length(); i++) {
		if (ps[i] == '(') s.push(ps[i]);
		else {
			if (s.empty())return false;
			s.pop();
		}
	}
	if (!s.empty()) return false;
	return true;
}

int main() {
	int N;
	string ps;
	cin >> N;
	while (N--) {
		cin >> ps;
		if (isVPS(ps))
			cout << "YES" << '\n';
		else
			cout << "NO" << '\n';
	}
}