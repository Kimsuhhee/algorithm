/*
문제:백준4949번
출처:https://www.acmicpc.net/problem/4949
*/
#include<iostream>
#include<stack>
#include<cstring>
using namespace std;

bool isBalance(char c[]) {
	stack<char> s;
	int len = strlen(c);
	for (int i = 0; i < len ; i++) {
		if (c[i] == '(' || c[i] == '[') s.push(c[i]);
		else if (c[i] == ')') {
			if (!s.empty() && s.top() == '(') {
				s.pop();
			}
			else return false;
		}
		else if (c[i] == ']') {
			if (!s.empty() && s.top() == '[') {
				s.pop();
			}
			else return false;
		}
	}
	if (!s.empty()) return false;
	return true;
}

int main() {
	string s;
	char c[101];

	while (cin.getline(c, 101)) {
		if (c[0] == '.')break;
		if (isBalance(c))
			cout << "yes" << '\n';
		else
			cout << "no" << '\n';
	}
}