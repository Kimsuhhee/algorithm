/*
문제:백준1717번
출처:https://www.acmicpc.net/problem/1717
*/
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

int parent[1000001];
int n, m;
int x, a, b;

int findParent(int p) {
	if (parent[p] == p)
		return p;
	return 
		findParent(parent[p]);
}
void unionParent(int p, int c) {
	p = findParent(p);
	c = findParent(c);
	if (p < c)
		parent[c] = p;
	else 
		parent[p] = c;
}


int main() {
	cin >> n >> m;
	for (int i = 1; i <= n; i++)parent[i] = i;

	for (int i = 0; i < m; i++) {
		cin >> x >> a >> b;
		if (x == 0) {
			unionParent(a, b);
		}
		else {
			if (findParent(a) == 1 && findParent(b) == 1)cout << "YES" << '\n';
			else cout << "NO" << '\n';
		}
	}
}