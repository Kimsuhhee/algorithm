/*
문제:백준10816번
출처:https://www.acmicpc.net/problem/10816
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
		auto up = upper_bound(card, card + N, x);
		auto lo = lower_bound(card, card + N, x);
		cout << up - lo << " ";
	}
}