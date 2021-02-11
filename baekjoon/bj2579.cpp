/*
문제:백준2579번
출처:https://www.acmicpc.net/problem/2579
*/
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int cnt;
int d[300];
int stair[300];
int T;

void dp() {
	d[1] = stair[1];
	d[2] = d[1] + stair[2];
	d[3] = max(stair[3] + stair[2], stair[3] + d[1]);
	for (int i = 4; i <= T; i++) {
		d[i] = max(stair[i - 1] + d[i - 3] + stair[i], d[i - 2] + stair[i]);
	}
	cout << d[T] << '\n';
}

int main() {
	cin >> T;
	for (int i = 1; i <= T; i++)cin >> stair[i];
	
	dp();
}