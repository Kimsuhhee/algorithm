/*
문제:백준3986번
출처:https://www.acmicpc.net/problem/3986
*/
#include<iostream>
#include<string>
#include<stack>

using namespace std;
int N, answer;
string s;
int main() {
	cin >> N;
	while (N--) {
		stack<char>st;
		cin >> s;
		for (int i = 0; i < s.size(); i++) {
			if (st.empty())st.push(s[i]);
			else {
				if (st.top() == s[i])st.pop();
				else {
					st.push(s[i]);
				}
			}
		}
		if (st.empty())answer++;
	}
	cout << answer;
}