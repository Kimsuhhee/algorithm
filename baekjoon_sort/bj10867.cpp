/*
문제:백준10867번
출처:https://www.acmicpc.net/problem/10867
*/
#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
using namespace std;

vector<int>v;
int N;

int main() {
	cin >> N;
	int x;
	for (int i = 0; i < N; i++) {
		cin >> x;
		v.push_back(x);
	}
	sort(v.begin(), v.end()); 
	v.erase(unique(v.begin(), v.end()), v.end());
	for (int i = 0; i < v.size(); i++)cout << v[i] << " ";
}