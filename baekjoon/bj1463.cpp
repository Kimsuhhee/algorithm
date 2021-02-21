/*
문제:백준1463번
출처:https://www.acmicpc.net/problem/1463
*/
#include<iostream>
#include<algorithm>
using namespace std;

int d[1000001];
int N;

void dp() {
	d[0] = 0; d[1] = 0;
	for (int i = 2; i <= N; i++) {
		d[i] = d[i - 1] + 1;
		if (i % 2 == 0)
			d[i] = min(d[i], d[i / 2] + 1);
		if (i % 3 == 0)
			d[i] = min(d[i], d[i / 3] + 1);
	}
	cout << d[N];
}

int main() {
	cin >> N;
	dp();
}