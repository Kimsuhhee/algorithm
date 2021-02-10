/*
문제:백준9461번
출처:https://www.acmicpc.net/problem/9461
*/
#include<iostream>
#include<cstring>
using namespace std;
long long p[100];
void dp(int n) {
	p[1] = 1; p[2] = 1; p[3] = 1; p[4] = 2; p[5] = 2;
	for (int i = 6; i <= n; i++)
		p[i] = p[i - 2] + p[i - 3];

}
int main() {
	int N, k;
	cin >> N;
	while (N--) {
		cin >> k;
		dp(k);
		cout << p[k] << '\n';
		memset(p, 0, sizeof(p));
	}
}