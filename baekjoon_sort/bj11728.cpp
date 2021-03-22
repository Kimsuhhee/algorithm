/*
문제:백준11728번
출처:https://www.acmicpc.net/problem/11728
*/
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int N, M;
vector<int>v;

int main() {
	std::ios_base::sync_with_stdio(false);
	scanf_s("%d %d", &N, &M);

	int num;
	for (int i = 0; i < N; i++) {
		scanf_s("%d", &num);
		v.push_back(num);
	}
	for (int i = 0; i < M; i++) {
		scanf_s("%d", &num);
		v.push_back(num);
	}
	sort(v.begin(), v.end());
	for (int i = 0; i < v.size(); i++) {
		printf("%d ", v[i]);
	}
}