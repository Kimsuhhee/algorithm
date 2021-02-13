/*
문제:백준11727번
출처:https://www.acmicpc.net/problem/11727
*/
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

int d[1001];
int n;

void dp() {
	d[1] = 1; d[2] = 3;
	for (int i = 3; i <= n; i++) {
		d[i] = (d[i - 1] + d[i - 2] * 2) % 10007;
	}
	cout << d[n] << '\n';
}

int main() {
	cin >> n;
	dp();

}