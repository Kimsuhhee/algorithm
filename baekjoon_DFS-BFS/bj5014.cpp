/*
문제:백준5014번
출처:https://www.acmicpc.net/problem/5014
*/
#include<iostream>
#include<vector>
#include<queue>
using namespace std;
int d[1000000];
queue<int>q;
int F, S, G, U, D;
int answer = -1;

void bfs() {
	q.push(S);
	d[S] = 1;
	while (!q.empty()) {
		int floor = q.front();
		q.pop();
		if (floor + U >= 1 && floor + U <= F && d[floor + U]==0) {
			d[floor + U] = d[floor] + 1;
			q.push(floor + U);
		}
		if (floor - D >= 1 && floor - D <= F && d[floor - D] == 0) {
			d[floor - D] = d[floor] + 1;
			q.push(floor - D);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	cin >> F >> S >> G >> U >> D;
	bfs();
	if (d[G] != 0)cout << d[G] - 1 << '\n';
	else cout << "use the stairs" << '\n';
}