/*
문제:백준14729번
출처:https://www.acmicpc.net/problem/14729
*/
#include <string>
#include <iostream>
#include <vector>
#include <queue>
using namespace std;


int main() {
	int N;
	double x;
	priority_queue<double, vector<double>, greater<double>> pq;
	cin >> N;
	while (N--) {
		cin >> x;
		pq.push(x);
	}
	for (int i = 0; i < 7; i++) {
		printf("%.3lf\n", pq.top());
		pq.pop();
	}
}