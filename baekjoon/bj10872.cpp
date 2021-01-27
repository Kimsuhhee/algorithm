/*
문제:백준10872번
출처:https://www.acmicpc.net/problem/10872
*/
#include<iostream>
using namespace std;

int factorial(int N) {
	if (N > 2)
		N *= factorial(N - 1);
	return N;
}
int main() {
	int N;
	cin >> N;
	if (N == 0)
		cout << 1 << '\n';
	else 
		cout << factorial(N) << '\n';
}