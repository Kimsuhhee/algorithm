/*
문제:프로그래머스 > 코딩테스트연습 > 힙 > 더 맵게
출처:https://programmers.co.kr/learn/courses/30/lessons/42626
*/
#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int>>pq;

    for (int i = 0; i < scoville.size(); i++) {
        pq.push(scoville[i]);
    }
    while (pq.top()<K) {
        if(pq.size()==1)
            return -1;
        int x = pq.top(); pq.pop();
        int y = pq.top(); pq.pop();
        pq.push(x + (y * 2));
        answer++;
        
        if (pq.top() >= K) 
            return answer;
    }

    return -1;
}

int main() {
    vector<int>scoville = {1,2,3,9,10,12 };
    int K = 7;
    cout << solution(scoville, K) << '\n';
}