/*
문제:백준11726번
출처:https://www.acmicpc.net/problem/11726
*/
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

int d[1001];
int n;

void dp() {
	d[1] = 1; d[2] = 2;
	for (int i = 3; i <= n; i++) {
		d[i] = (d[i - 1] + d[i - 2]) % 10007;
	}
	cout << d[n] << '\n';
}

int main() {
	cin >> n;
	dp();

}