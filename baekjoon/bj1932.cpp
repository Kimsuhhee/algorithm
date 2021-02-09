/*
문제:백준1932번
출처:https://www.acmicpc.net/problem/1932
*/
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int d[501][501];
int main() {
	int N;
	int m = -1;
	cin >> N;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= i; j++) {
			cin >> d[i][j];
		}
	}
	
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= i; j++) {
			if (j == 1) {
				d[i][j] += d[i-1][j];
			}
			else if (j == i) {
				d[i][j] += d[i - 1][j - 1];
			}
			else {
				d[i][j] += max(d[i - 1][j], d[i - 1][j - 1]);
			}
		}
	}

	for (int j = 0; j <= N; j++) {
		if (m < d[N][j])m = d[N][j];
	}
	cout << m << '\n';
}