/*
문제:백준1912번
출처:https://www.acmicpc.net/problem/1912
*/
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

int d[100001];
int sum[100001];
int n;

void doSum() {
	d[0] = sum[0];
	int m = d[0];
	for (int i = 1; i < n; i++) {
		d[i] = max(d[i - 1] + sum[i], sum[i]);
		m = max(m, d[i]);
	}
	cout << m << '\n';
}

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> sum[i];
	}
	doSum();
}