/*
문제:백준11650번
출처:https://www.acmicpc.net/problem/11650
*/
#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;

bool compare(pair<int, int>a, pair<int, int>b) {
	if (a.first == b.first)return a.second < b.second;
	return a.first < b.first;
}

int main() {
	int N;
	cin >> N;
	vector<pair<int, int>>v;
	int x, y;
	for (int i = 0; i < N; i++) {
		cin >> x >> y;
		v.push_back(make_pair(x, y));
	}
	stable_sort(v.begin(), v.end(), compare);
	for (int i = 0; i < v.size(); i++) {
		cout << v[i].first << " " << v[i].second << '\n';
	}
}