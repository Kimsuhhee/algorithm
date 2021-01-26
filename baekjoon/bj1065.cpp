/*
문제:백준1065번
출처:https://www.acmicpc.net/problem/1065
*/
#include<iostream>
using namespace std;

int hansu(int num) {
	int a, b, c;
	int cnt = 99;
	if (num < 100)
		return num;
	else {
		for (int i = 100; i <= num; i++) {
			a = i / 100;
			b = (i % 100) / 10;
			c = i % 10;
			if ((a - b) == (b - c))cnt++;
		}
		return cnt;
	}
}

int main() {
	int num;
	cin >> num;
	cout << hansu(num);
}