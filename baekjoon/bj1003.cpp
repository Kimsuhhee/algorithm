/*
문제:백준1003번
출처:https://www.acmicpc.net/problem/1003
*/
#include<iostream>
#include<cstring>
using namespace std;
int fibo[41];
int T, N;

int fibonacci(int n) {
    fibo[0] = 0; fibo[1] = 1;
    if (n == 0 || n == 1)return fibo[n];
    else {
        if (fibo[n] != 0)return fibo[n];
        else return fibo[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
int main() {
    cin >> T;
	while (T--) {
        cin >> N;
        fibonacci(N);
        if (N == 0)cout << "1 0" << '\n';
        else cout << fibo[N-1] << ' ' << fibo[N] << '\n';
        memset(fibo, 0, sizeof(fibo));
	}
}