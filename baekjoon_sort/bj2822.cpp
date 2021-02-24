/*
문제:백준2822번
출처:https://www.acmicpc.net/problem/2822
*/
#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
using namespace std;

vector<pair<int, int>>v(9);

bool compare(const pair<int, int>& a, const pair<int, int>& b) {
	return a.first > b.first;
}

bool compare2(const pair<int, int>& a, const pair<int, int>& b) {
	return a.second < b.second;
}

int main() {
	int jumsu;
	int sum = 0;
	for (int i = 1; i <= 8; i++) {
		cin >> jumsu;
		v[i].first = jumsu;
		v[i].second = i;
	}
	sort(v.begin(), v.end(), compare);
	vector<pair<int, int>>temp(5);
	for (int i = 0; i < 5; i++) {
		temp[i].first = v[i].first;
		temp[i].second = v[i].second;
		sum += temp[i].first;
	}
	sort(temp.begin(), temp.end(), compare2);
	cout << sum << '\n';
	for (int i = 0; i < temp.size(); i++) {
		cout << temp[i].second << " ";
	}
}