/*
문제:백준1427번
출처:https://www.acmicpc.net/problem/1427
*/
#include<iostream>
#include<string>
#include<algorithm>
using namespace std;

int main() {
	string s;
	cin >> s;
	sort(s.begin(), s.end());
	reverse(s.begin(), s.end());
	cout << s;
}