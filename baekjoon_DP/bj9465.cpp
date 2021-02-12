/*
문제:백준9465번
출처:https://www.acmicpc.net/problem/9465
*/
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int cnt;
int d[2][100000];
int s[2][100000];
int T, n;

void dp() {
	d[0][0] = 0; d[1][0] = 0;
	d[0][1] = s[0][1]; d[1][1] = s[1][1];

	for (int i = 2; i <= n; i++) {
		d[0][i] = max(d[1][i - 2], d[1][i - 1]) + s[0][i];
		d[1][i] = max(d[0][i - 2], d[0][i - 1]) + s[1][i];
	}
	cout << max(d[0][n], d[1][n]) << '\n';
}

int main() {
	cin >> T;

	while (T--) {
		cin >> n;
		for (int k = 0; k < 2; k++) {
			for (int j = 1; j <= n; j++) {
				cin >> s[k][j];
			}
		}

		dp();

		memset(s, 0, sizeof(s));
		memset(d, 0, sizeof(d));
	}
}