/*
문제:백준10250번
출처:https://www.acmicpc.net/problem/10250
*/
#include<iostream>
#include<string>
using namespace std;

int main() {
	int h, w, n;
	int f,d; 
	int T;
	cin >> T;
	while (T--) {
		cin >> h >> w >> n;
		d = n / h; 
		f = n % h; 
		if (f == 0) {
			cout << h * 100 + (d) << '\n';
		}
		else {
			cout << f * 100 + (d + 1) << '\n';
		}
	}
}