/*
문제:프로그래머스 > 코딩테스트연습 > 정렬 > K번째수
출처:https://programmers.co.kr/learn/courses/30/lessons/42748
*/

#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    int sIdx, eIdx, num;
    for (int i = 0; i < commands.size(); i++) {
        vector<int> temp;
        sIdx = commands[i][0];
        eIdx = commands[i][1];
        num = commands[i][2];
        for (int k = sIdx - 1; k < eIdx; k++) {
            temp.push_back(array[k]);
        }
        sort(temp.begin(), temp.end());
        answer.push_back(temp[num - 1]);
    }

    return answer;
}