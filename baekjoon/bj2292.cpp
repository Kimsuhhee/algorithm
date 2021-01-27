/*
문제:백준2292번
출처:https://www.acmicpc.net/problem/2292
*/
#include<iostream>
using namespace std;

int main() {
	int N;
	int sum = 1;
	int res = 1;
	cin >> N;
	while (1) {
		if (N <= sum)break;
		sum += 6 * res;
		res++;
	}
	cout << res;
}