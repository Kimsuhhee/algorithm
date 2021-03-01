/*
문제:백준11404번
출처:https://www.acmicpc.net/problem/11404
*/
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int n, m, a, b, c;
int arr[101][101];
int d[101][101];
int INF = 1000000001;

void floydWarshall() {

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			d[i][j] = arr[i][j];
		}
	}
	
	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (d[i][k] + d[k][j] < d[i][j]) {
					d[i][j] = d[i][k] + d[k][j];
				}
			}
		}
	}
}

int main() {
	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (i == j)arr[i][j] = 0;
			else arr[i][j] = INF;
		}
	}

	for (int i = 0; i < m; i++) {
		cin >> a >> b >> c;
		arr[a][b] = min(arr[a][b], c);
	}

	floydWarshall();

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (d[i][j] == INF)cout << 0 << " ";
			else cout << d[i][j] << " ";
		}
		cout << '\n';
	}
}