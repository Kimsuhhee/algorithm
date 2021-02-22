/*
문제:백준5800번
출처:https://www.acmicpc.net/problem/5800
*/
#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
using namespace std;

int grades[51];

int main() {
	int k, N;
	int idx = 1;
	cin >> k;
	while (k--) {
		int Max = -1;
		int Min = 100;
		int diff = 0;
		cin >> N;
		for (int i = 0; i < N; i++) {
			cin >> grades[i];
			Max = max(grades[i], Max);
			Min = min(grades[i], Min);
		}
		sort(grades, grades + N,greater<int>());

		for (int i = 1; i < N; i++) {
			int temp = grades[i - 1] - grades[i];
			diff = max(temp, diff);
		}
		cout << "Class " << idx << '\n';
		idx++;
		cout << "Max " << Max << ", Min " << Min << ", Largest gap " << diff << '\n';
		memset(grades, 0, sizeof(grades));
	
	}
}