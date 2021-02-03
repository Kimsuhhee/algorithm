/*
문제:백준15650번
출처:https://www.acmicpc.net/problem/15650
*/
#include <iostream>
#include <algorithm>
using namespace std;
int N, M;
int arr[9];
bool visited[9];
void dfs(int d, int s) {
	if (s == M) {
		for (int i = 0; i < M; i++) {
			cout << arr[i] << " ";
		}cout << '\n';
		return;
	}
	for (int i = d; i <= N; i++) {
		if (!visited[i]) { //자신을 뽑지 않음
			visited[i] = true;
			arr[s] = i;
			dfs(i + 1, s + 1);
			visited[i] = false;
		}
	}
}

int main() {
	cin >> N >> M;

	dfs(1, 0);
}