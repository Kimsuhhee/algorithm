/*
문제:백준1697번
출처:https://www.acmicpc.net/problem/1697
*/
#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int s[100000];
int N, K;
void bfs(int start) {
	queue<int>q;
	q.push(start);
	s[start] = 1;

	while (!q.empty()) {
		int cx = q.front();
		q.pop();
		if (cx == K) return;
		if (cx - 1 >= 0 && s[cx - 1]==0) {
			s[cx - 1] = s[cx] + 1;
			q.push(cx - 1);
		}
		if (cx + 1 <= 100000 && s[cx + 1]==0) {
			s[cx + 1] = s[cx] + 1;
			q.push(cx + 1);
		}
		if (cx * 2 <= 100000 && s[cx * 2]==0) {
			s[cx * 2] = s[cx] + 1;
			q.push(cx * 2);
		}
	}
}

int main() {
	cin >> N >> K;
	
	bfs(N);

	cout << s[K] - 1 << '\n';

}