/*
문제:프로그래머스 > 코딩테스트연습 > 탐욕법(Greedy) > 체육복
출처:https://programmers.co.kr/learn/courses/30/lessons/42862
*/
#include <string>
#include <vector>
#include <iostream>

using namespace std;
int student[30];
int n = 5;
vector<int> lost = { 2,4 };
vector<int> reserve = { 3 };

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    for (int i = 0; i < n; i++) {
        student[i] = 1;
    }
    for (int i = 0; i < lost.size(); i++) {
        student[lost[i] - 1]--;
    }
    for (int i = 0; i < reserve.size(); i++) {
        student[reserve[i] - 1]++;
    }

    for (int i = 0; i < n; i++) {
        if (student[i] == 0) {
            if (i == 0) { //첫번째 학생이 체육복을 잃어버린경우
                if (student[1] > 1) { //두번째 학생이 빌려줄수있다면
                    student[i]++; student[1]--;
                }
            }
            else if (i == n - 1) { //마지막 학생이 체육복을 잃어버린경우
                if (student[n - 2] > 1) { //바로앞순서 학생이 빌려줄수있다면
                    student[i]++; student[n - 2]--;
                }
            }
            else { //위의 경우가 아니라면
                if (student[i - 1] > 1) {
                    student[i]++; student[i - 1]--;
                }
                if (student[i + 1] > 1) {
                    student[i]++; student[i + 1]--;
                }
            }
        }
    }
    for (int n : student)if (n > 0)answer++;
    return answer;
}

int main() {
    cout << solution(n, lost, reserve);
}