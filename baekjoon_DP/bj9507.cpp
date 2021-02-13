/*
문제:백준9507번
출처:https://www.acmicpc.net/problem/9507
*/
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

long long int d[1001];
int t, n;

void Koong() {
	d[0] = 1; d[1] = 1; d[2] = 2; d[3] = 4;
	for (int i = 4; i <= n; i++) {
		d[i] = d[i - 1] + d[i - 2] + d[i - 3] + d[i - 4];
	}
	cout << d[n] << '\n';
}

int main() {
	cin >> t;
	while (t--) {
		cin >> n;
		Koong();
		memset(d, 0, sizeof(d));
	}

}