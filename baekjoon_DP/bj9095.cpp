/*
문제:백준9095번
출처:https://www.acmicpc.net/problem/9095
*/
#include<iostream>
#include<cstring>
using namespace std;
int d[11];
int T, n;

void dp() {
	d[1] = 1;
	d[2] = 2;
	d[3] = 4;
	for (int i = 4; i <= n; i++) {
		d[i] = d[i - 1] + d[i - 2] + d[i - 3];
	}
	cout << d[n] << '\n';
}

int main() {
	cin >> T;
	while (T--) {
		cin >> n;
		dp();
		memset(d, 0, sizeof(d));
	}
}