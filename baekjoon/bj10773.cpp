/*
문제:백준10773번
출처:https://www.acmicpc.net/problem/10773
*/
#include<iostream>
#include<stack>
#include<string>
using namespace std;

int main() {
	stack<int>s;
	int N, a;
	int sum = 0;
	cin >> N;
	while (N--) {
		cin >> a;
		if (a == 0) {
			sum -= s.top();
			s.pop();
		}
		else {
			s.push(a);
			sum += a;
		}
	}
	cout << sum << '\n';
}