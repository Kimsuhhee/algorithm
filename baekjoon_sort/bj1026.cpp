/*
문제:백준1026번
출처:https://www.acmicpc.net/problem/1026
*/
#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
using namespace std;

int A[51], B[51];
int N, answer;

int main() {
	cin >> N;
	
	for (int i = 0; i < N; i++) {
		cin >> A[i];
	}
	for (int i = 0; i < N; i++) {
		cin >> B[i];
	}

	sort(A, A + N);
	sort(B, B + N,greater<int>());

	for (int i = 0; i < N; i++) {
		answer += A[i] * B[i];
	}
	cout << answer << '\n';
}