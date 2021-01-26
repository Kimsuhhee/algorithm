/*
문제:백준4344번
출처:https://www.acmicpc.net/problem/4344
*/
#include<iostream>
using namespace std;

int main() {
	int c, m;
	int student;
	int jumsu[1001] = { 0 };
	cin >> c; 
	for (int i = 0; i < c; i++) {
		int sum = 0;
		double cnt = 0.0;
		cin >> student;
		for (int i = 0; i < student; i++) {
			cin >> jumsu[i];
			sum += jumsu[i];
		}
		m = sum / student; 

		for (int i = 0; i < student; i++) {
			if (jumsu[i] > m) cnt++;
		}
		cout << fixed;
		cout.precision(3);
		cout << (cnt / student) * 100 << "%" << '\n';
	}
}