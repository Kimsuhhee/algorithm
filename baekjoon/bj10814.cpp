/*
문제:백준10814번
출처:https://www.acmicpc.net/problem/10814
*/
#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;

bool compare(pair<int, string>a, pair<int, string>b) {
	return a.first < b.first;
}

int main() {
	int N;
	cin >> N;
	vector<pair<int, string>>v;
	int age; string name;
	for (int i = 0; i < N; i++) {
		cin >> age >> name;
		v.push_back(make_pair(age, name));
	}
	stable_sort(v.begin(), v.end(), compare);
	for (int i = 0; i < v.size(); i++) {
		cout << v[i].first << " " << v[i].second << '\n';
	}
}