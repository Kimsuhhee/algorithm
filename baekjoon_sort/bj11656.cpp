/*
문제:백준11656번
출처:https://www.acmicpc.net/problem/11656
*/
#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
using namespace std;

vector<string>v;
string s;

bool compare(string a, string b) {
	if (a < b)return true;
	else return false;
}

int main() {
	cin >> s;
	int len = s.length();
	for (int i = 0; i < len; i++) {
		string temp=s.substr(i);
		v.push_back(temp);
	}
	sort(v.begin(), v.end(), compare);
	for (int i = 0; i < v.size(); i++)cout << v[i] << '\n';
}