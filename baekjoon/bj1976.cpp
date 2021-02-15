/*
문제:백준1976번
출처:https://www.acmicpc.net/problem/1976
*/
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

int parent[201];
int n, m;
int x, y, z;
bool flag = true;

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

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> x;
			if (x == 1) {
				unionParent(i,j);
			}
		}
	}

	cin >> y;
	for (int i = 1; i < m; i++) {
		cin >> z;
		if (findParent(z) != findParent(y)) flag = false;
		else y = z;
	
	}
	if (flag)cout << "YES";
	else cout << "NO";
	return 0;
}