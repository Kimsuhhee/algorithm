/*
문제:백준2193번
출처:https://www.acmicpc.net/problem/2193
*/
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;


long long d[91];
int N;

void dp() {
	d[1] = 1; d[2] = 1; d[3] = 2;
	for (int i = 4; i <= N; i++) {
		d[i] = d[i - 1] + d[i - 2];
	}
	cout << d[N] << '\n';
}

int main() {
	cin >> N;
	dp();
}