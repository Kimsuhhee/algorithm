/*
문제:백준6603번
출처:https://www.acmicpc.net/problem/6603
*/
#include<iostream>
using namespace std;
int lotto[13];
int p[13];
int s, k;

void dfs(int start, int cnt) {
	if (cnt == 6) {
		for (int i = 0; i < 6; i++) {
			cout << p[i] << " ";
		}cout << '\n';
		return;
	}
	for (int i = start; i < k; i++) {
		p[cnt] = lotto[i];
		dfs(i + 1, cnt + 1);
	}
}
int main() {
	while (cin >> k) {
		if (k == 0)break;
		for (int i = 0; i < k; i++) {
			cin >> lotto[i];
		}
		dfs(0, 0);
		cout << '\n';
	}
}