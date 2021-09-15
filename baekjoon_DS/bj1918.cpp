/*
문제:백준1918번
출처:https://www.acmicpc.net/problem/1918
*/
#include<iostream>
#include<string>
#include<stack>

using namespace std;

int ranking(char c) {
	if (c == '(' || c == ')')return 2;
	if (c == '*' || c == '/')return 1;
	if (c == '+' || c == '-')return 0;
}

int main() {
	stack<char>st;
	string tmp = "";
	string s = "";

	cin >> s;

	for (int i = 0; i < s.size(); i++) {
		if (s[i] >= 'A' && s[i] <= 'Z')tmp += s[i];
		else if (s[i] == '(')st.push(s[i]);
		else if (s[i] == ')') {
			while (!st.empty()) {
				if (st.top() == '(') {
					st.pop(); break;
				}
				tmp += st.top();
				st.pop();
			}
		}
		else {
			while (!st.empty() && ranking(st.top()) >= ranking(s[i])) {
				if (st.top() == '(')break;
				tmp += st.top();
				st.pop();
			}
			st.push(s[i]);
		}

	}
	while (!st.empty()) {
		tmp += st.top();
		st.pop();
	}
	cout << tmp;
}
