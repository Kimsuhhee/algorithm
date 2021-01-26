/*
문제:백준8958번
출처:https://www.acmicpc.net/problem/8958
*/
#include<iostream>
#include<cstring>
using namespace std;

int main() {
	int n;
	char s[80];
	cin >> n;
	for (int i = 0; i < n; i++) {
		int cnt = 0;
		int sum = 0;
		cin >> s;
		for (int j = 0; j < strlen(s); j++) {
			if (s[j] == 'O') {
				cnt++;
				sum += cnt;
			}
			else cnt = 0;
		}
		cout << sum << '\n';
	}
	
}