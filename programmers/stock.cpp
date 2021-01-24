/*
문제:프로그래머스 > 코딩테스트연습 > 스택/큐 > 주식가격
출처:https://programmers.co.kr/learn/courses/30/lessons/42584
*/

#include <string>
#include <vector>
#include <queue>
using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    queue<int> q;
    int cur;
    int cnt;
    for (int i = 0; i < prices.size(); i++) {
        q.push(prices[i]); 
    }
    int idx = 0;
    while (!q.empty()) {
        cur = q.front();
        q.pop();
        idx++;
        cnt = 0;
        for (int i = idx; i < prices.size(); i++) {
            if (prices[i] >= cur) cnt++;
            else {
                cnt++;
                break;
            }
        }
        answer.push_back(cnt);
    }
    return answer;
}