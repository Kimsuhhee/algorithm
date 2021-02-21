/*
문제:백준10815번
출처:https://www.acmicpc.net/problem/10815
*/
#include<iostream>
#include<algorithm>
#include<cstring>
#include<vector>
using namespace std;

vector<int>v;
int card[500001];
int N, M;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	int x;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> card[i];
	}
	sort(card, card + N);

	cin >> M;
	for (int i = 0; i < M; i++) {
		cin >> x;
		if (binary_search(card, card + N, x))cout << 1 << " ";
		else cout << 0 << " ";
	}
}