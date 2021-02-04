/*
문제:백준1978번
출처:https://www.acmicpc.net/problem/1978
*/
#include <iostream>
#include<vector>
using namespace std;

int main() {
	int N,x,i;
	int cnt = 0;
	cin >> N;
	while (N--) {
		cin >> x;
		if (x == 1)continue;
		else if (x == 2)cnt++;
		else{
			for (i = 2; i < x; i++) {
				if (x % i == 0)break; //1과 자신외의 수로 나눠지면 소수 아님
				
			}
			if (x == i)cnt++; 
		}
	}
	cout << cnt << '\n';
}