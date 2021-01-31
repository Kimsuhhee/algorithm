/*
문제:백준11866번
출처:https://www.acmicpc.net/problem/11866
*/
#include<iostream>
#include<queue>
using namespace std;

int main() {
	queue<int>q;
	int N, K;
	cin >> N >> K;
	for (int i = 1; i <= N; i++) {
		q.push(i);
	}
	//1234567
	cout << "<";
	while (!q.empty()) {
		for (int i = 1; i <= K; i++) {
			int temp = q.front();

			if (i == K) {
				q.pop();
				cout << temp;
				if (!q.empty()) cout << ", ";
			}
			else {
				q.pop();
				q.push(temp);
			}
		}
	}

	cout << ">";
}