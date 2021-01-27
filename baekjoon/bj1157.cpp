/*
문제:백준1157번
출처:https://www.acmicpc.net/problem/1157
*/
#include<iostream>
#include<cstring>
using namespace std;

int main() {
	char s[1000001];
	int alpha[26] = { 0 };
	int max = -1;
	int cnt = 0;
	int idx;
	cin >> s;
	int len = strlen(s);
	for (int i = 0; i < len; i++) {
		char c = s[i];
		if (c >= 'a' && c <= 'z') {
			c -= 32;
		}
		alpha[c - 'A']++;
	}
	for (int i = 0; i < 26; i++) {
		if (max < alpha[i]) { 
			max = alpha[i];
			idx = i;
		}
	}

	for (int n : alpha) {
		if (max == n)cnt++;
	}
	if (cnt > 1)cout << "?" << '\n';
	else {
		char c = idx + 'A';
		cout << c << '\n';
	}

}