/*
문제:백준9625번
출처:https://www.acmicpc.net/problem/9625
*/
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;


int d[2][46];
int K;

void countAB() {
	d[0][0] = 1; d[0][1] = 0;
	d[1][0] = 0; d[1][1] = 1;
	for (int i = 2; i <= K; i++) {
		d[0][i] = d[0][i - 2] + d[0][i - 1];
		d[1][i] = d[1][i - 2] + d[1][i - 1];
	}
	cout << d[0][K] << " " << d[1][K] << '\n';
}

int main() {
	cin >> K;
	countAB();
}