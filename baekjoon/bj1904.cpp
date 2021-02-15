/*
문제:백준1904번
출처:https://www.acmicpc.net/problem/1904
*/
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;


long long d[1000001];
int N;

void dp() {
	d[1] = 1; d[2] = 2;
	for (int i = 3; i <= N; i++) {
		d[i] = (d[i - 1] + d[i - 2]) % 15746;
	}
	cout << d[N] << '\n';
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	dp();
}