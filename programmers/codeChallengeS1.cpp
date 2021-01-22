/*
문제:프로그래머스 > 코딩테스트연습 > 월간코드챌린지시즌1 > 두개뽑아서더하기
출처:https://programmers.co.kr/learn/courses/30/lessons/68644
*/
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    int sum = 0;
    for (int i = 0; i < numbers.size(); i++) {
        for (int j = i + 1; j < numbers.size(); j++) {
            sum = numbers[i] + numbers[j];
            answer.push_back(sum);
        }
    }
    sort(answer.begin(), answer.end());
    answer.erase(unique(answer.begin(), answer.end()), answer.end());
    return answer;
}
int main() {
   // vector<int>numbers{ 2,1,3,4,1 };
    vector<int>numbers{ 5,0,2,7 };
    vector<int>answer = solution(numbers);
    for (int i = 0; i < answer.size(); i++) {
        cout << answer[i] << " " ;
    }
}