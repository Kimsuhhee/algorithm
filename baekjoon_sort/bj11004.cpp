/*
문제:백준11004번
출처:https://www.acmicpc.net/problem/11004
*/
#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
using namespace std;

int N, K;

int main() {
	scanf_s("%d %d", &N, &K); 
	int x;
	vector<long long>v(N);
	for (int i = 0; i < N; i++) {
		scanf_s("%lld", &v[i]);
	}
	sort(v.begin(), v.end());
	printf("%lld\n",v[K - 1]);
}