/*
문제:백준2693번
출처:https://www.acmicpc.net/problem/2693
*/
#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
using namespace std;

int arr[10];
int T, N;

int main() {
	cin >> T;
	while (T--) {
		for (int i = 0; i < 10; i++) {
			cin >> arr[i];
		}
		sort(arr, arr + 10);
		cout << arr[7] << '\n';
		memset(arr, 0, sizeof(arr));
	}
}