/*
문제:백준1152번
출처:https://www.acmicpc.net/problem/1152
*/
#include<iostream>
#include<cstring>
using namespace std;

int main() {
	char s[1000000];
	int cnt = 0;
	cin.getline(s, 1000000);
	int len = strlen(s);
	for (int i = 0; i < len; i++) {
		char c = s[i];
		if (c == ' ')cnt++;
	}
	if (s[0] == ' ')cnt--; //맨앞공백
	if (s[len-1] == ' ')cnt--; //맨뒤공백
	cout << cnt+1 << '\n';
}