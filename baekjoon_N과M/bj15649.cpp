/*
문제:백준15649번
출처:https://www.acmicpc.net/problem/15649
*/
#include <iostream>
#include <algorithm>
using namespace std;
int N, M;
int arr[9];
bool visited[9];
void dfs(int s) {
	if (s == M) {
		for (int i = 0; i < M; i++) {
			cout << arr[i] << " ";
		}cout << '\n';
		return;
	}
	for (int i = 1; i <= N; i++) {
		if (!visited[i]) { //자신을 뽑지 않음
			visited[i] = true;
			arr[s] = i;
			dfs(s + 1);
			visited[i] = false;
		}
	}
}

int main() {
	cin >> N >> M;

	dfs(0);
}