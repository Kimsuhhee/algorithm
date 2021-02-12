/*
문제:백준2156번
출처:https://www.acmicpc.net/problem/2156
*/
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int d[10001];
int graph[10001];
int n;

void dp() {
	d[1] = graph[1];
	d[2] = d[1] + graph[2];
	for (int i = 3; i <= n; i++) {
		d[i] = max(d[i - 1], max(graph[i - 1] + graph[i] + d[i - 3], d[i - 2] + graph[i]));
	}
	cout << d[n] << '\n';
}

int main() {
	cin >> n;
	for (int i = 1; i <= n; i++)cin >> graph[i];
	dp();
}