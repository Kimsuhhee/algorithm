/*
문제:백준1149번
출처:https://www.acmicpc.net/problem/1149
*/
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int cnt;
int d[1000][1000];
int rgb[1000][1000];
int N;

void dp(int n) {
	d[0][0] = rgb[0][0];
	d[0][1] = rgb[0][1];
	d[0][2] = rgb[0][2];
	for (int i = 1; i < N; i++) {
		d[i][0] = min(d[i - 1][1], d[i - 1][2]) + rgb[i][0];
		d[i][1] = min(d[i - 1][0], d[i - 1][2]) + rgb[i][1];
		d[i][2] = min(d[i - 1][0], d[i - 1][1]) + rgb[i][2];
	}

}

int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> rgb[i][0] >> rgb[i][1] >> rgb[i][2];
	}
	dp(N);
	cout << min(min(d[N - 1][0], d[N - 1][1]), d[N - 1][2]) << '\n';
}