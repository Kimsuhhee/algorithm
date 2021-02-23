/*
문제:백준10825번
출처:https://www.acmicpc.net/problem/10825
*/
#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
using namespace std;

vector<pair<string, pair<int, pair<int, int>>>>pp(100001);
int N;

bool compare(const pair<string, pair<int, pair<int, int>>>& a, const pair<string, pair<int, pair<int, int>>>& b) {
	if (a.second.first == b.second.first) {
		if (a.second.second.first == b.second.second.first) {
			if (a.second.second.second == b.second.second.second) {
				return a.first < b.first;
			}
			return a.second.second.second > b.second.second.second;
		}
		return a.second.second.first < b.second.second.first;
	}
	return a.second.first > b.second.first;
}

int main() {
	cin >> N;
	string name;
	for (int i = 0; i < N; i++) {
		cin >> pp[i].first;
		cin >> pp[i].second.first >> pp[i].second.second.first >> pp[i].second.second.second;

	}
	sort(pp.begin(), pp.end(), compare);
	for (int i = 0; i < N; i++) {
		cout << pp[i].first << '\n';
	}
}