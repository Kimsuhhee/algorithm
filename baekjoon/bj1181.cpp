/*
문제:백준1181번
출처:https://www.acmicpc.net/problem/1181
*/
#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;

bool compare(string a, string b) {
	if (a.size() == b.size()) { //문자열의 길이가 같을경우
		return a < b; //사전순서
	}
	else //문자열의 길이가 다른경우
		return a.size() < b.size();	//문자열의 길이가 짧은순서
}

int main() {
	int N;
	cin >> N;
	vector<string>v;
	string s;
	for (int i = 0; i < N; i++) {
		cin >> s;
		v.push_back(s);
	}
	stable_sort(v.begin(), v.end(), compare);
	v.erase(unique(v.begin(), v.end()), v.end());
	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << '\n';
	}
}