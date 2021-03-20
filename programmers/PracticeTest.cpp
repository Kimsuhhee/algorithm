/*
문제:프로그래머스 > 코딩테스트연습 > 완전탐색 > 모의고사
출처:https://programmers.co.kr/learn/courses/30/lessons/42840
*/
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    int cnt[3] = { 0, };
    int m = -1;
    int s1[] = { 1,2,3,4,5 };
    int s2[] = { 2,1,2,3,2,4,2,5 };
    int s3[] = { 3,3,1,1,2,2,4,4,5,5 };

    for (int i = 0; i < answers.size(); i++) {
        if (s1[i % 5] == answers[i]) cnt[0]++;
        if (s2[i % 8] == answers[i]) cnt[1]++;
        if (s3[i % 10] == answers[i]) cnt[2]++;

        m = max(max(cnt[0], cnt[1]), cnt[2]);
    }
    for (int i = 0; i < 3; i++) {
        if (cnt[i] == m)answer.push_back(i + 1);
    }
    return answer;
}
int main() {
    vector<int> answers = { 1,3,2,4,2 };
    vector<int>answer = solution(answers);
    for (int i : answer)cout << i << " ";
}