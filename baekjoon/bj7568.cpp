/*
문제:백준7568번
출처:https://www.acmicpc.net/problem/7568
*/
#include<iostream>
#include<algorithm>
#include<tuple>
#include<cstring>

using namespace std;

pair<int, int>p[51];
int a[51];
int N;

int main() {
	int x, y, z;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> p[i].first >> p[i].second;
	}
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (i == j)continue;
			if (p[i].first < p[j].first && p[i].second < p[j].second)
				a[i]++;
		}
	}
	for (int i = 0; i < N; i++)cout << a[i] + 1 << " ";
}