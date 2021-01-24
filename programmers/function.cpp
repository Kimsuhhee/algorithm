/*
문제:프로그래머스 > 코딩테스트연습 > 스택/큐 > 기능개발
출처:https://programmers.co.kr/learn/courses/30/lessons/42586
*/

#include <string>
#include <vector>
#include <queue>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> q;
    int rest;
    int d, h;
    int cnt = 1;

    for (int i = 0; i < progresses.size(); i++) {
        rest = 100 - progresses[i]; 
        d = rest / speeds[i]; 
        h = rest % speeds[i]; 
        if (h != 0) d++;
        q.push(d);
    }

    int dd = q.front();
    while (!q.empty()) {
        q.pop();
        if (dd >= q.front() && q.front() != NULL) {
            cnt++;
        }
        else {
            dd = q.front();
            answer.push_back(cnt);
            cnt = 1;
        }
    }
    if (cnt > 1)answer.push_back(cnt);
    return answer;
}
