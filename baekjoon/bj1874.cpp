/*
문제:백준1874번
출처:https://www.acmicpc.net/problem/1874
*/
#include<iostream>
#include<stack>
#include<string>
using namespace std;
int n;
int a[200000];
stack<int>st;
int main() {
	string answer = "";
	int goal = 1; //스택의탑값과 비교할 수열인덱스
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}
	for (int i = 1; i <= n; i++)
	{
		st.push(i);
		answer += '+';
		while (!st.empty()) {
			if (st.top() == a[goal]) { 
				st.pop();
				answer += '-';
				goal++;
			}
			else {
				break;
			}
		}
	}

	if (!st.empty()) {	
		cout << "NO";
	}
	else {
		for (int i = 0; i < answer.size(); i++) {
			cout << answer[i] << '\n';
		}
	}
}