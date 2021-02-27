/*
문제:백준9372번
출처:https://www.acmicpc.net/problem/9372
*/
#include<iostream>
using namespace std;

int T, N, M;
int a, b;

int main() {
	cin >> T;
	while (T--) {
		cin >> N >> M;

		for (int i = 0; i < M; i++) {
			cin >> a >> b;
		}
		cout << N - 1 << '\n'; //간선의 개수 = 노드수-1
	}

}