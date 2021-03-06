/*
문제:프로그래머스 > 코딩테스트연습 > 연습문제 > 같은숫자는싫어
출처:https://programmers.co.kr/learn/courses/30/lessons/12906
*/
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr)
{
    vector<int>answer;
    int tmp = arr[0];
    answer.push_back(tmp);
    for (int i = 0; i < arr.size(); i++) {
        if (tmp != arr[i]) {
            tmp = arr[i];
            answer.push_back(tmp);
        }
    }
    return answer;
}

int main() {
    vector<int>arr = { 1,1,3,3,0,1,1 };
    vector<int>answer = solution(arr);
    for (int i = 0; i < answer.size(); i++) {
        cout << answer[i] << " ";
    }
}