/*
문제:백준1920번
출처:https://www.acmicpc.net/problem/1920
*/
#include<iostream>
#include<algorithm>
#include<cstring>
#include<vector>
using namespace std;

int d[100001];
int N, M;

int main() {
	ios_base::sync_with_stdio(0); 
	cin.tie(0); cout.tie(0);
	int x;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> d[i];
	}
	sort(d, d + N);
	
	cin >> M;
	for (int i = 0; i < M; i++) {
		cin >> x;
		if (binary_search(d, d + N, x))cout << 1 << '\n';
		else cout << 0 << '\n';
	}
}