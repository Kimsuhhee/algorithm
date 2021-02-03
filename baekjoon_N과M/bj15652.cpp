/*
문제:백준15652번
출처:https://www.acmicpc.net/problem/15652
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
		//자신을 뽑는 경우를 포함
		visited[i] = true;
		arr[s] = i;
		dfs(i, s + 1);
		visited[i] = false;
	}
}

int main() {
	cin >> N >> M;

	dfs(1, 0);
}