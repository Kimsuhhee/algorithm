/*
문제:프로그래머스 > 코딩테스트연습 > Summer/Winter Coding(~2018) > 스킬트리
출처:https://programmers.co.kr/learn/courses/30/lessons/49993
*/
#include <string>
#include <vector>
#include <iostream>
using namespace std;
string skill = "CBD";
vector<string> skill_trees = { "BACDE","CBADF","AECB","BDA" };

int solution(string skill, vector<string> skill_trees) {
    vector<char>v;
    int answer = 0;
    for (int j = 0; j < skill_trees.size(); j++) {
        int cnt = 0;//자리수 카운트
        bool flag = true;
        string s = skill_trees[j];
        for (int k = 0; k < s.size(); k++) {
            int cur = skill.find(s[k]);
            if (cur == -1) continue;
            if (cnt != cur) { 
                flag = false;
                break;
            }
            cnt++;
        }
        if (flag)answer++;
    }
    return answer;
}
int main() {
    cout << solution(skill, skill_trees) << '\n';
}